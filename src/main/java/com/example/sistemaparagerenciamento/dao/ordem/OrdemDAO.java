package com.example.sistemaparagerenciamento.dao.ordem;

import com.example.sistemaparagerenciamento.dao.CRUD;
import com.example.sistemaparagerenciamento.model.Ordem;

public interface OrdemDAO extends CRUD<Ordem> {
    public Ordem buscarPorId(int id);
}
