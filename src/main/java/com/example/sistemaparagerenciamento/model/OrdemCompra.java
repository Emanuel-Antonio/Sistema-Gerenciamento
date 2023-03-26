package com.example.sistemaparagerenciamento.model;

public class OrdemCompra {

    private Peca peca;

    private Integer qnt;

    private Double valorunitario;

    public OrdemCompra(Peca peca, Integer qnt, Double valorunitario) {
        this.peca = peca;
        this.qnt = qnt;
        this.valorunitario = valorunitario;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
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

    public void setValorunitario(Double valorunitario) {
        this.valorunitario = valorunitario;
    }
}
