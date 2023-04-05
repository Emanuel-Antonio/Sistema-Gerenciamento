package com.example.sistemaparagerenciamento.dao.peca;

import com.example.sistemaparagerenciamento.model.Peca;
import com.example.sistemaparagerenciamento.model.Servico;

public interface PecaDAO {

    public Peca criar(Peca peca);

    public void atualizar(Peca peca);

    public void deletar(Peca peca);

    public Peca buscarPorNome(Peca peca);
}
