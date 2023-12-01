package com.example.ss.model;

import android.text.Html;

public class Produto {

    private int foto, nome, descricao, preco;

    public Produto(int foto, int nome, int descricao, int preco) {

        this.foto = foto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;

    }

    public int getFoto(){
        return foto;
    }

    public void setFoto(int foto){
        this.foto = foto;
    }

    public int getNome(){
        return nome;
    }

    public void setNome(int nome){
        this.nome = nome;
    }

    public int getDescricao(){
        return descricao;
    }

    public void setDescricao(int desricao){
        this.descricao = desricao;
    }

    public int getPreco(){
        return preco;
    }

    public void setPreco(int preco){
        this.preco = preco;
    }
}
