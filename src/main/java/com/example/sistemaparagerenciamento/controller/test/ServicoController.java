package com.example.sistemaparagerenciamento.controller.test;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.CategoriaServico;
import com.example.sistemaparagerenciamento.model.Peca;
import com.example.sistemaparagerenciamento.model.Servico;
import java.util.List;

/**
 * Classe ServicoController, possui m&eacute;todos que representam casos de uso com um servi&ccedil;o
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class ServicoController {

    /**
     * M&eacute;todo removerPecaDoServico, remove uma pe&ccedil;a do servi&ccedil;o
     *
     * @param servico servi&ccedil;o o qual ser&aacute; subtraido pe&ccedil;a
     * @param peca a pe&ccedil;a que ser&aacute; removida de servi&ccedil;o
     * @return boolean - retorna true caso consiga remover pe&ccedil;a e false caso contr&aacute;rio
     */
    public boolean removerPecaDoServico(Servico servico, Peca peca) {
        for (int i = 0; i < DAO.getServico().getServicos().size(); i++) {
            if (DAO.getServico().getServicos().get(i).equals(servico)) {
                for (int j = 0; j < DAO.getServico().getServicos().get(i).getPecas().size(); j++) {
                    if (DAO.getServico().getServicos().get(i).getPecas().get(j).equals(peca)) {
                        //Aqui eu removo peça do serviço pelo DAO de serviço
                        DAO.getServico().getServicos().get(i).getPecas().remove(j);
                        //Aqui eu adiciono a quantidade removida da peça ao estoque pelo DAO de peça
                        DAO.getPeca().buscarPorNome(peca.getNome()).setQnt(DAO.getPeca().buscarPorNome(peca.getNome()).getQnt() + 1);
                        //Aqui eu reajusto o valor do serviço, visto que eu removi uma peça
                        DAO.getServico().getServicos().get(i).setValor(DAO.getServico().getServicos().get(i).getValor() - DAO.getServico().getServicos().get(i).getPecas().get(j).getValor());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * M&eacute;todo adicionarPecaAoServico, adiciona uma pe&ccedil;a ao servi&ccedil;o
     *
     * @param servico servi&ccedil;o o qual ser&aacute; adicionado pe&ccedil;a
     * @param peca a pe&ccedil;a que ser&aacute; removida se servi&ccedil;o
     * @return boolean - retorna true caso consiga adicionar pe&ccedil;a ao servi&ccedil;o e false caso contr&aacute;rio
     */
    public boolean adicionarPecaAoServico(Servico servico, Peca peca) {
        if(DAO.getPeca().buscarPorNome(peca.getNome()).getQnt() > 0) {
            for (int i = 0; i < DAO.getServico().getServicos().size(); i++) {
                //Aqui eu verifico se é uma montagem para que seja possível adicionar peças
                if (DAO.getServico().getServicos().get(i).equals(servico) && DAO.getServico().getServicos().get(i).getCategoria().equals(CategoriaServico.MONTAGEM_INSTALACAO)) {
                    List<Peca> pecas = DAO.getServico().getServicos().get(i).getPecas();
                    pecas.add(peca);
                    //Aqui eu removo a peça do estoque em DAO de peça
                    DAO.getPeca().buscarPorNome(peca.getNome()).setQnt(DAO.getPeca().buscarPorNome(peca.getNome()).getQnt() - 1);
                    //Aqui eu adiciono a peça ao serviço pelo DAO de serviço
                    DAO.getServico().getServicos().get(i).setPeca(pecas);
                    if (peca.getNome().equals("RAM"))
                        //Aqui eu adiciono um valor do serviço de montagem/instalação da peça RAM
                        DAO.getServico().getServicos().get(i).setValor(20);
                    else if (peca.getNome().equals("Placa mãe") || peca.getNome().equals("placa de vídeo"))
                        //Aqui eu adiciono um valor do serviço de montagem/instalação da peça Placa mãe
                        DAO.getServico().getServicos().get(i).setValor(100);
                    else if (peca.getNome().equals("fonte") || peca.getNome().equals("HD") || peca.getNome().equals("SSD"))
                        //Aqui eu adiciono um valor do serviço de montagem/instalação da peça fonte
                        DAO.getServico().getServicos().get(i).setValor(30);
                    //Aqui eu adiciono o valor da peça ao serviço através do DAO de serviço
                    DAO.getServico().getServicos().get(i).setValor(DAO.getServico().getServicos().get(i).getValor() + peca.getValor());
                    return true;
                }
            }
        }
        return false;
    }

}