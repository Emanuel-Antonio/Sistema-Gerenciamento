package com.example.sistemaparagerenciamento.dao.ordem;

import com.example.sistemaparagerenciamento.dao.CRUD;
import com.example.sistemaparagerenciamento.model.Ordem;

import java.util.List;

public interface OrdemDAO extends CRUD<Ordem> {

    public List<Ordem> getOrdens();

    public void resetar();

}
