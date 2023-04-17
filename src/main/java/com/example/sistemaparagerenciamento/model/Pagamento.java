package com.example.sistemaparagerenciamento.model;

/**
 * Classe respons&aacute;vel por representar uma abstra&ccedil;&atilde;o de pagamento
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class Pagamento {

    private final String tipoPagamento;
    private final double valor;
    private final Fatura fatura;
    private int pagamentoId;

    /**
     * Construtor de Pagamento, ser&aacute; necess&aacute;rio passar alguns parametros para cria um objeto Pagamento, tais quais os listados abaixo.
     *
     * @param tipoPagamento valor referente ao meio de pagamento
     * @param valor valor referente ao valor do pagamento
     * @param fatura valor referente a fatura emitida
     */
    public Pagamento(String tipoPagamento, double valor, Fatura fatura) {
        this.tipoPagamento = tipoPagamento;
        this.valor = valor;
        this.fatura = fatura;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public double getValor() {
        return valor;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public int getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(int pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    /**
     * Sobrescrever do m&eacute;todo equals para compara&ccedil;&atilde;o de objetos Pagamento, a compara&ccedil;&atilde;o &eacute; feita atrav&eacute;s do identificador do pagamento (pagamentoId)
     *
     * @param obj valor referente ao objeto pagamento
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Pagamento p){
            return p.getPagamentoId() == this.pagamentoId;
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
        return "\n" + "Tipo Pagamento: " + this.getTipoPagamento() + "\n" + "Valor: " + this.getValor();
    }



}