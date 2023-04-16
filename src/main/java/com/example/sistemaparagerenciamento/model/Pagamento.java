package com.example.sistemaparagerenciamento.model;

public class Pagamento {

    private final String tipoPagamento;
    private final double valor;
    private final Fatura fatura;
    private int pagamentoId;

    public Pagamento(String tipoPagamento, double valor, Fatura fatura) {
        this.tipoPagamento = tipoPagamento;
        this.valor = valor;
        this.fatura = fatura;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public double getValor() {
        return valor;
    }

    public Fatura getFatura() {
        return fatura;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Pagamento p){
            return p.getPagamentoId() == this.pagamentoId;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\n" + "Tipo Pagamento: " + this.getTipoPagamento() + "\n" + "Valor: " + this.getValor();
    }

    public int getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(int pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

}