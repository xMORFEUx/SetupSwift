package com.example.cfp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cfp.databinding.ActivityExtratoBinding;


public class Extrato_Activity extends AppCompatActivity {

    ActivityExtratoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExtratoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();


    }
}