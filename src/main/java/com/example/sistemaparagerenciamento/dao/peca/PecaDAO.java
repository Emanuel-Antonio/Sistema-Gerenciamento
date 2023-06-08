package com.example.sistemaparagerenciamento.dao.peca;

import com.example.sistemaparagerenciamento.model.Peca;
import java.util.List;

/**
 * Interface PecaDAO que define m&eacute;todos que devem implementados
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public interface PecaDAO {

    /**
     * M&eacute;todo que cria uma pe&ccedil;a e adiciona na lista de pe&ccedil;as
     *
     * @param peca valor referente a um objeto Peca
     * @return Peca
     */
    Peca criar(Peca peca);

    /**
     * M&eacute;todo que atualiza uma pe&ccedil;a
     *
     * @param peca valor referente a um objeto Peca
     */
    void atualizar(Peca peca);

    /**
     * M&eacute;todo que deleta uma pe&ccedil;a e remove da lista de pe&ccedil;as
     *
     * @param peca valor referente a um objeto Peca
     */
    void deletar(Peca peca);

    /**
     * M&eacute;todo que busca uma pe&ccedil;a pelo seu nome
     *
     * @param nome valor referente ao nome da pe&ccedil;a
     * @return Peca
     */
    Peca buscarPorNome(String nome);

    /**
     * M&eacute;todo que retorna uma lista de pe&ccedil;as
     *
     * @return List
     */
    List<Peca> getPecas();

    /**
     * M&eacute;todo que reseta a lista de pe&ccedil;as
     */
    void resetar();

    List<String> listPecasNomes();

}