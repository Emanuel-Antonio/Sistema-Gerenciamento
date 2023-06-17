package com.example.sistemaparagerenciamento.dao.pagamento;

import com.example.sistemaparagerenciamento.model.Pagamento;

import java.util.List;

/**
 * Interface PagamentoDAO que define m&eacute;todos que devem implementados
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public interface PagamentoDAO {

    /**
     * M&eacute;todo que cria um pagamento e adiciona na lista de pagamentos
     *
     * @param pagamento valor referente a um objeto Pagamento
     * @return Pagamento
     */
     Pagamento criar(Pagamento pagamento);

    /**
     * M&eacute;todo que atualiza um pagamento
     *
     * @param pagamento valor referente a um objeto Pagamento
     * @return Pagamento
     */
     Pagamento atualizar(Pagamento pagamento);

    /**
     * M&eacute;todo que deleta um pagamento e remove da lista de pagamentos
     *
     * @param pagamento valor referente a um objeto Pagamento
     */
    void deletar(Pagamento pagamento);

    /**
     * M&eacute;todo que busca um pagamento pelo seu identificador
     *
     * @param id valor referente ao identificador de um pagamento
     * @return Pagamento
     */
     Pagamento buscarPorId(int id);

    /**
     * M&eacute;todo que reseta a lista de pagamentos
     */
    void resetar();

    List<Pagamento> getPagamentos();

}