package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.OrdemCompra;
import com.example.sistemaparagerenciamento.model.Peca;

public class EstoqueController {

    public String visualizarEstoque(){
        StringBuilder estoque = new StringBuilder("Estoque: ");
        for(int i = 0; i < DAO.getPeca().getPecas().size(); i++){
            estoque.append("\n\n").append(DAO.getPeca().getPecas().get(i).toString());
        }
        return estoque.toString();
    }

    public Boolean cadastrarOrdemCompra(int qnt, double valorUnitario, String nome){
        if(qnt <= 0 || valorUnitario <= 0) {
            return false;
        }
        else {
            OrdemCompra ordemCompra = new OrdemCompra(qnt,valorUnitario,nome);
            DAO.getOrdemCompra().criar(ordemCompra);
            return true;
        }
    }

    public String visualizarOrdensCompra(){
        StringBuilder ordensCompra = new StringBuilder("Ordens de compra: ");
        for(int i = 0; i < DAO.getOrdemCompra().getOrdensCompra().size(); i++){
            ordensCompra.append("\n\n").append(DAO.getOrdemCompra().getOrdensCompra().get(i).toString());
        }
        return ordensCompra.toString();
    }

    public Boolean cadastrarPeca(String nome){
        for(int i = 0; i < DAO.getPeca().getPecas().size(); i++){
            if(DAO.getPeca().getPecas().get(i).getNome().equals(nome))
                return false;
        }
        Peca peca = new Peca(nome);
        DAO.getPeca().criar(peca);
        return true;
    }

    public Boolean adicionarPeca(Peca peca, int qnt, double valor){
        for(int i = 0; i < DAO.getPeca().getPecas().size(); i++){
            if(DAO.getPeca().getPecas().get(i).equals(peca)){
                double mediaValor = ((DAO.getPeca().getPecas().get(i).getValor() * DAO.getPeca().getPecas().get(i).getQnt()) + (valor * qnt))/(DAO.getPeca().getPecas().get(i).getQnt() + qnt);
                DAO.getPeca().getPecas().get(i).setValor(mediaValor);
                DAO.getPeca().getPecas().get(i).setQnt(DAO.getPeca().getPecas().get(i).getQnt() + qnt);
                return true;
            }
        }
        return false;
    }

}