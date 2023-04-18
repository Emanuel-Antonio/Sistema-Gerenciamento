package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.OrdemCompra;
import com.example.sistemaparagerenciamento.model.Peca;

/**
 * Classe EstoqueController, possui m&eacute;todos que representam casos de uso com uma lista de pe&ccedil;as (estoque)
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class EstoqueController {

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

    /**
     * M&eacute;todo cadastrarOrdemCompra, respons&aacute;vel por cadastrar uma ordem de compra
     *
     * @param qnt quantidade pe&ccedil;a
     * @param valorUnitario valor da pe&ccedil;a
     * @param nome nome da pe&ccedil;a
     * @return boolean - retorna true caso consiga gerar uma ordem de compra e false caso contr&aacute;rio
     */
    public boolean cadastrarOrdemCompra(int qnt, double valorUnitario, String nome){
        //Aqui eu verifico se os valores de qnt e valorUnitario não são válidos
        if(qnt <= 0 || valorUnitario <= 0) {
            return false;
        }
        else {
            OrdemCompra ordemCompra = new OrdemCompra(qnt,valorUnitario,nome);
            //Aqui adiciono uma ordem de compra ao DAO de ordem de compra
            DAO.getOrdemCompra().criar(ordemCompra);
            return true;
        }
    }

    /**
     * M&eacute;todo visualizarOrdensCompra, respons&aacute;vel por retornar uma string com todos os dados de todas as ordens de compra
     *
     * @return String
     */
    public String visualizarOrdensCompra(){
        StringBuilder ordensCompra = new StringBuilder("Ordens de compra: ");
        for(int i = 0; i < DAO.getOrdemCompra().getOrdensCompra().size(); i++){
            //Aqui eu concateno uma ordem de compra a string ordensCompra através do DAO de ordem compra
            ordensCompra.append("\n\n").append(DAO.getOrdemCompra().getOrdensCompra().get(i).toString());
        }
        return ordensCompra.toString();
    }

    /**
     * M&eacute;todo cadastrarPeca, respons&aacute;vel por cadastrar uma pe&ccedil;a
     *
     * @param nome nome da pe&ccedil;a
     * @return boolean - retorna true caso consiga criar pe&ccedil;a e false caso a pe&ccedil;a j&aacute; esteja cadastrada
     */
    public boolean cadastrarPeca(String nome){
        for(int i = 0; i < DAO.getPeca().getPecas().size(); i++){
            //Aqui verifico se a peça já existe
            if(DAO.getPeca().getPecas().get(i).getNome().equals(nome))
                return false;
        }
        Peca peca = new Peca(nome);
        //Aqui eu adiciono peça ao DAO de peça
        DAO.getPeca().criar(peca);
        return true;
    }

    /**
     * M&eacute;todo adicionarPeca, respons&aacute;vel por adicionar uma quantidade de pe&ccedil;a ao estoque
     *
     * @param nome nome da pe&ccedil;a
     * @param qnt quantidade da pe&ccedil;a
     * @param valor valor da pe&ccedil;a
     * @return boolean - retorna true caso a pe&ccedil;a exista no estoque, para ter a sua quantidade e valor alterado e false caso n&atilde;o exista
     */
    public boolean adicionarPeca(String nome, int qnt, double valor){
        for(int i = 0; i < DAO.getPeca().getPecas().size(); i++){
            //Aqui eu verifico se a peça já existe
            if(DAO.getPeca().getPecas().get(i).getNome().equals(nome)){
                //Aqui eu calculo a média dos preços da peça
                double mediaValor = ((DAO.getPeca().getPecas().get(i).getValor() * DAO.getPeca().getPecas().get(i).getQnt()) + (valor * qnt))/(DAO.getPeca().getPecas().get(i).getQnt() + qnt);
                //Aqui eu atualizo o preço da peça no DAO de peça
                DAO.getPeca().getPecas().get(i).setValor(mediaValor);
                //Aqui eu adiciono a quantidade de peças no DAO de peça
                DAO.getPeca().getPecas().get(i).setQnt(DAO.getPeca().getPecas().get(i).getQnt() + qnt);
                return true;
            }
        }
        return false;
    }

}