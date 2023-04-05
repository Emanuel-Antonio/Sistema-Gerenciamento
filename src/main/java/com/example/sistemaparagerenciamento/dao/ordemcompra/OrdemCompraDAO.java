package com.example.sistemaparagerenciamento.dao.ordemcompra;

import com.example.sistemaparagerenciamento.dao.CRUD;
import com.example.sistemaparagerenciamento.model.OrdemCompra;

public interface OrdemCompraDAO {

    public OrdemCompra criar(OrdemCompra ordemCompra);

    public void deletar(int id);
}
