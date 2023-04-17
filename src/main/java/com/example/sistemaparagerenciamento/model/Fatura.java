package com.example.sistemaparagerenciamento.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emanuel Antonio Lima Pereira e Émerson Rodrigo Lima Pereira
 * @version 1.0
 *
 * Classe responsável por representar uma abstração de fatura
 */
public class Fatura {

    private double valorTotal;
    private List<Pagamento> pagamentos;
    private final int ordemId;
    private double valorPago;

    /**
     * construtor de fatura, será necessário passar alguns parametros para cria um objeto Fatura, tais quais os listados abaixo.
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
     * sobrescrever do método toString para definir qual mensagem deverá ser retornada
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Id da ordem: " + this.getOrdemId() + "\n" + "Valor total: " + this.getValorTotal() + "\n" +
                "Valor pago: " + this.getValorPago();
    }

}