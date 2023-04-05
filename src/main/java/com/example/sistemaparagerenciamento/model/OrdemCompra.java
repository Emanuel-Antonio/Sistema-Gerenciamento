package com.example.sistemaparagerenciamento.model;

public class OrdemCompra {

    private int qnt;

    private Double valorUnitario;

    private String nome;

    private int ordemCompraId;

    public OrdemCompra(int qnt, Double valorUnitario, String nome) {
        this.qnt = qnt;
        this.valorUnitario = valorUnitario;
        this.nome = nome;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof OrdemCompra){
            OrdemCompra o = (OrdemCompra) obj;
            return o.getOrdemCompraId() == (this.getOrdemCompraId());
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getOrdemCompraId() {
        return ordemCompraId;
    }

    public void setOrdemCompraId(int ordemCompraId) {
        this.ordemCompraId = ordemCompraId;
    }
}
