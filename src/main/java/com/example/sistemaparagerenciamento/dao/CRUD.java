package com.example.sistemaparagerenciamento.dao;

/**
 * Interface CRUD para definir as quatro operações Create (criar), Read (buscar), Update (atualizar) e Delete (deletar)
 *
 * @param <T>
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public interface CRUD <T> {

    /**
     * Método que cria um objeto
     *
     * @param obj
     * @return
     */
    public T criar(T obj);

    /**
     * Método que busca um objeto por identificador
     *
     * @param id valor referente ao identificador do objeto
     * @return
     */
    public T buscarPorId(int id);

    /**
     * Método que atualiza um objeto
     *
     * @param obj
     */
    public void atualizar(T obj);

    /**
     * Método que deleta um objeto
     *
     * @param id valor referente ao identificador do objeto
     */
    public void deletar(int id);

}