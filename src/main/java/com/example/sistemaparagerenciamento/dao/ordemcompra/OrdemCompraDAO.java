package com.example.sistemaparagerenciamento.dao.ordemcompra;

import com.example.sistemaparagerenciamento.model.OrdemCompra;

public interface OrdemCompraDAO {

    public OrdemCompra criar(OrdemCompra ordemCompra);

    public void deletar(OrdemCompra ordemCompra);

    public void atualizar(OrdemCompra ordemCompra);

    public OrdemCompra buscarPorId(int id);
}

