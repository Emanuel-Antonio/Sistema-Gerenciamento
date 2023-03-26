package com.example.sistemaparagerenciamento.model;

public class Pagamento {
    private String tipopagamento;

    private Double valor;

    private Integer faturaid;

    public Pagamento(Integer faturaid) {
        this.faturaid = faturaid;
    }

    public Integer getFaturaid() {
        return faturaid;
    }

    public void setFaturaid(Integer faturaid) {
        this.faturaid = faturaid;
    }

    public String getTipopagamento() {
        return tipopagamento;
    }

    public void setTipopagamento(String tipopagamento) {
        this.tipopagamento = tipopagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
