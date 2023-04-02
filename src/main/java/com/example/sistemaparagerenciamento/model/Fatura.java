package com.example.sistemaparagerenciamento.model;

import java.util.List;

public class Fatura {
    private Double valorTotal;

    private List<Pagamento> pagamentos;

    private Integer ordemId;

    private Double valorPago;

    private Integer faturaId;

    public Fatura(Double valorTotal, Integer ordemId) {
        this.valorTotal = valorTotal;
        this.ordemId = ordemId;
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

    public Integer getOrdemId() {
        return ordemId;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Integer getFaturaId() {
        return faturaId;
    }

    public void setFaturaId(Integer faturaId) {
        this.faturaId = faturaId;
    }
}
