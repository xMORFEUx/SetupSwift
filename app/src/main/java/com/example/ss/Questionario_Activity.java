package com.example.ss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;

import com.example.ss.databinding.ActivityQuestionarioBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Questionario_Activity extends AppCompatActivity implements View.OnClickListener {

    CheckBox jogos, trabalho, edicao, web, estudo , valor1, valor2, valor3, valor4, sim, nao;

    String usuarioID;

    String  categoria1, categoria2, categoria3;
    DatabaseReference databaseReference;
    String msg = "É necesário selecionar uma das opções para que possamos prosseguir.";
    private ActivityQuestionarioBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        jogos = (CheckBox) binding.jogos;
        jogos.setOnClickListener(this);
        trabalho = (CheckBox) binding.trabalho;
        trabalho.setOnClickListener(this);
        edicao = (CheckBox) binding.edicao;
        edicao.setOnClickListener(this);
        web = (CheckBox) binding.web;
        web.setOnClickListener(this);
        estudo = (CheckBox) binding.estudo;
        estudo.setOnClickListener(this);
        valor1 = (CheckBox) binding.valor1;
        valor1.setOnClickListener(this);
        valor2 = (CheckBox) binding.valor2;
        valor2.setOnClickListener(this);
        valor3 = (CheckBox) binding.valor3;
        valor3.setOnClickListener(this);
        sim = (CheckBox) binding.sim;
        sim.setOnClickListener(this);
        nao = (CheckBox) binding.nao;
        nao.setOnClickListener(this);


        binding.btAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!jogos.isChecked() && !estudo.isChecked() && !web.isChecked() && !trabalho.isChecked() && !edicao.isChecked()) {

                    Snackbar snackbar = Snackbar.make(v, "Selecione uma das opções para prosseguir", Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else {
                    binding.question1.setText(R.string.question_2);
                    binding.questionario1.setVisibility(View.GONE);
                    binding.questionario2.setVisibility(View.VISIBLE);
                    binding.btAvancar.setVisibility(View.GONE);
                    binding.btAvancar2.setVisibility(View.VISIBLE);
                }
            }
        });
        binding.btAvancar2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!valor1.isChecked() && !valor2.isChecked() && !valor3.isChecked()) {

                    Snackbar snackbar = Snackbar.make(v, "Selecione uma das opções para prosseguir", Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else {
                    binding.question1.setText(R.string.question_3);
                    binding.questionario2.setVisibility(View.GONE);
                    binding.questionario3.setVisibility(View.VISIBLE);
                    binding.btAvancar2.setVisibility(View.GONE);
                    binding.btAvancar3.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.btAvancar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!sim.isChecked() && !nao.isChecked()) {

                    Snackbar snackbar = Snackbar.make(v, "Selecione uma das opções para prosseguir", Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else {

                    binding.progressbar.setVisibility(View.VISIBLE);
                    binding.txtLoad.setVisibility(View.VISIBLE);
                    binding.btAvancar3.setVisibility(View.GONE);
                    binding.questionario3.setVisibility(View.GONE);
                    binding.question1.setVisibility(View.GONE);
                    binding.image1.setVisibility(View.GONE);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        TelaPrincipal();

                    }
                },2000);

            }
        });

        binding.menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Questionario_Activity.this, PrimeirosPassos_Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void TelaPrincipal(){

        Intent intent = new Intent(Questionario_Activity.this, ListaProdutos_Activity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        
        switch (view.getId()){
            case R.id.jogos:
                if(jogos.isChecked())
//                    Toast.makeText(getApplicationContext(), "Jogos", Toast.LENGTH_LONG).show();
                    binding.trabalho.setChecked(false);
                    binding.edicao.setChecked(false);
                    binding.web.setChecked(false);
                    binding.estudo.setChecked(false);
                    categoria1 = "Jogos";
                break;
            case R.id.trabalho:
                if(trabalho.isChecked())
//                    Toast.makeText(getApplicationContext(), "Trabalho", Toast.LENGTH_LONG).show();
                    binding.jogos.setChecked(false);
                    binding.edicao.setChecked(false);
                    binding.web.setChecked(false);
                    binding.estudo.setChecked(false);
                    categoria1 = "Trabalho";
                break;
            case R.id.edicao:
                if(edicao.isChecked())
//                    Toast.makeText(getApplicationContext(), "Edição", Toast.LENGTH_LONG).show();
                    binding.trabalho.setChecked(false);
                    binding.jogos.setChecked(false);
                    binding.web.setChecked(false);
                    binding.estudo.setChecked(false);
                    categoria1 = "Edição";
                break;
            case R.id.web:
                if(web.isChecked())
//                    Toast.makeText(getApplicationContext(), "Web", Toast.LENGTH_LONG).show();
                    binding.trabalho.setChecked(false);
                    binding.edicao.setChecked(false);
                    binding.jogos.setChecked(false);
                    binding.estudo.setChecked(false);
                    categoria1 = "Web";
                break;
            case R.id.estudo:
                if(estudo.isChecked())
//                    Toast.makeText(getApplicationContext(), "Estudo", Toast.LENGTH_LONG).show();
                    binding.trabalho.setChecked(false);
                    binding.edicao.setChecked(false);
                    binding.web.setChecked(false);
                    binding.jogos.setChecked(false);
                    categoria1 = "Estudo";
                break;
            case R.id.valor_1:
                if(valor1.isChecked())
//                    Toast.makeText(getApplicationContext(), "Estudo", Toast.LENGTH_LONG).show();
                    binding.valor2.setChecked(false);
                binding.valor3.setChecked(false);
                categoria2 = "Valor1";
                break;
            case R.id.valor_2:
                if(valor2.isChecked())
//                    Toast.makeText(getApplicationContext(), "Estudo", Toast.LENGTH_LONG).show();
                    binding.valor1.setChecked(false);
                binding.valor3.setChecked(false);
                categoria2 = "Valor2";
                break;
            case R.id.valor_3:
                if(valor3.isChecked())
//                    Toast.makeText(getApplicationContext(), "Estudo", Toast.LENGTH_LONG).show();
                    binding.valor1.setChecked(false);
                binding.valor2.setChecked(false);
                categoria2 = "Valor3";
                break;
            case R.id.sim:
                if(sim.isChecked())
//                    Toast.makeText(getApplicationContext(), "Estudo", Toast.LENGTH_LONG).show();
                    binding.nao.setChecked(false);
                categoria3 = "Sim";
                break;
            case R.id.nao:
                if(nao.isChecked())
//                    Toast.makeText(getApplicationContext(), "Estudo", Toast.LENGTH_LONG).show();
                    binding.sim.setChecked(false);
                categoria3 = "Não";
                break;
        }

        SalvarDadosUsuario();

    }
    private void SalvarDadosUsuario(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("Usuarios");
        databaseReference.child(usuarioID).child("Categoria1").setValue(categoria1);
        databaseReference.child(usuarioID).child("Categoria2").setValue(categoria2);
        databaseReference.child(usuarioID).child("Categoria3").setValue(categoria3);


    }
}