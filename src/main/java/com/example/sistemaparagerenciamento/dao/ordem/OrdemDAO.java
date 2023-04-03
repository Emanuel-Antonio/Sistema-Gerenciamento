package com.example.sistemaparagerenciamento.dao.ordem;

import com.example.sistemaparagerenciamento.dao.CRUD;
import com.example.sistemaparagerenciamento.model.Ordem;
import com.example.sistemaparagerenciamento.model.Servico;

public interface OrdemDAO extends CRUD<Ordem> {
    public Ordem buscarPorId(int id);

    public Servico adicionarServico(Servico servico);

    public Boolean removerServico(Servico servico);

}
