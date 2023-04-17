package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.CategoriaServico;
import com.example.sistemaparagerenciamento.model.Peca;
import com.example.sistemaparagerenciamento.model.Servico;
import java.util.List;

public class ServicoController {

    public boolean removerPecaDoServico(Servico servico, Peca peca) {
        for (int i = 0; i < DAO.getServico().getServicos().size(); i++) {
            if (DAO.getServico().getServicos().get(i).equals(servico)) {
                for (int j = 0; j < DAO.getServico().getServicos().get(i).getPecas().size(); j++) {
                    if (DAO.getServico().getServicos().get(i).getPecas().get(j).equals(peca)) {
                        DAO.getServico().getServicos().get(i).getPecas().remove(j);
                        DAO.getPeca().buscarPorNome(peca.getNome()).setQnt(DAO.getPeca().buscarPorNome(peca.getNome()).getQnt() + 1);
                        DAO.getServico().getServicos().get(i).setValor(DAO.getServico().getServicos().get(i).getValor() - DAO.getServico().getServicos().get(i).getPecas().get(j).getValor());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean adicionarPecaAoServico(Servico servico, Peca peca) {
        if(DAO.getPeca().buscarPorNome(peca.getNome()).getQnt() > 0) {
            for (int i = 0; i < DAO.getServico().getServicos().size(); i++) {
                if (DAO.getServico().getServicos().get(i).equals(servico) && DAO.getServico().getServicos().get(i).getCategoria().equals(CategoriaServico.MONTAGEM_INSTALACAO)) {
                    List<Peca> pecas = DAO.getServico().getServicos().get(i).getPecas();
                    pecas.add(peca);
                    DAO.getPeca().buscarPorNome(peca.getNome()).setQnt(DAO.getPeca().buscarPorNome(peca.getNome()).getQnt() - 1);
                    DAO.getServico().getServicos().get(i).setPeca(pecas);
                    if (peca.getNome().equals("RAM"))
                        DAO.getServico().getServicos().get(i).setValor(20);
                    else if (peca.getNome().equals("Placa mãe") || peca.getNome().equals("placa de vídeo"))
                        DAO.getServico().getServicos().get(i).setValor(100);
                    else if (peca.getNome().equals("fonte") || peca.getNome().equals("HD") || peca.getNome().equals("SSD"))
                        DAO.getServico().getServicos().get(i).setValor(30);
                    DAO.getServico().getServicos().get(i).setValor(DAO.getServico().getServicos().get(i).getValor() + peca.getValor());
                    return true;
                }
            }
        }
        return false;
    }

}