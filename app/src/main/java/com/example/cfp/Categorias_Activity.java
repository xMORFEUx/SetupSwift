package com.example.cfp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Color;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.cfp.databinding.ActivityCategoriasBinding;

public class Categorias_Activity extends AppCompatActivity {

    private ActivityCategoriasBinding binding;
    private Animation fadeInAnimation;

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
        });
        binding.btAlimentacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        binding.btLazer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        binding.btSaude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        binding.btTransp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btTransp.setBackgroundDrawable(getDrawable(R.drawable.button));
                binding.btTransp.setTextColor(Color.WHITE);
                binding.btSaude.setBackgroundDrawable(getDrawable(R.drawable.button));
                binding.btSaude.setTextColor(Color.WHITE);
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
        });
        binding.btOutros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btOutros.setBackgroundDrawable(getDrawable(R.drawable.button));
                binding.btOutros.setTextColor(Color.WHITE);
                binding.btTransp.setBackgroundDrawable(getDrawable(R.drawable.button));
                binding.btTransp.setTextColor(Color.WHITE);
                binding.btSaude.setBackgroundDrawable(getDrawable(R.drawable.button));
                binding.btSaude.setTextColor(Color.WHITE);
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
        });

    }
}