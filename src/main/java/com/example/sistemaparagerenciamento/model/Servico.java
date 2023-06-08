package com.example.sistemaparagerenciamento.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Classe respon&aacute;vel por representar uma abstra&ccedil;&atilde;o de servi&ccedil;o
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L; //desnecessário
    private final CategoriaServico categoria; //ok
    private double valor; //ok
    private final Calendar horarioAbertura; //desnecessário
    private Calendar horarioFechamento; //desnecessário
    private double avaliacaoCliente;
    private final int ordemId; //ok
    private List<Peca> pecas;
    private String descricao; //ok
    private int servicoId; //ok

    /**
     * Construtor de servico, ser&aacute; necess&aacute;rio passar alguns parametros para cria um objeto Servico, tais quais os listados abaixo.
     *
     * @param ordemId valor referente ao identificador da ordem
     * @param categoria valor referente a categoria do servico
     */
    public Servico(int ordemId, CategoriaServico categoria) {
        this.ordemId = ordemId;
        this.horarioFechamento = null;
        this.categoria = categoria;
        this.pecas = new ArrayList<>();
        this.horarioAbertura = Calendar.getInstance();
    }

    public CategoriaServico getCategoria() {
        return categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Calendar getHorarioAbertura() {
        return horarioAbertura;
    }

    public Calendar getHorarioFechamento() {
        return horarioFechamento;
    }

    public void setHorarioFechamento(Calendar horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }

    public double getAvaliacaoCliente() {
        return avaliacaoCliente;
    }

    public void setAvaliacaoCliente(double avaliacaoCliente) {
        this.avaliacaoCliente = avaliacaoCliente;
    }

    public int getOrdemId() {
        return ordemId;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPeca(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getServicoId() {
        return servicoId;
    }

    public void setServicoId(int servicoId) {
        this.servicoId = servicoId;
    }

    /**
     * Sobrescrever do m&eacute;todo equals para compara&ccedil;&atilde;o de objetos Servico, a compara&ccedil;&atilde;o &eacute; feita atrav&eacute;s do identificador do servico (ServicoId)
     *
     * @param obj valor referente ao objeto Servico
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Servico s){
            return s.getServicoId() == (this.getServicoId());
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
        return "Descrição: " + this.getDescricao() + "\n" + "Categoria: " +
                this.getCategoria() + "Valor: " + this.getValor() + "Ordem: " + this.getOrdemId()
                + "Inicio: " + this.getHorarioAbertura() + "Fim: " + this.getHorarioFechamento()
                + "Avaliação: " + this.getAvaliacaoCliente() + "Peca: " + this.getPecas();
     }

}