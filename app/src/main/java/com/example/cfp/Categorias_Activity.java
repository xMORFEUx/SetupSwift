package com.example.cfp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.cfp.databinding.ActivityCategoriasBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Categorias_Activity extends AppCompatActivity {

    DatabaseReference databaseReference;

    private ActivityCategoriasBinding binding;
    private Animation fadeInAnimation;

    private String instance = null;

    String usuarioID;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        fadeInAnimation = AnimationUtils.loadAnimation(this,R.anim.fade_in);

        binding.btEducacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CategoriaEducacao();
                instance = "educacao";

            }
        });
        binding.btAlimentacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CategoriaAlimentacao();
                instance = "alimentacao";
            }
        });
        binding.btLazer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CategoriaLazer();
                instance = "lazer";

            }
        });
        binding.btSaude.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View v) {

                CategoriaSaude();
                instance = "saude";

            }
        });
        binding.btTransp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CategoriaTransporte();
                instance = "transporte";

            }
        });
        binding.btOutros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CategoriaOutros();
                instance = "outros";

            }
        });

        binding.btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CategoriaInvisible();

                if (instance == "educacao"){

                    usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    String gastoString = binding.containerS1.getText().toString();
                    double gastoEdu = Double.parseDouble(gastoString);


                    databaseReference = FirebaseDatabase.getInstance().getReference("Usuarios");
                    databaseReference.child("UID").child("Gastos_Educação").push().setValue(gastoEdu);

                }else if (instance == "alimentacao"){

                    usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    String gastoString = binding.containerS1.getText().toString();
                    double gastoAlimentacao = Double.parseDouble(gastoString);

                    databaseReference = FirebaseDatabase.getInstance().getReference("Usuarios");
                    databaseReference.child("UID").child("Gastos_Alimentação").child("gasto").setValue(gastoAlimentacao);



                }else if (instance == "lazer"){

                    usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    String gastoString = binding.containerS1.getText().toString();
                    double gastoLazer = Double.parseDouble(gastoString);

                    databaseReference = FirebaseDatabase.getInstance().getReference("Usuarios");
                    databaseReference.child("UID").child("Gastos_Lazer").child("gasto").setValue(gastoLazer);

                }else if (instance == "saude"){

                    usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    String gastoString = binding.containerS1.getText().toString();
                    double gastoSaude = Double.parseDouble(gastoString);

                    databaseReference = FirebaseDatabase.getInstance().getReference("Usuarios");
                    databaseReference.child("UID").child("Gastos_Saude").child("gasto").setValue(gastoSaude);

                }else if (instance == "transporte"){

                    usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    String gastoString = binding.containerS1.getText().toString();
                    double gastoTransporte = Double.parseDouble(gastoString);

                    databaseReference = FirebaseDatabase.getInstance().getReference("Usuarios");
                    databaseReference.child("UID").child("Gastos_Transporte").child("gasto").setValue(gastoTransporte);

                }else if (instance =="outros"){

                    usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    String gastoString = binding.containerS1.getText().toString();
                    double gastoOutros = Double.parseDouble(gastoString);

                    databaseReference = FirebaseDatabase.getInstance().getReference("Usuarios");
                    databaseReference.child("UID").child("Gastos_Outros").child("gasto").setValue(gastoOutros);

                }

                binding.msgConf.setVisibility(View.VISIBLE);
                binding.msgConf.setAnimation(fadeInAnimation);
                binding.containerMsg.setVisibility(View.VISIBLE);
                binding.containerMsg.setAnimation(fadeInAnimation);
                binding.btConf.setVisibility(View.VISIBLE);
                binding.btConf.setAnimation(fadeInAnimation);

            }
        });

        binding.btConf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.msgConf.setVisibility(View.INVISIBLE);
                binding.containerMsg.setVisibility(View.INVISIBLE);
                binding.btConf.setVisibility(View.INVISIBLE);

                binding.containerS1.setText("");

                CategoriaInvisible();
                CategoriaVisible();
                if (instance == "educacao"){
                    binding.txtEducacao.setVisibility(View.VISIBLE);
                } else if (instance == "alimentacao") {
                    binding.txtAlimentacao.setVisibility(View.VISIBLE);
                } else if (instance == "lazer") {
                    binding.txtLazer.setVisibility(View.VISIBLE);
                } else if (instance == "saude") {
                    binding.txtSaude.setVisibility(View.VISIBLE);
                } else if (instance == "transporte") {
                    binding.txtTransporte.setVisibility(View.VISIBLE);
                } else if (instance == "outros") {
                    binding.txtOutros.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categorias_Activity.this, Perfil_Activity.class);
                startActivity(intent);
            }
        });

        binding.btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoriaInvisible();
            }
        });
    }

    private void CategoriaVisible(){
        binding.containerS.setVisibility(View.VISIBLE);
        binding.containerS1.setVisibility(View.VISIBLE);
        binding.btSalvar.setVisibility(View.VISIBLE);
        binding.btCancelar.setVisibility(View.VISIBLE);
    }
    private void CategoriaInvisible(){
        binding.txtEducacao.setVisibility(View.INVISIBLE);
        binding.txtAlimentacao.setVisibility(View.INVISIBLE);
        binding.txtLazer.setVisibility(View.INVISIBLE);
        binding.txtSaude.setVisibility(View.INVISIBLE);
        binding.txtTransporte.setVisibility(View.INVISIBLE);
        binding.txtOutros.setVisibility(View.INVISIBLE);
        binding.containerS.setVisibility(View.INVISIBLE);
        binding.containerS1.setVisibility(View.INVISIBLE);
        binding.btSalvar.setVisibility(View.INVISIBLE);
        binding.btCancelar.setVisibility(View.INVISIBLE);
    }
    private void CategoriaOutros(){
        binding.btOutros.setBackgroundDrawable(getDrawable(R.drawable.button));
        binding.btOutros.setTextColor(Color.WHITE);
        binding.btTransp.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btTransp.setTextColor(Color.BLACK);
        binding.btSaude.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btSaude.setTextColor(Color.BLACK);
        binding.btEducacao.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btEducacao.setTextColor(Color.BLACK);
        binding.btAlimentacao.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btAlimentacao.setTextColor(Color.BLACK);
        binding.btLazer.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btLazer.setTextColor(Color.BLACK);
        binding.btSaude.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btSaude.setTextColor(Color.BLACK);
        binding.btTransp.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btTransp.setTextColor(Color.BLACK);
        binding.containerS.setVisibility(View.VISIBLE);
        binding.containerS.startAnimation(fadeInAnimation);
        binding.containerS1.setVisibility(View.VISIBLE);
        binding.containerS1.startAnimation(fadeInAnimation);
        binding.btSalvar.setVisibility(View.VISIBLE);
        binding.btSalvar.startAnimation(fadeInAnimation);
        binding.btCancelar.setVisibility(View.VISIBLE);
        binding.btCancelar.startAnimation(fadeInAnimation);
        binding.txtOutros.startAnimation(fadeInAnimation);
        binding.txtOutros.setVisibility(View.VISIBLE);
        binding.txtAlimentacao.setVisibility(View.INVISIBLE);
        binding.txtLazer.setVisibility(View.INVISIBLE);
        binding.txtSaude.setVisibility(View.INVISIBLE);
        binding.txtTransporte.setVisibility(View.INVISIBLE);
        binding.txtEducacao.setVisibility(View.INVISIBLE);
        binding.icEduc.setVisibility(View.INVISIBLE);
        binding.icAlim.setVisibility(View.INVISIBLE);
        binding.icLazer.setVisibility(View.INVISIBLE);
        binding.icSaude.setVisibility(View.INVISIBLE);
        binding.icTransp.setVisibility(View.INVISIBLE);
        binding.icOutros.setVisibility(View.VISIBLE);
        binding.icOutros.setAnimation(fadeInAnimation);
    }
    private void CategoriaTransporte(){
        binding.btTransp.setBackgroundDrawable(getDrawable(R.drawable.button));
        binding.btTransp.setTextColor(Color.WHITE);
        binding.btSaude.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btSaude.setTextColor(Color.BLACK);
        binding.btEducacao.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btEducacao.setTextColor(Color.BLACK);
        binding.btAlimentacao.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btAlimentacao.setTextColor(Color.BLACK);
        binding.btLazer.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btLazer.setTextColor(Color.BLACK);
        binding.btSaude.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btSaude.setTextColor(Color.BLACK);
        binding.btOutros.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btOutros.setTextColor(Color.BLACK);
        binding.containerS.setVisibility(View.VISIBLE);
        binding.containerS.startAnimation(fadeInAnimation);
        binding.containerS1.setVisibility(View.VISIBLE);
        binding.containerS1.startAnimation(fadeInAnimation);
        binding.btSalvar.setVisibility(View.VISIBLE);
        binding.btSalvar.startAnimation(fadeInAnimation);
        binding.btCancelar.setVisibility(View.VISIBLE);
        binding.btCancelar.startAnimation(fadeInAnimation);
        binding.txtTransporte.startAnimation(fadeInAnimation);
        binding.txtTransporte.setVisibility(View.VISIBLE);
        binding.txtAlimentacao.setVisibility(View.INVISIBLE);
        binding.txtLazer.setVisibility(View.INVISIBLE);
        binding.txtSaude.setVisibility(View.INVISIBLE);
        binding.txtEducacao.setVisibility(View.INVISIBLE);
        binding.txtOutros.setVisibility(View.INVISIBLE);
        binding.icEduc.setVisibility(View.INVISIBLE);
        binding.icAlim.setVisibility(View.INVISIBLE);
        binding.icLazer.setVisibility(View.INVISIBLE);
        binding.icSaude.setVisibility(View.INVISIBLE);
        binding.icTransp.setVisibility(View.VISIBLE);
        binding.icTransp.setAnimation(fadeInAnimation);
        binding.icOutros.setVisibility(View.INVISIBLE);
    }
    private void CategoriaSaude(){
        binding.btSaude.setBackgroundDrawable(getDrawable(R.drawable.button));
        binding.btSaude.setTextColor(Color.WHITE);
        binding.btEducacao.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btEducacao.setTextColor(Color.BLACK);
        binding.btAlimentacao.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btAlimentacao.setTextColor(Color.BLACK);
        binding.btLazer.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btLazer.setTextColor(Color.BLACK);
        binding.btTransp.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btTransp.setTextColor(Color.BLACK);
        binding.btOutros.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btOutros.setTextColor(Color.BLACK);
        binding.containerS.setVisibility(View.VISIBLE);
        binding.containerS.startAnimation(fadeInAnimation);
        binding.containerS1.setVisibility(View.VISIBLE);
        binding.containerS1.startAnimation(fadeInAnimation);
        binding.btSalvar.setVisibility(View.VISIBLE);
        binding.btSalvar.startAnimation(fadeInAnimation);
        binding.btCancelar.setVisibility(View.VISIBLE);
        binding.btCancelar.startAnimation(fadeInAnimation);
        binding.txtSaude.setVisibility(View.VISIBLE);
        binding.txtAlimentacao.setVisibility(View.INVISIBLE);
        binding.txtLazer.setVisibility(View.INVISIBLE);
        binding.txtEducacao.setVisibility(View.INVISIBLE);
        binding.txtTransporte.setVisibility(View.INVISIBLE);
        binding.txtOutros.setVisibility(View.INVISIBLE);
        binding.txtSaude.startAnimation(fadeInAnimation);
        binding.icEduc.setVisibility(View.INVISIBLE);
        binding.icAlim.setVisibility(View.INVISIBLE);
        binding.icLazer.setVisibility(View.INVISIBLE);
        binding.icSaude.setVisibility(View.VISIBLE);
        binding.icSaude.setAnimation(fadeInAnimation);
        binding.icTransp.setVisibility(View.INVISIBLE);
        binding.icOutros.setVisibility(View.INVISIBLE);
    }
    private void CategoriaAlimentacao(){
        binding.btAlimentacao.setBackgroundDrawable(getDrawable(R.drawable.button));
        binding.btAlimentacao.setTextColor(Color.WHITE);
        binding.btEducacao.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btEducacao.setTextColor(Color.BLACK);
        binding.btLazer.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btLazer.setTextColor(Color.BLACK);
        binding.btSaude.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btSaude.setTextColor(Color.BLACK);
        binding.btTransp.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btTransp.setTextColor(Color.BLACK);
        binding.btOutros.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btOutros.setTextColor(Color.BLACK);
        binding.containerS.setVisibility(View.VISIBLE);
        binding.containerS.startAnimation(fadeInAnimation);
        binding.containerS1.setVisibility(View.VISIBLE);
        binding.containerS1.startAnimation(fadeInAnimation);
        binding.btSalvar.setVisibility(View.VISIBLE);
        binding.btSalvar.startAnimation(fadeInAnimation);
        binding.btCancelar.setVisibility(View.VISIBLE);
        binding.btCancelar.startAnimation(fadeInAnimation);
        binding.txtAlimentacao.startAnimation(fadeInAnimation);
        binding.txtAlimentacao.setVisibility(View.VISIBLE);
        binding.txtEducacao.setVisibility(View.INVISIBLE);
        binding.txtLazer.setVisibility(View.INVISIBLE);
        binding.txtSaude.setVisibility(View.INVISIBLE);
        binding.txtTransporte.setVisibility(View.INVISIBLE);
        binding.txtOutros.setVisibility(View.INVISIBLE);
        binding.icEduc.setVisibility(View.INVISIBLE);
        binding.icAlim.setVisibility(View.VISIBLE);
        binding.icAlim.setAnimation(fadeInAnimation);
        binding.icLazer.setVisibility(View.INVISIBLE);
        binding.icSaude.setVisibility(View.INVISIBLE);
        binding.icTransp.setVisibility(View.INVISIBLE);
        binding.icOutros.setVisibility(View.INVISIBLE);
    }
    private void CategoriaEducacao(){
        binding.btEducacao.setBackgroundDrawable(getDrawable(R.drawable.button));
        binding.btEducacao.setTextColor(Color.WHITE);
        binding.btAlimentacao.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btAlimentacao.setTextColor(Color.BLACK);
        binding.btLazer.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btLazer.setTextColor(Color.BLACK);
        binding.btSaude.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btSaude.setTextColor(Color.BLACK);
        binding.btTransp.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btTransp.setTextColor(Color.BLACK);
        binding.btOutros.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btOutros.setTextColor(Color.BLACK);
        binding.containerS.setVisibility(View.VISIBLE);
        binding.containerS.startAnimation(fadeInAnimation);
        binding.containerS1.setVisibility(View.VISIBLE);
        binding.containerS1.startAnimation(fadeInAnimation);
        binding.btSalvar.setVisibility(View.VISIBLE);
        binding.btSalvar.startAnimation(fadeInAnimation);
        binding.btCancelar.setVisibility(View.VISIBLE);
        binding.btCancelar.startAnimation(fadeInAnimation);
        binding.txtEducacao.startAnimation(fadeInAnimation);
        binding.txtEducacao.setVisibility(View.VISIBLE);
        binding.txtAlimentacao.setVisibility(View.INVISIBLE);
        binding.txtLazer.setVisibility(View.INVISIBLE);
        binding.txtSaude.setVisibility(View.INVISIBLE);
        binding.txtTransporte.setVisibility(View.INVISIBLE);
        binding.txtOutros.setVisibility(View.INVISIBLE);
        binding.icEduc.setVisibility(View.VISIBLE);
        binding.icEduc.setAnimation(fadeInAnimation);
        binding.icAlim.setVisibility(View.INVISIBLE);
        binding.icLazer.setVisibility(View.INVISIBLE);
        binding.icSaude.setVisibility(View.INVISIBLE);
        binding.icTransp.setVisibility(View.INVISIBLE);
        binding.icOutros.setVisibility(View.INVISIBLE);
    }
    private void CategoriaLazer(){
        binding.btLazer.setBackgroundDrawable(getDrawable(R.drawable.button));
        binding.btLazer.setTextColor(Color.WHITE);
        binding.btEducacao.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btEducacao.setTextColor(Color.BLACK);
        binding.btAlimentacao.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btAlimentacao.setTextColor(Color.BLACK);
        binding.btSaude.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btSaude.setTextColor(Color.BLACK);
        binding.btTransp.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btTransp.setTextColor(Color.BLACK);
        binding.btOutros.setBackgroundDrawable(getDrawable(R.drawable.button_cat));
        binding.btOutros.setTextColor(Color.BLACK);
        binding.containerS.setVisibility(View.VISIBLE);
        binding.containerS.startAnimation(fadeInAnimation);
        binding.containerS1.setVisibility(View.VISIBLE);
        binding.containerS1.startAnimation(fadeInAnimation);
        binding.btSalvar.setVisibility(View.VISIBLE);
        binding.btSalvar.startAnimation(fadeInAnimation);
        binding.btCancelar.setVisibility(View.VISIBLE);
        binding.btCancelar.startAnimation(fadeInAnimation);
        binding.txtLazer.startAnimation(fadeInAnimation);
        binding.txtLazer.setVisibility(View.VISIBLE);
        binding.txtEducacao.setVisibility(View.INVISIBLE);
        binding.txtAlimentacao.setVisibility(View.INVISIBLE);
        binding.txtSaude.setVisibility(View.INVISIBLE);
        binding.txtTransporte.setVisibility(View.INVISIBLE);
        binding.txtOutros.setVisibility(View.INVISIBLE);
        binding.icEduc.setVisibility(View.INVISIBLE);
        binding.icAlim.setVisibility(View.INVISIBLE);
        binding.icLazer.setVisibility(View.VISIBLE);
        binding.icLazer.setAnimation(fadeInAnimation);
        binding.icSaude.setVisibility(View.INVISIBLE);
        binding.icTransp.setVisibility(View.INVISIBLE);
        binding.icOutros.setVisibility(View.INVISIBLE);
    }
}