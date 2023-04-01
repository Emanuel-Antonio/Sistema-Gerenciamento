package com.example.sistemaparagerenciamento.model;

public class OrdemCompra {

    private Integer qnt;

    private Double valorUnitario;

    private String nome;

    public OrdemCompra(Integer qnt, Double valorUnitario, String nome) {
        this.qnt = qnt;
        this.valorUnitario = valorUnitario;
        this.nome = nome;
    }

    public Integer getQnt() {
        return qnt;
    }

    public void setQnt(Integer qnt) {
        this.qnt = qnt;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
