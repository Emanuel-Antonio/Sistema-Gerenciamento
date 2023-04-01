package com.example.sistemaparagerenciamento.model;

import java.util.List;

public class Tecnico {

    private boolean adm;

    private String nome;

    private String senha;

    private Integer tecnicoId;

    private List<Ordem> ordens;

    private List<OrdemCompra> carrinhoCompras;

    private Estoque estoque;

    public Tecnico() {
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Ordem> getOrdens() {
        return ordens;
    }

    public void setOrdens(List<Ordem> ordens) {
        this.ordens = ordens;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Integer getTecnicoId() {
        return tecnicoId;
    }

    public void setTecnicoId(Integer tecnicoId) {
        this.tecnicoId = tecnicoId;
    }

    public List<OrdemCompra> getCarrinhoCompras() {
        return carrinhoCompras;
    }

    public void setCarrinhoCompras(List<OrdemCompra> carrinhoCompras) {
        this.carrinhoCompras = carrinhoCompras;
    }
}
