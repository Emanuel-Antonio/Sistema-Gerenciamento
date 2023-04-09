package com.example.sistemaparagerenciamento.model;

import java.util.List;

public class Fatura {
    private double valorTotal;

    private List<Pagamento> pagamentos;

    private final int ordemId;

    private double valorPago;

    public Fatura(int ordemId) {
        this.valorTotal = 0.0;
        this.ordemId = ordemId;
        this.valorPago = 0.0;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public int getOrdemId() {
        return ordemId;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago += valorPago;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Id da ordem: " + "\n" + this.getOrdemId() + "Valor total: " + "\n" + this.getValorTotal() +
                "Valor pago: " + this.getValorPago();
    }

}
