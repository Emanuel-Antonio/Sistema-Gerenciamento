package com.example.sistemaparagerenciamento.model;

import java.util.List;

public class Estoque {

    private List<Peca> pecas;

    private List<OrdemCompra> ordenscompra;

    public Estoque() {
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public List<OrdemCompra> getOrdenscompra() {
        return ordenscompra;
    }

    public void setOrdenscompra(List<OrdemCompra> ordenscompra) {
        this.ordenscompra = ordenscompra;
    }
}
