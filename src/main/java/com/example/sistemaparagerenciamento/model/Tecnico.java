package com.example.sistemaparagerenciamento.model;

/**
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 *
 * Classe respons&aacute;vel por representar uma abstra&ccedil;&atilde;o de t&eacute;cnico
 */
public class Tecnico {

    private boolean adm;
    private final String nome;
    private final String senha;
    private int tecnicoId;
    private Ordem ordem;
    private final String email;

    /**
     * construtor de tecnico, ser&aacute; necess&aacute;rio passar alguns parametros para cria um objeto Tecnico, tais quais os listados abaixo.
     *
     * @param email valor referente ao email do tecnico
     * @param nome valor referente ao nome do tecnico
     * @param senha valor referente a senha do tecnico
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

    /**
     * sobrescrever do m&eacute;todo equals para compara&ccedil;&atilde;o de objetos Tecnico, a compara&ccedil;&atilde;o &eacute; feita atrav&eacute;s do identificador do tecnico (tecnicoId)
     *
     * @param obj valor referente ao objeto Tecnico
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Tecnico t){
            return t.tecnicoId == this.tecnicoId;
        }
        return false;
    }

    /**
     * sobrescrever do método toString é para definir qual mensagem deverá ser retornada
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n" + "Email: " + this.getEmail() + "\n" + "Id: " + this.getTecnicoId() + "\n" + "Administrador: " + this.isAdm();
    }

}