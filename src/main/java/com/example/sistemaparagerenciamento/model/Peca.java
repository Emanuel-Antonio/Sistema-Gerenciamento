package com.example.sistemaparagerenciamento.model;

public class Peca {

    private final String nome;
    private double valor;
    private int qnt;

    public Peca(String nome) {
        this.nome = nome;
        this.valor = 0.0;
        this.qnt = 0;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Peca p){
            return p.getNome().equals(this.getNome());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n" + "Valor: " + this.getValor() + "\n" + "Quantidade: " + this.getQnt();
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}