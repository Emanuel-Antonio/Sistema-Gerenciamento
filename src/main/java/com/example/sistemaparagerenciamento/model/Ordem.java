package com.example.sistemaparagerenciamento.model;

import com.example.sistemaparagerenciamento.model.StatusOrdem;

import java.util.List;

public class Ordem {

    private List<Servico> servico;

    private StatusOrdem status;

    private Fatura fatura;

    private Integer clienteId;

    private Integer tecnicoId;

    private Integer ordemId;

    private String avaliacaoFinal;

    public Ordem(List<Servico> servico, Integer clienteId, Integer tecnicoId, Integer ordemId) {
        this.servico = servico;
        this.clienteId = clienteId;
        this.tecnicoId = tecnicoId;
        this.ordemId = ordemId;
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

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getTecnicoId() {
        return tecnicoId;
    }

    public void setTecnicoId(Integer tecnicoId) {
        this.tecnicoId = tecnicoId;
    }

    public Integer getOrdemId() {
        return ordemId;
    }

    public void setOrdemId(Integer ordemId) {
        this.ordemId = ordemId;
    }

    public String getAvaliacaoFinal() {
        return avaliacaoFinal;
    }

    public void setAvaliacaoFinal(String avaliacaoFinal) {
        this.avaliacaoFinal = avaliacaoFinal;
    }
}

