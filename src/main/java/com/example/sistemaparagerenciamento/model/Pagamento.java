package com.example.sistemaparagerenciamento.model;

public class Pagamento {
    private String tipoPagamento;

    private Double valor;

    private Integer faturaId;

    public Pagamento(String tipoPagamento, Double valor, Integer faturaId) {
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

    public Integer getFaturaId() {
        return faturaId;
    }
}
