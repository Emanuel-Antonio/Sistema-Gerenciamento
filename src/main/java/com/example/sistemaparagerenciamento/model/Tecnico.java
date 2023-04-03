package com.example.sistemaparagerenciamento.model;

import java.util.List;
import java.util.Objects;

public class Tecnico {

    private boolean adm;

    private String nome;

    private String senha;

    private Integer tecnicoId;

    private List<Ordem> ordens;

    private List<OrdemCompra> carrinhoCompras;

    private Estoque estoque;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Tecnico){
            Tecnico t = (Tecnico) obj;
            if(Objects.equals(t.tecnicoId, this.tecnicoId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n" + "Email: " + this.getEmail() + "\n" + "Id: " + this.getTecnicoId() + "\n" + "Administrador: " + this.isAdm();
    }
}
