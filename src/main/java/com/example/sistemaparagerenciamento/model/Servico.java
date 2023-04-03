package com.example.sistemaparagerenciamento.model;

import java.util.Calendar;
import java.util.Objects;

public class Servico {

    private CategoriaServico categoria;

    private Double valor;

    private Calendar horarioAbertura;

    private Calendar horarioFechamento;

    private Double avaliacaoCliente;

    private Integer ordemId;

    private Peca peca;

    private String descricao;

    public Servico(Integer ordemId) {
        this.ordemId = ordemId;
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

    public Integer getOrdemId() {
        return ordemId;
    }

    public void setOrdemId(Integer ordemId) {
        this.ordemId = ordemId;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
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
            return Objects.equals(s.ordemId, this.ordemId) && s.horarioAbertura.equals(this.horarioAbertura) && s.descricao.equals(this.descricao);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Descrição: " + this.getDescricao() + "\n" + "Categoria: " + this.getCategoria() + this.get
    }
}
