package com.example.ss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.ss.databinding.ActivityListaProdutosBinding;
import com.example.ss.model.Produto;
import com.example.ss.adapter.AdapterProduto;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class ListaProdutos_Activity extends AppCompatActivity {

    DatabaseReference databaseReference;

    String usuarioID;

    String categoria1, categoria2, categoria3;
    String msg = "É necesário inserir algum valor para que possamos prosseguir.";
    int setup;

    private ActivityListaProdutosBinding binding;

    private RecyclerView recyclerView;

    private AdapterProduto adapterProduto;

    private List<Produto> productList;
    private NumberFormat numberFormat = new DecimalFormat("###");

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListaProdutosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Usuarios").child(usuarioID);

        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    categoria1 = dataSnapshot.child("Categoria1").getValue(String.class);
                    categoria2 = dataSnapshot.child("Categoria2").getValue(String.class);
                    categoria3 = dataSnapshot.child("Categoria3").getValue(String.class);

                    productList = new ArrayList<>();

                    if ("Valor1".equals(categoria2)){
                        productList.add(new Produto(R.drawable.placamae3, R.string.placamae3, R.string.descplacamae3, R.string.valorplacamae3));
                        productList.add(new Produto(R.drawable.processador2, R.string.processador2, R.string.descprocessador2, R.string.valorprocessador2));
                        productList.add(new Produto(R.drawable.placadevideo2, R.string.placadevideo2, R.string.descplacadevideo2,R.string.valorplacadevideo2));
                        productList.add(new Produto(R.drawable.ssd2, R.string.ssd2, R.string.descssd2, R.string.valorssd2));
                        productList.add(new Produto(R.drawable.memoria_2, R.string.memoria2, R.string.descmemoria2,R.string.valormemoria2));
                        productList.add(new Produto(R.drawable.teclado2, R.string.teclado2, R.string.descteclado2, R.string.valorteclado2));
                        productList.add(new Produto(R.drawable.mouse, R.string.mouse1, R.string.descmouse1, R.string.valormouse1));
                        productList.add(new Produto(R.drawable.gabinete3, R.string.gabinete3, R.string.descgabinete3, R.string.valorgabinete3));
                        binding.valor.setText("Valor total do Setup: R$ 2.229,93");

                    } else if ("Valor2".equals(categoria2)){
                        productList.add(new Produto(R.drawable.placamae2, R.string.placamae2, R.string.descplacamae2, R.string.valorplacamae2));
                        productList.add(new Produto(R.drawable.processador, R.string.processador1, R.string.descprocessador1, R.string.valorprocessador1));
                        productList.add(new Produto(R.drawable.placadevideo3, R.string.placadevideo3, R.string.descplacadevideo3,R.string.valorplacadevideo3));
                        productList.add(new Produto(R.drawable.ssd2, R.string.ssd3, R.string.descssd3, R.string.valorssd3));
                        productList.add(new Produto(R.drawable.memoria_3, R.string.memoria3, R.string.descmemoria3,R.string.valormemoria3));
                        productList.add(new Produto(R.drawable.teclado, R.string.teclado1, R.string.descteclado1, R.string.valorteclado1));
                        productList.add(new Produto(R.drawable.mouse3, R.string.mouse3, R.string.descmouse3, R.string.valormouse3));
                        productList.add(new Produto(R.drawable.gabinete, R.string.gabinete1, R.string.descgabinete1, R.string.valorgabinete1));
                        binding.valor.setText("Valor total do Setup: R$ 4.565,97");

                    } else if ("Valor3".equals(categoria2)) {
                        productList.add(new Produto(R.drawable.placamae1, R.string.placamae1, R.string.descplacamae1, R.string.valorplacamae1));
                        productList.add(new Produto(R.drawable.processador3, R.string.processador3, R.string.descprocessador3, R.string.valorprocessador3));
                        productList.add(new Produto(R.drawable.placadevideo, R.string.placadevideo1, R.string.descplacadevideo1, R.string.valorplacadevideo1));
                        productList.add(new Produto(R.drawable.ssd, R.string.ssd1, R.string.descssd1, R.string.valorssd1));
                        productList.add(new Produto(R.drawable.memoria, R.string.memoria1, R.string.descmemoria1, R.string.valormemoria1));
                        productList.add(new Produto(R.drawable.teclado3, R.string.teclado3, R.string.descteclado3, R.string.valorteclado3));
                        productList.add(new Produto(R.drawable.mouse2, R.string.mouse2, R.string.descmouse2, R.string.valormouse2));
                        productList.add(new Produto(R.drawable.gabinete, R.string.gabinete1, R.string.descgabinete1, R.string.valorgabinete1));
                        binding.valor.setText("Valor total do Setup: R$ 18.452,95");
                    }

                    if (productList != null) {
                        recyclerView = findViewById(R.id.containerCompoments_2);
                        recyclerView.setLayoutManager(new LinearLayoutManager(ListaProdutos_Activity.this));

                        if (adapterProduto == null){
                            adapterProduto = new AdapterProduto(productList);
                            recyclerView.setAdapter(adapterProduto);
                        }else{
                            adapterProduto.notifyDataSetChanged();
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        binding.menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaProdutos_Activity.this, PrimeirosPassos_Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    private String formatCurrency(double value){
        return numberFormat.format(value);
    }

}