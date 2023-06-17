package com.example.sistemaparagerenciamento.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe respons&aacute;vel por representar uma abstra&ccedil;&atilde;o de fatura
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class Fatura implements Serializable {

    private double valorTotal;
    private List<Pagamento> pagamentos;
    private final int ordemId;
    private double valorPago;

    /**
     * Construtor de fatura, ser&aacute; necess&aacute;rio passar alguns parametros para cria um objeto Fatura, tais quais os listados abaixo.
     *
     * @param ordemId valor referente ao identificador da ordem
     */
    public Fatura(int ordemId) {
        this.valorTotal = 0.0;
        this.ordemId = ordemId;
        this.valorPago = 0.0;
        this.pagamentos = new ArrayList<>();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public int getOrdemId() {
        return ordemId;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Sobrescrever do m&eacute;todo toString para definir qual mensagem dever&aacute; ser retornada
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Id da ordem: " + this.getOrdemId() + "\n" + "Valor total: " + this.getValorTotal() + "\n" +
                "Valor pago: " + this.getValorPago();
    }

}