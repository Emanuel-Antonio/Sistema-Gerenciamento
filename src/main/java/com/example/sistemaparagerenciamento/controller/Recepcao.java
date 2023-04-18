package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.*;

/**
 * Classe Recepcao, Possui m&eacute;todos que representam casos de uso que pode acontecer sem restri&ccedil;&atilde;o de acesso
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class Recepcao {

    /**
     * M&eacute;todo pegarOrdem, respons&aacute;vel por vincular uma ordem a um t&eacute;cnico
     *
     * @param tecnico t&eacute;cnico que receber&aacute; a ordem
     * @return Ordem - retorna uma ordem caso seja poss&iacute;vel pegar uma ordem e null caso contr&aacute;rio
     */
    public Ordem pegarOrdem(Tecnico tecnico) {
        if (DAO.getOrdem().getOrdens() != null) {
            for (int i = 0; i < DAO.getOrdem().getOrdens().size(); i++) {
                //Aqui verifica se a ordem não possui técnico
                if (DAO.getOrdem().getOrdens().get(i).getTecnicoId() == -1) {
                    //Aqui eu vinculo ordem a técnico
                    DAO.getTecnico().buscarPorId(tecnico.getTecnicoId()).setOrdem(DAO.getOrdem().getOrdens().get(i));
                    //Aqui eu vinculo técnico a ordem
                    DAO.getOrdem().getOrdens().get(i).setTecnicoId(tecnico.getTecnicoId());
                    return DAO.getOrdem().getOrdens().get(i);
                }
            }
        }
        return null;
    }

    /**
     * M&eacute;todo loginTecnico, respons&aacute;vel por logar em um Tecnico
     *
     * @param email email do t&eacute;cnico
     * @param senha senha do t&eacute;cnico
     * @return Tecnico - retorna Tecnico caso ele exista e null caso ele n&atilde;o exista para ser logado
     */
    public Tecnico loginTecnico(String email, String senha) {
        for (int i = 0; i < DAO.getTecnico().getTecnicos().size(); i++) {
            //Aqui verifica se o técnico foi encontrado
            if (DAO.getTecnico().getTecnicos().get(i).getEmail().equals(email) && DAO.getTecnico().getTecnicos().get(i).getSenha().equals(senha)) {
                return DAO.getTecnico().getTecnicos().get(i);
            }
        }
        return null;
    }

    /**
     * M&eacute;todo logoffTecnico, respons&aacute;vel por retornar um valor null
     *
     * @return Tecnico
     */
    public Tecnico logoffTecnico() {
        return null;
    }

    /**
     * M&eacute;todo cadastrarTecnico, respons&aacute;vel por cadatrar um Tecnico
     *
     * @param email email do t&eacute;cnico
     * @param nome nome do t&eacute;cnico
     * @param senha senha do t&eacute;cnico
     * @return boolean - retorna true caso consiga cadastrar e false caso ele j&aacute; esteja cadastrado
     */
    public boolean cadastrarTecnico(String email, String nome, String senha) {
        for (int i = 0; i < DAO.getTecnico().getTecnicos().size(); i++) {
            //Aqui eu verifico se o técnico já existe
            if (DAO.getTecnico().getTecnicos().get(i).getEmail().equals(email)) {
                return false;
            }
        }
        Tecnico tecnico = new Tecnico(email, nome, senha);
        if (DAO.getTecnico().getTecnicos().size() == 0) {
            //Aqui eu atribuo o cargo de administrador a técnico
            tecnico.setAdm(true);
        }
        //Aqui eu cadastro o técnico através do DAO de Tecnico
        DAO.getTecnico().criar(tecnico);
        return true;
    }

    /**
     * M&eacute;todo cadastrarCliente, respons&aacute;vel por cadastrar um cliente
     *
     * @param nome nome do cliente
     * @param endereco endere&ccedil;o do cliente
     * @param telefone telefone do cliente
     * @return boolean - retorna true caso consiga cadastrar o cliente e false caso o cliente j&aacute; exista
     */
    public boolean cadastrarCliente(String nome, String endereco, String telefone) {
        for (int i = 0; i < DAO.getCliente().getClientes().size(); i++) {
            //Aqui eu verifico se o cliente já existe
            if (DAO.getCliente().getClientes().get(i).getNome().equals(nome) && DAO.getCliente().getClientes().get(i).getEndereco().equals(endereco) && DAO.getCliente().getClientes().get(i).getTelefone().equals(telefone)) {
                return false;
            }
        }
        Cliente cliente = new Cliente(nome, endereco, telefone);
        //Aqui eu cadastro o cliente através do DAO de cliente
        DAO.getCliente().criar(cliente);
        return true;
    }

    /**
     * M&eacute;todo mediaTempoDeEspera, respons&aacute;vel por calcular o tempo m&eacute;dio de espera dos servi&ccedil;os de uma ordem
     *
     * @param ordem ordem que desejo obter o tempo m&eacute;dio dos servi&ccedil;os
     * @return double - valor do tempo m&eacute;dio
     */
    public double mediaTempoDeEspera(Ordem ordem) {
        double tempoTotalEspera = 0.0;
        double qnt = 0.0;
        for (int i = 0; i < DAO.getServico().getServicos().size(); i++) {
            //Aqui eu verifico se é possível efetuar a operação
            if (DAO.getServico().getServicos().get(i).getHorarioFechamento() != null && DAO.getServico().getServicos().get(i).getOrdemId() == ordem.getOrdemId())
                //Aqui eu faço a operação de soma de todos os tempos
                tempoTotalEspera += (DAO.getServico().getServicos().get(i).getHorarioFechamento().getTimeInMillis() - DAO.getServico().getServicos().get(i).getHorarioAbertura().getTimeInMillis());
            qnt++;
        }
        return (tempoTotalEspera/qnt)/(60.000*60);
    }

    /**
     * M&eacute;todo custoPeca, respons&aacute;vel por retornar uma string com todos os dados de todas as pe&ccedil;as da ordem
     *
     * @param ordem ordem a qual eu desejo obter os dados das pe&ccedil;as
     * @return String
     */
    public String custoPeca(Ordem ordem) {
        StringBuilder custoPeca = new StringBuilder();
        for(int i = 0; i < ordem.getServicos().size(); i++) {
            for(int ii = 0; ii < ordem.getServicos().get(i).getPecas().size(); ii++) {
                //Aqui eu concateno todas as peças da ordem uma a uma
                custoPeca.append("\n\n").append(ordem.getServicos().get(i).getPecas().get(ii));
            }
        }
        return custoPeca.toString();
    }

    /**
     * M&eacute;todo relatorioGeral, respons&aacute;vel por retornar uma string com todos os dados necess&aacute;rios para o ralat&oacute;rio
     *
     * @param ordem ordem a qual eu desejo gerar o relat&oacute;rio
     * @return String
     */
    public String relatorioGeral(Ordem ordem){
        String relatorio = "Desempenho do serviço:\n\n";
        //Aqui eu concateno todos os dados necessários na string relatorio
        relatorio = relatorio + "Tempo de espera: " + mediaTempoDeEspera(ordem) + "\n" + "Satisfação: " + ordem.getAvaliacaoFinal() + "\n" +
                "Custo pecas: " + custoPeca(ordem) + "\n" + "Situação do estoque: " + visualizarEstoque();
        return relatorio;
    }

    /**
     * M&eacute;todo visualizarEstoque, respons&aacute;vel por retornar uma string com todos os dados de todas as pe&ccedil;as da lista de pe&ccedil;as (estoque)
     *
     * @return String
     */
    public String visualizarEstoque(){
        StringBuilder estoque = new StringBuilder("Estoque: ");
        for(int i = 0; i < DAO.getPeca().getPecas().size(); i++){
            //Aqui eu concateno uma peça do estoque a string estoque através do DAO de peça
            estoque.append("\n\n").append(DAO.getPeca().getPecas().get(i).toString());
        }
        return estoque.toString();
    }

}