package com.example.sistemaparagerenciamento.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Servico s){
            return s.getServicoId() == (this.getServicoId());
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
