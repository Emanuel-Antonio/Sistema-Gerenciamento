package com.example.sistemaparagerenciamento.dao.ordemcompra;

import com.example.sistemaparagerenciamento.model.OrdemCompra;
import java.util.List;

/**
 * Interface ClienteDAO que define m&eacute;todos que devem implementados
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public interface OrdemCompraDAO {

    /**
     * M&eacute;todo que cria uma ordem de compra e adiciona na lista de ordens de compra
     *
     * @param ordemCompra valor referente a um objeto OrdemCompra
     * @return OrdemCompra
     */
     OrdemCompra criar(OrdemCompra ordemCompra);

    /**
     * M&eacute;todo que deleta uma ordem de compra e remove da lista de ordens de compra
     *
     * @param ordemCompra valor referente a um objeto OrdemCompra
     */
    void deletar(OrdemCompra ordemCompra);

    /**
     * M&eacute;todo que atualiza uma ordem de compra
     *
     * @param ordemCompra valor referente a um objeto OrdemCompra
     */
     void atualizar(OrdemCompra ordemCompra);

    /**
     * M&eacute;todo que busca uma ordem de compra pelo seu identificador
     *
     * @param id valor referente ao identificador da ordem de compra
     * @return OrdemCompra
     */
     OrdemCompra buscarPorId(int id);

    /**
     * M&eacute;todo que retorna a lista de ordens de compra
     *
     * @return List<OrdemCompra>
     */
    List<OrdemCompra> getOrdensCompra();

    /**
     * M&eacute;todo que reseta a lista de ordens de compra
     */
    void resetar();

}