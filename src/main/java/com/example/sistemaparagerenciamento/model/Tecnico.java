package com.example.sistemaparagerenciamento.model;

/**
 * @author Emanuel Antonio Lima Pereira e Émerson Rodrigo Lima Pereira
 * @version 1.0
 * Classe responsável por representar uma abstração de tecnico
 */
public class Tecnico {

    private boolean adm;
    private final String nome;
    private final String senha;
    private int tecnicoId;
    private Ordem ordem;
    private final String email;

    /**
     * construtor de tecnico, será necessário passar alguns parametros para cria um objeto tecnico, tais quais os listados abaixo.
     *
     * @param email
     * @param nome
     * @param senha
     *
     */
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
        if(obj instanceof Tecnico t){
            return t.tecnicoId == this.tecnicoId;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n" + "Email: " + this.getEmail() + "\n" + "Id: " + this.getTecnicoId() + "\n" + "Administrador: " + this.isAdm();
    }

}