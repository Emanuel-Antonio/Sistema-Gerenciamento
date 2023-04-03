package com.example.sistemaparagerenciamento.dao;

public interface CRUD <T> {

    public T criar(T obj);
    public T buscarPorId(Integer id);
    public void atualizar(T obj);
    public void deletar(Integer id);

}
