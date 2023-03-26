package com.example.sistemaparagerenciamento.model;

import java.util.ArrayList;

public class Controller {

    private ArrayList<Tecnico> tecnicoscadastrados;

    private ArrayList<Cliente> clientescadastrados;

    private ArrayList<Ordem> ordenscadastradas;

    private ArrayList<Ordem> ordensabertas;

    private ArrayList<Ordem> ordensfinalizadas;

    private ArrayList<Ordem> ordenscompra;

    private Fatura fatura;

    public Controller() {
    }

    public ArrayList<Tecnico> getTecnicoscadastrados() {
        return tecnicoscadastrados;
    }

    public void setTecnicoscadastrados(ArrayList<Tecnico> tecnicoscadastrados) {
        this.tecnicoscadastrados = tecnicoscadastrados;
    }

    public ArrayList<Cliente> getClientescadastrados() {
        return clientescadastrados;
    }

    public void setClientescadastrados(ArrayList<Cliente> clientescadastrados) {
        this.clientescadastrados = clientescadastrados;
    }

    public ArrayList<Ordem> getOrdenscadastradas() {
        return ordenscadastradas;
    }

    public void setOrdenscadastradas(ArrayList<Ordem> ordenscadastradas) {
        this.ordenscadastradas = ordenscadastradas;
    }

    public ArrayList<Ordem> getOrdensabertas() {
        return ordensabertas;
    }

    public void setOrdensabertas(ArrayList<Ordem> ordensabertas) {
        this.ordensabertas = ordensabertas;
    }

    public ArrayList<Ordem> getOrdensfinalizadas() {
        return ordensfinalizadas;
    }

    public void setOrdensfinalizadas(ArrayList<Ordem> ordensfinalizadas) {
        this.ordensfinalizadas = ordensfinalizadas;
    }

    public ArrayList<Ordem> getOrdenscompra() {
        return ordenscompra;
    }

    public void setOrdenscompra(ArrayList<Ordem> ordenscompra) {
        this.ordenscompra = ordenscompra;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }
}
