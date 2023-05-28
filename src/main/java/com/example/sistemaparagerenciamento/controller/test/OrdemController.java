package com.example.sistemaparagerenciamento.controller.test;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.*;
import java.util.List;

/**
 * Classe OrdemController, possui m&eacute;todos que representam casos de uso com uma Ordem
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class OrdemController {

    private String tipoPagamento;
    private double valor;

    /**
     * M&eacute;todo gerarFatura, respons&aacute;vel por retornar uma string com os dados de uma fatura
     *
     * @param ordemId identificador da ordem a qual eu quero obter a fatura
     * @return String
     */
    public String gerarFatura(int ordemId) {
        //Aqui eu verifico se já é possível gerar uma fatura para a ordem
        if (DAO.getOrdem().buscarPorId(ordemId).getFatura() == null && DAO.getOrdem().buscarPorId(ordemId).getServicos() != null) {
            Fatura fatura = new Fatura(ordemId);
            //Aqui eu vinculo uma fatura a ordem através do DAO da ordem
            DAO.getOrdem().buscarPorId(ordemId).setFatura(fatura);
            return fatura.toString();
        }
        return DAO.getOrdem().buscarPorId(ordemId).getFatura().toString();
    }

    /**
     * M&eacute;todo atualizarStatusPagamento, respons&aacute;vel por mudar o status da ordem para PAGAMENTO
     *
     * @param ordem ordem a qual eu quero mudar o status para PAGAMENTO
     * @return boolean - retorna true caso consiga mudar o status da ordem para PAGAMENTO e false caso contr&aacute;rio
     */
    public boolean atualizarStatusPagamento(Ordem ordem) {
        if (ordem.getStatus().equals(StatusOrdem.ANDAMENTO) && ordem.getFatura().getValorPago() < ordem.getFatura().getValorTotal()) {
            //Aqui eu mudo o status da ordem através do DAO de ordem
            DAO.getOrdem().buscarPorId(ordem.getOrdemId()).setStatus(StatusOrdem.PAGAMENTO);
            return true;
        }
        return false;
    }

    /**
     * M&eacute;todo atualizarStatusFechada, respons&aacute;vel por mudar o status da ordem para FECHADA
     *
     * @param ordem ordem a qual eu desejo mudar o status para FECHADA
     * @return boolean - retorna true caso consiga mudar o status da ordem para FECHADA e false caso contr&aacute;rio
     */
    public boolean atualizarStatusFechada(Ordem ordem) {
        if (ordem.getStatus().equals(StatusOrdem.PAGAMENTO) && ordem.getFatura().getValorPago() == ordem.getFatura().getValorTotal() || ordem.getStatus().equals(StatusOrdem.ANDAMENTO) && ordem.getFatura().getValorPago() == ordem.getFatura().getValorTotal()) {
            //Aqui eu mudo o status da ordem através do DAO de ordem
            DAO.getOrdem().buscarPorId((ordem.getOrdemId())).setStatus(StatusOrdem.FECHADA);
            return true;
        }
        return false;
    }

    /**
     * M&eacute;todo atualizarStatusCancelade, respons&aacute;vel por mudar o status da ordem para CANCELADA
     *
     * @param ordem ordem a qual eu desejo mudar o status para CANCELADA
     * @return boolean - retorna true caso consiga mudar o status da ordem para CANCELADA e false caso contr&aacute;rio
     */
    public boolean atualizarStatusCancelada(Ordem ordem) {
        if (ordem.getStatus().equals(StatusOrdem.ANDAMENTO)) {
            //Aqui eu mudo o status da ordem através do DAO de ordem
            DAO.getOrdem().buscarPorId(ordem.getOrdemId()).setStatus(StatusOrdem.CANCELADA);
            return true;
        }
        return false;
    }

    /**
     * M&eacute;todo cadastrarServico, respons&aacute;vel por cadastrar um servi&ccedil;o a uma ordem
     *
     * @param ordemId identificador da ordem
     * @param categoria categoria do servi&ccedil;o
     * @return boolean - retorna true caso consiga efetuar o cadastro do servi&ccedil;o e false caso contr&aacute;rio
     */
    public boolean cadastrarServico(int ordemId, CategoriaServico categoria) {
        Servico servico = new Servico(ordemId, categoria);
        //Aqui eu adiciono serviço ao DAO de serviço
        DAO.getServico().criar(servico);
        if(CategoriaServico.LIMPEZA.equals(categoria)){
            //Aqui eu adiciono o valor fixo de serviço de LIMPEZA através do DAO de serviço
            DAO.getServico().buscarPorId(servico.getServicoId()).setValor(70);
        }
        else if(CategoriaServico.FORMATACAO_INSTALACAO.equals(categoria)){
            //Aqui eu adiciono o valor fixo de serviço de FORMATACAO_INSTALACAO através do DAO de serviço
            DAO.getServico().buscarPorId(servico.getServicoId()).setValor(60);
        }
        //Aqui eu adiciono o valor do servico a fatura da ordem através do DAO de ordem
        DAO.getOrdem().buscarPorId(ordemId).getFatura().setValorTotal(DAO.getOrdem().buscarPorId(servico.getOrdemId()).getFatura().getValorTotal() + servico.getValor());
        List<Servico> servicos =  DAO.getOrdem().buscarPorId(ordemId).getServicos();
        servicos.add(servico);
        //Aqui eu adiciono os serviços na ordem através do DAO de ordem
        DAO.getOrdem().buscarPorId(ordemId).setServicos(servicos);
        return true;
    }

    /**
     * M&eacute;todo removerServico, respons&aacute;vel por remover servi&ccedil;o da ordem
     *
     * @param servico servi&ccedil;o que ser&aacute; removido da ordem
     * @return boolean - retorna true caso consiga remover e false caso contr&aacute;rio
     */
    public boolean removerServico(Servico servico) {
        for (int i = 0; i < DAO.getServico().getServicos().size(); i++) {
            if (DAO.getServico().getServicos().get(i).equals(servico)) {
                //Aqui eu removo o serviço do DAO de serviço
                DAO.getServico().getServicos().remove(i);
                //Aqui eu removo o serviço da ordem através do DAO de ordem
                DAO.getOrdem().buscarPorId(servico.getOrdemId()).getServicos().remove(servico);
                //Aqui eu abato o valor do servico da fatura da ordem através do DAO de ordem
                DAO.getOrdem().buscarPorId(servico.getOrdemId()).getFatura().setValorTotal(DAO.getOrdem().buscarPorId(servico.getOrdemId()).getFatura().getValorTotal() - servico.getValor());
                return true;
            }
        }
        return false;
    }

    /**
     * M&eacute;todo novoPegamento, respons&aacute;vel por gerar um novo pagamento para a fatura
     *
     * @param fatura fatura a qual receber&aacute; um novo pagamento
     * @return boolean - retorna true caso consiga gerar um novo pagamento e false caso contr&aacute;rio
     */
    public boolean novoPagamento(Fatura fatura) {
        Pagamento pagamento = new Pagamento(this.tipoPagamento, this.valor, fatura);
        //Aqui eu verifico se já não foi pago toda a fatura
        if (fatura.getValorTotal() >= (fatura.getValorPago() + pagamento.getValor())) {
            //Aqui eu cadastro um novo pagamento através do DAO de pagamento
            DAO.getPagamento().criar(pagamento);
            //Aqui eu atualizo o valor pago adicionando o valor do novo pagamanto através do DAO de pagamento
            DAO.getPagamento().buscarPorId(pagamento.getPagamentoId()).getFatura().setValorPago(fatura.getValorPago() + pagamento.getValor());
            List<Pagamento> pagamentos = DAO.getOrdem().buscarPorId(fatura.getOrdemId()).getFatura().getPagamentos();
            pagamentos.add(pagamento);
            //Aqui eu atualizo a lista de pagamentos da fatura através do DAO de ordem
            DAO.getOrdem().buscarPorId(fatura.getOrdemId()).getFatura().setPagamentos(pagamentos);
            return true;
        }
        return false;
    }

    /**
     * Método cadastrarOrdem, responsável por cadastrar ordem
     *
     * @param clienteId identificador do cliente
     * @return boolean - retorna true caso consiga cadastrar a ordem e false caso contrário
     */
    public boolean cadastrarOrdem(int clienteId){
        for(int i = 0; i < DAO.getCliente().getClientes().size(); i++){
            //Aqui eu verifico se o cliente existe
            if(DAO.getCliente().getClientes().get(i).getClienteId() == clienteId){
                Ordem ordem = new Ordem(clienteId);
                //Aqui eu cadastro a ordem através do DAO de ordem
                DAO.getOrdem().criar(ordem);
                List<Ordem> ordens = DAO.getCliente().getClientes().get(i).getOrdens();
                //Aqui eu vinculo a nova ordem ao cliente
                DAO.getCliente().getClientes().get(i).setOrdens(ordens);
                return true;
            }
        }
        return false;
    }

}