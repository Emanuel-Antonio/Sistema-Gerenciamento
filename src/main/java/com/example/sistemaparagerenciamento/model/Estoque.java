package com.example.sistemaparagerenciamento.model;

import java.util.List;

public class Estoque {

    private List<Peca> pecas;

    private List<OrdemCompra> ordensCompra;

    public Estoque() {
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public List<OrdemCompra> getOrdensCompra() {
        return ordensCompra;
    }

    public void setOrdensCompra(List<OrdemCompra> ordensCompra) {
        this.ordensCompra = ordensCompra;
    }
}
