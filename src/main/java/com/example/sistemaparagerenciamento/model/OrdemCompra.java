package com.example.sistemaparagerenciamento.model;

public class OrdemCompra extends Peca{

    private Integer qnt;

    public OrdemCompra(String nome, Double valor, Integer qnt) {
        super(nome, valor);
        this.qnt = qnt;
    }

    public Integer getQnt() {
        return qnt;
    }

    public void setQnt(Integer qnt) {
        this.qnt = qnt;
    }
}
