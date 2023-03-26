package com.example.sistemaparagerenciamento.model;

import java.util.Calendar;

public class Servico {

    private CategoriaServico categoria;

    private Double valor;

    private Calendar horarioabertura;

    private Calendar horariofechamento;

    private Double avaliacaocliente;

    private Integer ordemid;

    private Peca peca;

    private String descricao;

    public Servico(Integer ordemid) {
        this.ordemid = ordemid;
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

    public Calendar getHorarioabertura() {
        return horarioabertura;
    }

    public void setHorarioabertura(Calendar horarioabertura) {
        this.horarioabertura = horarioabertura;
    }

    public Calendar getHorariofechamento() {
        return horariofechamento;
    }

    public void setHorariofechamento(Calendar horariofechamento) {
        this.horariofechamento = horariofechamento;
    }

    public Double getAvaliacaocliente() {
        return avaliacaocliente;
    }

    public void setAvaliacaocliente(Double avaliacaocliente) {
        this.avaliacaocliente = avaliacaocliente;
    }

    public Integer getOrdemid() {
        return ordemid;
    }

    public void setOrdemid(Integer ordemid) {
        this.ordemid = ordemid;
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
}
