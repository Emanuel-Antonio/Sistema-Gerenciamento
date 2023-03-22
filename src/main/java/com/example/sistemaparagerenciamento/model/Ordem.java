package com.example.sistemaparagerenciamento.model;

import com.example.sistemaparagerenciamento.model.StatusOrdem;

public class Ordem {

    //private List<Servico> servico;

    private StatusOrdem status;

    //private Fatura fatura;

    private Integer clienteid;

    private Integer tecnicoid;

    private Integer ordemid;

    private String avaliacaofinal;

    public Ordem() {
    }

    /*public List<Servico> getServico() {
        return servico;
    }*/

    /*public void setServico(List<Servico> servico) {
        this.servico = servico;
    }*/

    public StatusOrdem getStatus() {
        return status;
    }

    public void setStatus(StatusOrdem status) {
        this.status = status;
    }

    /*public Fatura getFatura() {
        return fatura;
    }*/

    /*public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }*/

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public Integer getTecnicoid() {
        return tecnicoid;
    }

    public void setTecnicoid(Integer tecnicoid) {
        this.tecnicoid = tecnicoid;
    }

    public Integer getOrdemid() {
        return ordemid;
    }

    public void setOrdemid(Integer ordemid) {
        this.ordemid = ordemid;
    }

    public String getAvaliacaofinal() {
        return avaliacaofinal;
    }

    public void setAvaliacaofinal(String avaliacaofinal) {
        this.avaliacaofinal = avaliacaofinal;
    }

    public void adicionarServico(Servico servico) {
        this.servico.add(servico);
    }

    public List<Servico> removerServico(Servico servico) {
        return servico.remove(servico);
    }

}

