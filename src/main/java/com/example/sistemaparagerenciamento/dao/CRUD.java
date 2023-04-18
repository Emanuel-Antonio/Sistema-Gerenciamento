package com.example.sistemaparagerenciamento.dao;

/**
 * Interface CRUD para definir as quatro opera&ccedil;&otilde;es Create (criar), Read (buscar), Update (atualizar) e Delete (deletar)
 *
 * @param <T>
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public interface CRUD <T> {

    /**
     * M&eacute;todo que cria um objeto
     *
     * @param obj valor referente a um objeto
     * @return T
     */
     T criar(T obj);

    /**
     * M&eacute;todo que busca um objeto por identificador
     *
     * @param id valor referente ao identificador do objeto
     * @return T
     */
     T buscarPorId(int id);

    /**
     * M&eacute;todo que atualiza um objeto
     *
     * @param obj valor referente a um objeto
     */
     void atualizar(T obj);

    /**
     * M&eacute;todo que deleta um objeto
     *
     * @param id valor referente ao identificador do objeto
     */
    void deletar(int id);

}