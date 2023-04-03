package com.example.sistemaparagerenciamento.model;

import java.util.List;

public class Recepcao {

    private List<Tecnico> tecnicosCadastrados;

    private List<Cliente> clientesCadastrados;

    private List<Ordem> ordensCadastradas;

    private List<Ordem> ordensAbertas;

    private List<Ordem> ordensFinalizadas;

    private List<OrdemCompra> ordensCompra;

    private Fatura fatura;

    public Recepcao() {
    }

    public List<Tecnico> getTecnicosCadastrados() {
        return tecnicosCadastrados;
    }

    public void setTecnicosCadastrados(List<Tecnico> tecnicosCadastrados) {
        this.tecnicosCadastrados = tecnicosCadastrados;
    }

    public List<Cliente> getClientesCadastrados() {
        return clientesCadastrados;
    }

    public void setClientesCadastrados(List<Cliente> clientesCadastrados) {
        this.clientesCadastrados = clientesCadastrados;
    }

    public List<Ordem> getOrdensCadastradas() {
        return ordensCadastradas;
    }

    public void setOrdensCadastradas(List<Ordem> ordensCadastradas) {
        this.ordensCadastradas = ordensCadastradas;
    }

    public List<Ordem> getOrdensAbertas() {
        return ordensAbertas;
    }

    public void setOrdensAbertas(List<Ordem> ordensAbertas) {
        this.ordensAbertas = ordensAbertas;
    }

    public List<Ordem> getOrdensFinalizadas() {
        return ordensFinalizadas;
    }

    public void setOrdensFinalizadas(List<Ordem> ordensFinalizadas) {
        this.ordensFinalizadas = ordensFinalizadas;
    }

    public List<OrdemCompra> getOrdensCompra() {
        return ordensCompra;
    }

    public void setOrdensCompra(List<OrdemCompra> ordensCompra) {
        this.ordensCompra = ordensCompra;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
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
