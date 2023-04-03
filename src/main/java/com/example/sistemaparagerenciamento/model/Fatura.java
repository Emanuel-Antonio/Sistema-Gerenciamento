package com.example.sistemaparagerenciamento.model;

import java.util.List;

public class Fatura {
    private Double valorTotal;

    private List<Pagamento> pagamentos;

    private int ordemId;

    private Double valorPago;

    private int faturaId;

    public Fatura(Double valorTotal, int ordemId) {
        this.valorTotal = valorTotal;
        this.ordemId = ordemId;
        this.valorPago = 0.0;
    }

    public Double getValorTotal() {
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

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago += valorPago;
    }

    public int getFaturaId() {
        return faturaId;
    }

    public void setFaturaId(int faturaId) {
        this.faturaId = faturaId;
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
