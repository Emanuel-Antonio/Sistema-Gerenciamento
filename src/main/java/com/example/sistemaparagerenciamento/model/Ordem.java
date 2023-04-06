package com.example.sistemaparagerenciamento.model;

import java.util.List;

public class Ordem {

    private List<Servico> servico;

    private StatusOrdem status;

    private Fatura fatura;

    private int clienteId;

    private int tecnicoId;

    private int ordemId;

    private String avaliacaoFinal;

    public Ordem(List<Servico> servico, int clienteId, int ordemId) {
        this.servico = servico;
        this.clienteId = clienteId;
        this.ordemId = ordemId;
        this.status = StatusOrdem.ABERTA;
        this.tecnicoId = -1;
    }

    public List<Servico> getServico() {
        return servico;
    }

    public void setServico(List<Servico> servico) {
        this.servico = servico;
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

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Ordem){
            Ordem o = (Ordem) obj;
            if(o.getOrdemId()==this.ordemId)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public Boolean atualizarStatusPagamento(Ordem ordem){
        if(ordem.getStatus() == StatusOrdem.ABERTA && fatura.getValorPago() < fatura.getValorTotal()) {
            ordem.setStatus(StatusOrdem.PAGAMENTO);
            return true;
        }
        return false;
    }

    public Boolean atualizarStatusFechada(Ordem ordem){
        if(ordem.getStatus() == StatusOrdem.PAGAMENTO || ordem.getStatus() == StatusOrdem.ABERTA && fatura.getValorPago() == fatura.getValorTotal()){
            ordem.setStatus(StatusOrdem.FECHADA);
            return true;
        }
        return false;
    }

    public Boolean atualizarStatusCancelada(Ordem ordem){
        if(ordem.getStatus() == StatusOrdem.ABERTA){
            ordem.setStatus(StatusOrdem.CANCELADA);
            return true;
        }
        return false;
    }



}

