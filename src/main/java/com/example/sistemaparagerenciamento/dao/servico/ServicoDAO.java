package com.example.sistemaparagerenciamento.dao.servico;

import com.example.sistemaparagerenciamento.model.Peca;

public interface ServicoDAO {

    public void removerPecaDoServico(Peca peca);

    public Peca adicionarPecaAoServico(Peca peca);
}
