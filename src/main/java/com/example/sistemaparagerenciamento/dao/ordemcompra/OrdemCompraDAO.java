package com.example.sistemaparagerenciamento.dao.ordemcompra;

import com.example.sistemaparagerenciamento.model.OrdemCompra;

import java.util.List;

public interface OrdemCompraDAO {

    public OrdemCompra criar(OrdemCompra ordemCompra);

    public void deletar(OrdemCompra ordemCompra);

    public void atualizar(OrdemCompra ordemCompra);

    public OrdemCompra buscarPorId(int id);

    public List<OrdemCompra> getOrdensCompra();

}

