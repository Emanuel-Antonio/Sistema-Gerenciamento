package com.example.sistemaparagerenciamento.model;

import java.util.List;

public class Tecnico {

    private boolean adm;

    private String nome;

    private String senha;

    private int tecnicoId;

    private Ordem ordem;

    private String email;

    public Tecnico(String email,String nome, String senha) {
        this.senha = senha;
        this.email = email;
        this.adm = false;
        this.nome = nome;
    }


    public String getEmail() {
        return email;
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


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }


    public int getTecnicoId() {
        return tecnicoId;
    }

    public void setTecnicoId(int tecnicoId) {
        this.tecnicoId = tecnicoId;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Tecnico){
            Tecnico t = (Tecnico) obj;
            if(t.tecnicoId == this.tecnicoId){
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
