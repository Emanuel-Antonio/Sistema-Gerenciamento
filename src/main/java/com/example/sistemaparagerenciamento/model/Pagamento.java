package com.example.sistemaparagerenciamento.model;

/**
 * @author Emanuel Antonio Lima Pereira e Émerson Rodrigo Lima Pereira
 * @version 1.0
 *
 * Classe responsável por representar uma abstração de pagamento
 */
public class Pagamento {

    private final String tipoPagamento;
    private final double valor;
    private final Fatura fatura;
    private int pagamentoId;

    /**
     * construtor de Pagamento, será necessário passar alguns parametros para cria um objeto Pagamento, tais quais os listados abaixo.
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
     * sobrescrever do método equals para comparação de objetos Pagamento, a comparação é feita através do identificador do pagamento (pagamentoId)
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
     * sobrescrever do método toString para definir qual mensagem deverá ser retornada
     *
     * @return String
     */
    @Override
    public String toString() {
        return "\n" + "Tipo Pagamento: " + this.getTipoPagamento() + "\n" + "Valor: " + this.getValor();
    }



}