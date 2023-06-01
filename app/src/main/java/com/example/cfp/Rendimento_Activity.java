package com.example.cfp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import com.example.cfp.databinding.ActivityRendimentoBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Rendimento_Activity extends AppCompatActivity {

    DatabaseReference databaseReference;

    String usuarioID;

    String msg = "É necesário inserir algum valor para que possamos prosseguir.";

    private ActivityRendimentoBinding binding;

    private NumberFormat numberFormat = new DecimalFormat("##,###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRendimentoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.ValorSeek.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()){
                    int value = Integer.parseInt(s.toString().replaceAll("[^\\^\\d]", ""));
                    binding.seekBar.setProgress(value);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String value = numberFormat.format(progress);
                binding.ValorSeek.setText(value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.btRenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    try {
                        usuarioID =FirebaseAuth.getInstance().getCurrentUser().getUid();
                        String rendaString = binding.ValorSeek.getText().toString();
                        double renda = Double.parseDouble(rendaString);

                        databaseReference = FirebaseDatabase.getInstance().getReference("Usuarios");
                        databaseReference.child(usuarioID).child("Renda_Mensal").setValue(renda);

                    } catch (Exception e) {

                    }
                    Snackbar snackbar = Snackbar.make(v, msg, Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);

                    Intent intent = new Intent(Rendimento_Activity.this, Gastos_Activity.class);
                    startActivity(intent);
                }
        });

    }
    private String formatCurrency(double value){
        return numberFormat.format(value);
    }

    private double parseDoubleFromCurrencyString(String currencyString){
        try{
            return numberFormat.parse(currencyString).doubleValue();
        } catch (Exception e){
            return 0.0;
        }
    }
}