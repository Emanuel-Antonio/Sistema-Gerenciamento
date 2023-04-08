package com.example.sistemaparagerenciamento.model;

public class OrdemCompra {

    private int qnt;

    private double valorUnitario;

    private String nome;

    private int ordemCompraId;

    public OrdemCompra(int qnt, double valorUnitario, String nome) {
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

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
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
        return "Nome: " + this.getNome() + "\n" + "Valor: " + this.getValorUnitario() + "\n" + " Quantidade: " + this.getQnt() + "\n" + "Id : " + this.getOrdemCompraId();
    }

    public int getOrdemCompraId() {
        return ordemCompraId;
    }

    public void setOrdemCompraId(int ordemCompraId) {
        this.ordemCompraId = ordemCompraId;
    }
}
