package com.example.sistemaparagerenciamento.model;

import com.example.sistemaparagerenciamento.model.StatusOrdem;

import java.util.List;

public class Ordem {

    private List<Servico> servico;

    private StatusOrdem status;

    private Fatura fatura;

    private int clienteId;

    private int tecnicoId;

    private int ordemId;

    private String avaliacaoFinal;

    public Ordem(List<Servico> servico, int clienteId, int tecnicoId, int ordemId) {
        this.servico = servico;
        this.clienteId = clienteId;
        this.tecnicoId = tecnicoId;
        this.ordemId = ordemId;
        this.status = StatusOrdem.ABERTA;
    }

    public List<Servico> getServico() {
        return servico;
    }

    public void setServico(List<Servico> servico) {
        this.servico = servico;
    }

    public StatusOrdem getStatus() {
        return status;
    }

    public void setStatus(StatusOrdem status) {
        this.status = status;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getTecnicoId() {
        return tecnicoId;
    }

    public void setTecnicoId(int tecnicoId) {
        this.tecnicoId = tecnicoId;
    }

    public int getOrdemId() {
        return ordemId;
    }

    public void setOrdemId(int ordemId) {
        this.ordemId = ordemId;
    }

    public String getAvaliacaoFinal() {
        return avaliacaoFinal;
    }

    public void setAvaliacaoFinal(String avaliacaoFinal) {
        this.avaliacaoFinal = avaliacaoFinal;
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

