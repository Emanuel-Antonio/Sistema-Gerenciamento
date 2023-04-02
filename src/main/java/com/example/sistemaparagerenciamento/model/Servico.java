package com.example.sistemaparagerenciamento.model;

import java.util.Calendar;

public class Servico {

    private CategoriaServico categoria;

    private Double valor;

    private Calendar horarioAbertura;

    private Calendar horarioFechamento;

    private Double avaliacaoCliente;

    private Integer ordemId;

    private Peca peca;

    private String descricao;

    public Servico(Integer ordemid) {
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

    public boolean removerPecaDoServico(){
        if(this.peca != null){
            this.valor -= this.peca.getValor();
            this.peca = null;
        }
        return true;
    }

    public boolean adicionarPecaAoServico(String nome, Double valor){

        this.peca = new Peca(nome,valor);
        return true;
    }
}
