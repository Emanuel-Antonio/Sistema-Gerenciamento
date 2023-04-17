package com.example.sistemaparagerenciamento.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 *
 * Classe respons&aacute;vel por representar uma abstra&ccedil;&atilde;o de ordem
 */
public class Ordem {

    private List<Servico> servicos;
    private StatusOrdem status;
    private Fatura fatura;
    private final int clienteId;
    private int tecnicoId;
    private int ordemId;
    private String avaliacaoFinal;

    /**
     * construtor de ordem, ser&aacute; necess&aacute;rio passar alguns parametros para cria um objeto Ordem, tais quais os listados abaixo.
     *
     * @param clienteId valor referente ao identificador do cliente
     */
    public Ordem(int clienteId) {
        this.clienteId = clienteId;
        this.servicos = new ArrayList<>();
        this.status = StatusOrdem.ANDAMENTO;
        this.tecnicoId = -1;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public StatusOrdem getStatus() {
        return status;
    }

    public void setStatus(StatusOrdem status) {
        this.status = status;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    public int getClienteId() {
        return clienteId;
    }

    public int getTecnicoId() {
        return tecnicoId;
    }

    public void setTecnicoId(int tecnicoId) {
        this.tecnicoId = tecnicoId;
    }

    public int getOrdemId() {
        return ordemId;
    }

    public void setOrdemId(int ordemId) {
        this.ordemId = ordemId;
    }

    public String getAvaliacaoFinal() {
        return avaliacaoFinal;
    }

    public void setAvaliacaoFinal(String avaliacaoFinal) {
        this.avaliacaoFinal = avaliacaoFinal;
    }

    /**
     * sobrescrever do m&eacute;todo equals para compara&ccedil;&atilde;o de objetos Ordem, a compara&ccedil;&atilde;o &eacute; feita atrav&eacute;s do identificador de Ordem (ordemId)
     *
     * @param obj valor referente ao objeto Ordem
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Ordem o){
            return o.getOrdemId() == this.ordemId;
        }
        return false;
    }

    /**
     * sobrescrever do m&eacute;todo toString para definir qual mensagem dever&aacute; ser retornada
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Id Ordem: " + this.getOrdemId() + "\n" + "Tecnico: " + this.getTecnicoId() + "\n" + "Cliente: " + this.getClienteId() + "\n" + "Status: " +this.getStatus();
    }

}