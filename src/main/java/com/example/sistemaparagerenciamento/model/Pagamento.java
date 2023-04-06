package com.example.sistemaparagerenciamento.model;

public class Pagamento {
    private String tipoPagamento;

    private Double valor;

    private int faturaId;

    private int pagamentoId;

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
        if(obj instanceof Pagamento){
            Pagamento p = (Pagamento) obj;
            if(p.getPagamentoId() == this.pagamentoId){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(int pagamentoId) {
        this.pagamentoId = pagamentoId;
    }
}
