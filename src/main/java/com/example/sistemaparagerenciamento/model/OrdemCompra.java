package com.example.sistemaparagerenciamento.model;

/**
 * Classe respons&aacute;vel por representar uma abstra&ccedil;&atilde;o de ordem de compra
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class OrdemCompra {

    private final int qnt;
    private final double valorUnitario;
    private final String nome;
    private int ordemCompraId;

    /**
     * Construtor de peca, ser&aacute; necess&aacute;rio passar alguns parametros para cria um objeto OrdemCompra, tais quais os listados abaixo.
     *
     * @param qnt valor referente a quantidade da peca
     * @param valorUnitario valor referente ao valor unit&aacute;rio da peca
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
     * Sobrescrever do m&eacute;todo equals para compara&ccedil;&atilde;o de objetos OrdemCompra, a compara&ccedil;&atilde;o &eacute; feita atrav&eacute;s do identificador da ordem de compra (OrdemCompraId)
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
     * Sobrescrever do m&eacute;todo toString para definir qual mensagem dever&aacute; ser retornada
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n" + "Valor: " + this.getValorUnitario() + "\n" + "Quantidade: " + this.getQnt() + "\n" + "Id : " + this.getOrdemCompraId();
    }


}