package com.example.cfp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cfp.databinding.ActivityExtratoBinding;
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



        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Usuarios").child(usuarioID);
        DatabaseReference objetivoGastosRef = userRef.child("Objetivo_Gastos");
        DatabaseReference gastosGeraisRef = userRef.child("Gastos_Gerais");


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

                // Exibe o total no TextView
                binding.txtRestante.setText("R$ " + total);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Trata erros de leitura do banco de dados, se necessário
            }
        });
        objetivoGastosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Obtém o valor do nó Objetivo_Gastos
                    double objetivoGastos = dataSnapshot.getValue(Double.class);

                    // Preenche a EditText com o valor obtido
                    binding.txtValue.setText("R$ " + String.valueOf(objetivoGastos));
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
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Trata erros de leitura do banco de dados, se necessário
            }
        });

    }
}