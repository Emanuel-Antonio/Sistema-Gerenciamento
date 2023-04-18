package com.example.sistemaparagerenciamento.dao.servico;

import com.example.sistemaparagerenciamento.model.Servico;
import java.util.List;

/**
 * Interface ServicoDAO que define m&eacute;todos que devem implementados
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public interface ServicoDAO {

    /**
     * M&eacute;todo que cria um servi&ccedil;o e adiciona na lista de servi&ccedil;os
     *
     * @param servico valor referente a um objeto Servico
     * @return Servico
     */
     Servico criar(Servico servico);

   /**
    * M&eacute;todo que atualiza um servi&ccedil;o
    *
    * @param servico valor referente ao objeto Servico
    */
     void atualizar(Servico servico);

    /**
     * M&eacute;todo que deleta um servi&ccedil;o e remove da lista de servi&ccedil;os
     *
     * @param servico valor referente a um objeto Servico
     */
     void deletar(Servico servico);

    /**
     * M&eacute;todo que busca um servi&ccedil;o pelo seu identificador
     *
     * @param id valor referente ao identificador do servi&ccedil;o
     * @return Servico
     */
     Servico buscarPorId(int id);

    /**
     * M&eacute;todo que retorna uma lista de servi&ccedil;os
     *
     * @return List<Servico>
     */
     List<Servico> getServicos();

    /**
     * M&eacute;todo que reseta a lista de servi&ccedil;os
     */
    void resetar();

}