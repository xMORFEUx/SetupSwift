package com.example.cfp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cfp.databinding.ActivityExtratoBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Extrato_Activity extends AppCompatActivity {


    String usuarioID;
    ActivityExtratoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExtratoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        LinearLayout linearLayout = binding.linearLayout;

        binding.btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Extrato_Activity.this, Login_Activity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Extrato_Activity.this, Categorias_Activity.class);
                startActivity(intent);
            }
        });

        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Usuarios").child(usuarioID);
        DatabaseReference objetivoGastosRef = userRef.child("Objetivo_Gastos");
        DatabaseReference gastosGeraisRef = userRef.child("Gastos_Gerais");

        objetivoGastosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Obtém o valor do nó Objetivo_Gastos
                    double objetivoGastos = dataSnapshot.getValue(Double.class);


                    // Recupera o valor total dos gastos gerais
                    gastosGeraisRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            long total = 0;

                            for (DataSnapshot gastoSnapshot : dataSnapshot.getChildren()) {
                                // Obtém o valor de cada nó filho
                                Long valor = gastoSnapshot.getValue(Long.class);

                                // Adiciona o valor ao total
                                if (valor != null) {
                                    total += valor;
                                }
                            }

                            // Subtrai o valor de objetivoGastos do total
                            long resto = (long) (objetivoGastos - total);

                            // Preenche a EditText com o valor obtido
                            binding.txtValue.setText("R$ " + String.valueOf(resto));
                            // Exibe o total no TextView
                            EditText editText = new EditText(Extrato_Activity.this);
                            binding.txtRestante.setText("R$ " + total);
                            editText.setTextColor(Color.GREEN);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            // Trata erros de leitura do banco de dados, se necessário
                        }
                    });
                } else {
                    // Se o nó não existir, define um valor padrão ou vazio na EditText
                    binding.txtValue.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Trata erros de leitura do banco de dados, se necessário
            }
        });


        gastosGeraisRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                linearLayout.removeAllViews();

                for (DataSnapshot categorySnapshot : dataSnapshot.getChildren()){
                    String categoryKey = categorySnapshot.getKey();
                    Long valueLong = categorySnapshot.getValue(Long.class);

                    String value = String.valueOf(valueLong);

                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    TextView textView = new TextView(Extrato_Activity.this);
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                    textView.setTextColor(Color.BLACK);

                    String formattedText;

                    switch (categoryKey) {
                        case "Alimentação":
                            formattedText = String.format("%-73s %s", categoryKey + ":", "R$ " + value);
                            break;
                        case "Educação":
                            formattedText = String.format("%-75s %s", categoryKey + ":", "R$ " + value);
                            break;
                        case "Lazer":
                            formattedText = String.format("%-80s %s", categoryKey + ":", "R$ " + value);
                            break;
                        case "Outros":
                            formattedText = String.format("%-79s %s", categoryKey + ":", "R$ " + value);
                            break;
                        case "Saude":
                            formattedText = String.format("%-79s %s", categoryKey + ":", "R$ " + value);
                            break;
                        case "Transporte":
                            formattedText = String.format("%-75s %s", categoryKey + ":", "R$ " + value);
                            break;
                        default:
                            formattedText = String.format("%-15s %s", categoryKey + ":", "R$ " + value);
                            break;
                    }

                    textView.setText(formattedText);

                    layoutParams.setMargins(0, 0, 0, 16);
                    textView.setLayoutParams(layoutParams);
                    linearLayout.addView(textView);

                    final String categoryKeyFinal = categoryKey; // Variável final para uso dentro do OnClickListener

                    textView.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Extrato_Activity.this);
                            builder.setTitle("");

                            // Infla o layout customizado para o AlertDialog
                            View dialogView = LayoutInflater.from(Extrato_Activity.this).inflate(R.layout.dialog_editar_categoria, null);
                            builder.setView(dialogView);

                            final EditText editTextValor = dialogView.findViewById(R.id.editTextValor);
                            Button buttonEditar = dialogView.findViewById(R.id.buttonEditar);
                            Button buttonExcluir = dialogView.findViewById(R.id.buttonExcluir);

                            // Preenche o EditText com o valor atual da categoria
                            String value = String.valueOf(valueLong);

                            final AlertDialog dialog = builder.create();
                            dialog.show();

                            // Define o clique do botão "Editar"
                            buttonEditar.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String novoValorStr = editTextValor.getText().toString().trim();

                                    if (!TextUtils.isEmpty(novoValorStr)) {
                                        long novoValor = Long.parseLong(novoValorStr);

                                        // Atualiza o valor da categoria no FirebaseDatabase
                                        categorySnapshot.getRef().setValue(novoValor)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Toast.makeText(Extrato_Activity.this, "Valor da categoria atualizado com sucesso", Toast.LENGTH_SHORT).show();
                                                            dialog.dismiss();
                                                        } else {
                                                            Toast.makeText(Extrato_Activity.this, "Falha ao atualizar o valor da categoria", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });
                                    } else {
                                        Toast.makeText(Extrato_Activity.this, "Digite um valor válido", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                            // Define o clique do botão "Excluir"
                            buttonExcluir.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    // Remove a categoria do FirebaseDatabase
                                    categorySnapshot.getRef().removeValue()
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(Extrato_Activity.this, "Categoria excluída com sucesso", Toast.LENGTH_SHORT).show();
                                                        dialog.dismiss();
                                                    } else {
                                                        Toast.makeText(Extrato_Activity.this, "Falha ao excluir a categoria", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });
                                }
                            });

                            return true;
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Trata erros de leitura do banco de dados, se necessário
            }
        });

    }
}