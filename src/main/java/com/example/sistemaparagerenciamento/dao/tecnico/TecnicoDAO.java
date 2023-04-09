package com.example.sistemaparagerenciamento.dao.tecnico;

import com.example.sistemaparagerenciamento.dao.CRUD;
import com.example.sistemaparagerenciamento.model.Tecnico;

import java.util.List;

public interface TecnicoDAO extends CRUD<Tecnico> {
    public List<Tecnico> getTecnicos();

    public void resetar();
}
