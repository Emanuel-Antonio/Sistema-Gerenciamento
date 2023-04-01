package com.example.sistemaparagerenciamento.model;

public class OrdemCompra {

    private Integer qnt;

    private Double valorunitario;

    private String nome;

    public OrdemCompra(Integer qnt, Double valorunitario, String nome) {
        this.qnt = qnt;
        this.valorunitario = valorunitario;
        this.nome = nome;
    }

    public Integer getQnt() {
        return qnt;
    }

    public void setQnt(Integer qnt) {
        this.qnt = qnt;
    }

    public Double getValorunitario() {
        return valorunitario;
    }

    public void setValor(Double valorunitario) {
        this.valorunitario = valorunitario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
