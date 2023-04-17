package com.example.sistemaparagerenciamento.model;

/**
 * @author Emanuel Antonio Lima Pereira e Émerson Rodrigo Lima Pereira
 * @version 1.0
 *
 * Classe responsável por representar uma abstração de ordem de compra
 */
public class OrdemCompra {

    private final int qnt;
    private final double valorUnitario;
    private final String nome;
    private int ordemCompraId;

    /**
     * construtor de peca, será necessário passar alguns parametros para cria um objeto OrdemCompra, tais quais os listados abaixo.
     *
     * @param qnt valor referente a quantidade da peca
     * @param valorUnitario valor referente ao valor unitário da peca
     * @param nome valor referente ao nome da peca
     */
    public OrdemCompra(int qnt, double valorUnitario, String nome) {
        this.qnt = qnt;
        this.valorUnitario = valorUnitario;
        this.nome = nome;
    }

    public int getQnt() {
        return qnt;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public String getNome() {
        return nome;
    }

    public int getOrdemCompraId() {
        return ordemCompraId;
    }

    public void setOrdemCompraId(int ordemCompraId) {
        this.ordemCompraId = ordemCompraId;
    }

    /**
     * sobrescrever do método equals para comparação de objetos OrdemCompra, a comparação é feita atraves do identificador da ordem de compra (OrdemCompraId)
     *
     * @param obj valor referente ao objeto OrdemCompra
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof OrdemCompra o){
            return o.getOrdemCompraId() == (this.getOrdemCompraId());
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
        return "Nome: " + this.getNome() + "\n" + "Valor: " + this.getValorUnitario() + "\n" + "Quantidade: " + this.getQnt() + "\n" + "Id : " + this.getOrdemCompraId();
    }


}