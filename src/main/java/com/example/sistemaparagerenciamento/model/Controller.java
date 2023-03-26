package com.example.sistemaparagerenciamento.model;

import java.util.List;

public class Controller {

    private List<Tecnico> tecnicoscadastrados;

    private List<Cliente> clientescadastrados;

    private List<Ordem> ordenscadastradas;

    private List<Ordem> ordensabertas;

    private List<Ordem> ordensfinalizadas;

    private List<Ordem> ordenscompra;

    private Fatura fatura;

    public Controller() {
    }

    public List<Tecnico> getTecnicoscadastrados() {
        return tecnicoscadastrados;
    }

    public void setTecnicoscadastrados(List<Tecnico> tecnicoscadastrados) {
        this.tecnicoscadastrados = tecnicoscadastrados;
    }

    public List<Cliente> getClientescadastrados() {
        return clientescadastrados;
    }

    public void setClientescadastrados(List<Cliente> clientescadastrados) {
        this.clientescadastrados = clientescadastrados;
    }

    public List<Ordem> getOrdenscadastradas() {
        return ordenscadastradas;
    }

    public void setOrdenscadastradas(List<Ordem> ordenscadastradas) {
        this.ordenscadastradas = ordenscadastradas;
    }

    public List<Ordem> getOrdensabertas() {
        return ordensabertas;
    }

    public void setOrdensabertas(List<Ordem> ordensabertas) {
        this.ordensabertas = ordensabertas;
    }

    public List<Ordem> getOrdensfinalizadas() {
        return ordensfinalizadas;
    }

    public void setOrdensfinalizadas(List<Ordem> ordensfinalizadas) {
        this.ordensfinalizadas = ordensfinalizadas;
    }

    public List<Ordem> getOrdenscompra() {
        return ordenscompra;
    }

    public void setOrdenscompra(List<Ordem> ordenscompra) {
        this.ordenscompra = ordenscompra;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }
}
