package com.example.sistemaparagerenciamento.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * classe responável por representar uma abstração de serviço
 *
 * @author Emanuel Antonio Lima Pereira e Émerson Rodrigo Lima Pereira
 */
public class Servico {

    private final CategoriaServico categoria;
    private double valor;
    private Calendar horarioAbertura;
    private Calendar horarioFechamento;
    private double avaliacaoCliente;
    private final int ordemId;
    private List<Peca> pecas;
    private String descricao;
    private int servicoId;

    /**
     * construtor de servico, será necessário passar alguns parametros para cria um objeto Servico, tais quais os listados abaixo.
     *
     * @param ordemId valor referente ao identificador da ordem
     * @param categoria valor referente a categoria do servico
     */
    public Servico(int ordemId, CategoriaServico categoria) {
        this.ordemId = ordemId;
        this.horarioFechamento = null;
        this.categoria = categoria;
        this.pecas = new ArrayList<>();
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

    public void setHorarioAbertura(Calendar horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
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
     * sobrescrever do método equals para comparação de objetos Servico, a comparação é feita através do identificador do servico (ServicoId)
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
     * sobrescrever do método toString para definir qual mensagem deverá ser retornada
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