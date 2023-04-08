package com.example.sistemaparagerenciamento.model;

import java.util.Calendar;
import java.util.List;

public class Servico {

    private CategoriaServico categoria;

    private Double valor;

    private Calendar horarioAbertura;

    private Calendar horarioFechamento;

    private Double avaliacaoCliente;

    private int ordemId;

    private List<Peca> pecas;

    private String descricao;

    private int servicoId;

    public Servico(int ordemId) {
        this.ordemId = ordemId;
        this.horarioFechamento = null;
    }

    public CategoriaServico getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaServico categoria) {
        this.categoria = categoria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
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

    public Double getAvaliacaoCliente() {
        return avaliacaoCliente;
    }

    public void setAvaliacaoCliente(Double avaliacaoCliente) {
        this.avaliacaoCliente = avaliacaoCliente;
    }

    public int getOrdemId() {
        return ordemId;
    }

    public void setOrdemId(int ordemId) {
        this.ordemId = ordemId;
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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Servico){
            Servico s = (Servico) obj;
            return s.getHorarioAbertura().equals(this.horarioAbertura);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Descrição: " + this.getDescricao() + "\n" + "Categoria: " +
                this.getCategoria() + "Valor: " + this.getValor() + "Ordem: " + this.getOrdemId()
                + "Inicio: " + this.getHorarioAbertura() + "Fim: " + this.getHorarioFechamento()
                + "Avaliação: " + this.getAvaliacaoCliente() + "Peca: " + this.getPecas();
     }

    public int getServicoId() {
        return servicoId;
    }

    public void setServicoId(int servicoId) {
        this.servicoId = servicoId;
    }
}
