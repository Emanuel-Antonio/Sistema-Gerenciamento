package com.example.sistemaparagerenciamento.model;

public class Pagamento {
    private String tipoPagamento;

    private Double valor;

    private int faturaId;

    public Pagamento(String tipoPagamento, Double valor, int faturaId) {
        this.tipoPagamento = tipoPagamento;
        this.valor = valor;
        this.faturaId = faturaId;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public Double getValor() {
        return valor;
    }


    public int getFaturaId() {
        return faturaId;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
