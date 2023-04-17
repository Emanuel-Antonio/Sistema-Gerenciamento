package com.example.sistemaparagerenciamento.model;

/**
 * @author Emanuel Antonio Lima Pereira e Émerson Rodrigo Lima Pereira
 * @version 1.0
 *
 * Classe responsável por representar uma abstração de peça
 */
public class Peca {

    private final String nome;
    private double valor;
    private int qnt;

    /**
     * construtor de peca, será necessário passar alguns parametros para cria um objeto Peca, tais quais os listados abaixo.
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
     * sobrescrever do método equals para comparação de objetos Peca, a comparação é feita atraves do nome da peca (Nome)
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
     * sobrescrever do método toString para definir qual mensagem deverá ser retornada
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n" + "Valor: " + this.getValor() + "\n" + "Quantidade: " + this.getQnt();
    }

}