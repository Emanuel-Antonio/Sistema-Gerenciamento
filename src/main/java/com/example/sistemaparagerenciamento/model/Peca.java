package com.example.sistemaparagerenciamento.model;

public class Peca {

    private String nome;

    private Double valor;

    public Peca(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }


    public Double getValor() {
        return valor;
    }

}
