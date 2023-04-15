package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.*;

import java.util.List;

public class OrdemController {

    private String tipoPagamento;

    private double valor;


    public String gerarFatura(int ordemId) {
        if (DAO.getOrdem().buscarPorId(ordemId).getFatura() == null && DAO.getOrdem().buscarPorId(ordemId).getServicos() != null) {
            Fatura f = new Fatura(ordemId);
            DAO.getOrdem().buscarPorId(ordemId).setFatura(f);
            return f.toString();
        }
        return DAO.getOrdem().buscarPorId(ordemId).getFatura().toString();
    }

    public Boolean atualizarStatusPagamento(Ordem ordem) {
        if (ordem.getStatus().equals(StatusOrdem.ANDAMENTO) && ordem.getFatura().getValorPago() < ordem.getFatura().getValorTotal()) {
            DAO.getOrdem().buscarPorId(ordem.getOrdemId()).setStatus(StatusOrdem.PAGAMENTO);
            return true;
        }
        return false;
    }

    public Boolean atualizarStatusFechada(Ordem ordem) {
        if (ordem.getStatus().equals(StatusOrdem.PAGAMENTO) && ordem.getFatura().getValorPago() == ordem.getFatura().getValorTotal() || ordem.getStatus().equals(StatusOrdem.ANDAMENTO) && ordem.getFatura().getValorPago() == ordem.getFatura().getValorTotal()) {
            DAO.getOrdem().buscarPorId((ordem.getOrdemId())).setStatus(StatusOrdem.FECHADA);
            return true;
        }
        return false;
    }

    public Boolean atualizarStatusCancelada(Ordem ordem) {
        if (ordem.getStatus().equals(StatusOrdem.ANDAMENTO)) {
            DAO.getOrdem().buscarPorId(ordem.getOrdemId()).setStatus(StatusOrdem.CANCELADA);
            return true;
        }
        return false;
    }

    public boolean cadastrarServico(int ordemId, CategoriaServico categoria) {
        Servico servico = new Servico(ordemId, categoria);
        DAO.getServico().criar(servico);
        if(CategoriaServico.LIMPEZA.equals(categoria)){
            DAO.getServico().buscarPorId(servico.getServicoId()).setValor(70);
        }
        else if(CategoriaServico.FORMATACAO_INSTALACAO.equals(categoria)){
            DAO.getServico().buscarPorId(servico.getServicoId()).setValor(60);
        }
        DAO.getOrdem().buscarPorId(ordemId).getFatura().setValorTotal(DAO.getOrdem().buscarPorId(servico.getOrdemId()).getFatura().getValorTotal() + servico.getValor());
        List<Servico> servicos =  DAO.getOrdem().buscarPorId(ordemId).getServicos();
        servicos.add(servico);
        DAO.getOrdem().buscarPorId(ordemId).setServicos(servicos);
        return true;
    }

    public boolean removerServico(Servico servico) {
        for (int i = 0; i < DAO.getServico().getServicos().size(); i++) {
            if (DAO.getServico().getServicos().get(i).equals(servico)) {
                DAO.getServico().getServicos().remove(i);
                DAO.getOrdem().buscarPorId(servico.getOrdemId()).getServicos().remove(servico);
                DAO.getOrdem().buscarPorId(servico.getOrdemId()).getFatura().setValorTotal(DAO.getOrdem().buscarPorId(servico.getOrdemId()).getFatura().getValorTotal() - servico.getValor());
                return true;
            }
        }
        return false;
    }

    public boolean novoPagamento(Fatura fatura) {
        Pagamento pagamento = new Pagamento(this.tipoPagamento, this.valor, fatura);
        if (fatura.getValorTotal() >= (fatura.getValorPago() + pagamento.getValor())) {
            DAO.getPagamento().criar(pagamento);

            DAO.getPagamento().buscarPorId(pagamento.getPagamentoId()).getFatura().setValorPago(pagamento.getValor());
            return true;
        }
        return false;
    }

    public boolean cadastrarOrdem(int clienteId){
        for(int i = 0; i < DAO.getCliente().getClientes().size(); i++){
            if(DAO.getCliente().getClientes().get(i).getClienteId() == clienteId){
                Ordem ordem = new Ordem(null, clienteId);
                DAO.getOrdem().criar(ordem);
                List<Ordem> ordens = DAO.getCliente().getClientes().get(i).getOrdens();
                DAO.getCliente().getClientes().get(i).setOrdens(ordens);
                return true;
            }
        }
        return false;
    }

}
