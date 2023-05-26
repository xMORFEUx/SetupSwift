package com.example.cfp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import com.example.cfp.databinding.ActivityPerfilBinding;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;



public class Perfil_Activity extends AppCompatActivity {

    private PieChart pieChart;
    private CircularProgressIndicator circularProgressIndicator;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private ActivityPerfilBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPerfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference categoriaRef = database.getReference("Usuarios").child("UID").child("Gastos_Educação");

        categoriaRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                double educacao = 0.0;

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Object value = snapshot.getValue();

                    if (value instanceof Double) {
                        double valor = (double) value;
                        educacao += valor;
                    } else if (value instanceof Long) {
                        double valor = ((Long) value).doubleValue();
                        educacao += valor;
                    }

                }

                binding.value.setText(String.valueOf(educacao));
                pieChart = binding.pieChart;

                ArrayList<PieEntry> categorias = new ArrayList<>();
                categorias.add(new PieEntry(200, "Educação"));
                categorias.add(new PieEntry(330, "Alimentação"));
                categorias.add(new PieEntry(700, "Lazer"));
                categorias.add(new PieEntry(240, "Saúde"));
                categorias.add(new PieEntry(120, "Transporte"));
                categorias.add(new PieEntry(370, "Outros"));

                PieDataSet pieDataSet = new PieDataSet(categorias, "");
                pieDataSet.setColors(getResources().getColor(R.color.purple_200),
                        getResources().getColor(R.color.green),
                        getResources().getColor(R.color.red),
                        getResources().getColor(R.color.teal_700),
                        getResources().getColor(R.color.purple_500),
                        getResources().getColor(R.color.yellow));
                pieDataSet.setSliceSpace(2f);
                pieDataSet.setValueTextColor(Color.WHITE);
                pieDataSet.setValueTextSize(10f);
                pieDataSet.setSliceSpace(1f);

                PieData pieData = new PieData(pieDataSet);

                pieChart.setData(pieData);
                pieChart.getDescription().setEnabled(false);
                pieChart.animate();
                pieChart.setHoleColor(android.R.color.transparent);
                pieChart.setEntryLabelTextSize(10f);
                pieChart.invalidate();
                pieChart.setDrawEntryLabels(false);
                pieChart.setHoleRadius(75);
                pieChart.getDescription().setEnabled(false);

                Legend legend = pieChart.getLegend();
                legend.setForm(Legend.LegendForm.CIRCLE);
                legend.setTextSize(10);
                legend.setTextColor(Color.WHITE);
                legend.setFormSize(15);
                legend.setFormToTextSpace(4);
                legend.setDrawInside(false);
                legend.setXEntrySpace(6f);
                legend.setYEntrySpace(10f);
                legend.setWordWrapEnabled(true);
//                legend.setVerticalAlignment(Legend.LegendVerticalAlignment.CENTER);
//                legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
                legend.setOrientation(Legend.LegendOrientation.VERTICAL);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Trate os erros, se necessário
            }
        });
    }
}