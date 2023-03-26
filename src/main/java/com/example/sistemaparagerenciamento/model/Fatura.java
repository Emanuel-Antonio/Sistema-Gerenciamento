package com.example.sistemaparagerenciamento.model;

import java.util.List;

public class Fatura {
    private Double valortotal;

    private List<Pagamento> pagamentos;

    private Integer ordemid;

    private Double valorpago;

    private Integer faturaid;

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public Integer getOrdemid() {
        return ordemid;
    }

    public void setOrdemid(Integer ordemid) {
        this.ordemid = ordemid;
    }

    public Double getValorpago() {
        return valorpago;
    }

    public void setValorpago(Double valorpago) {
        this.valorpago = valorpago;
    }

    public Integer getFaturaid() {
        return faturaid;
    }

    public void setFaturaid(Integer faturaid) {
        this.faturaid = faturaid;
    }
}
