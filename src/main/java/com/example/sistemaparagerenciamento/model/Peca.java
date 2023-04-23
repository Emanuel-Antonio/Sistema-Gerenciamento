package com.example.sistemaparagerenciamento.model;

import java.io.Serializable;

/**
 * Classe respons&aacute;vel por representar uma abstra&ccedil;&atilde;o de pe&ccedil;a
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class Peca implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String nome;
    private double valor;
    private int qnt;

    /**
     * Construtor de peca, ser&aacute; necess&aacute;rio passar alguns parametros para cria um objeto Peca, tais quais os listados abaixo.
     *
     * @param nome valor referente ao nome da peca
     */
    public Peca(String nome) {
        this.nome = nome;
        this.valor = 0.0;
        this.qnt = 0;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * Sobrescrever do m&eacute;todo equals para compara&ccedil;&atilde;o de objetos Peca, a compara&ccedil;&atilde;o &eacute; feita atrav&eacute;s do nome da peca (Nome)
     *
     * @param obj valor referente ao objeto Peca
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Peca p){
            return p.getNome().equals(this.getNome());
        }
        return false;
    }

    /**
     * Sobrescrever do m&eacute;todo toString para definir qual mensagem dever&aacute; ser retornada
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n" + "Valor: " + this.getValor() + "\n" + "Quantidade: " + this.getQnt();
    }

}