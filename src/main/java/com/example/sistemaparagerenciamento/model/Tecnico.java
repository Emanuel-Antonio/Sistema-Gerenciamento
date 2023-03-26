package com.example.sistemaparagerenciamento.model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tecnico {

    private boolean adm;

    private String nome;

    private String senha;

    private Integer tecnicoid;

    private ArrayList<Ordem> ordens;

    private LinkedList<OrdemCompra> carrinhocompras;

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

    public Integer getTecnicoid() {
        return tecnicoid;
    }

    public void setTecnicoid(Integer tecnicoid) {
        this.tecnicoid = tecnicoid;
    }

    public ArrayList<Ordem> getOrdens() {
        return ordens;
    }

    public void setOrdens(ArrayList<Ordem> ordens) {
        this.ordens = ordens;
    }

    public LinkedList<OrdemCompra> getCarrinhocompras() {
        return carrinhocompras;
    }

    public void setCarrinhocompras(LinkedList<OrdemCompra> carrinhocompras) {
        this.carrinhocompras = carrinhocompras;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}
