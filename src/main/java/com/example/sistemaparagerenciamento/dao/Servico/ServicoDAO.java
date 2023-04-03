package com.example.sistemaparagerenciamento.dao.Servico;

import com.example.sistemaparagerenciamento.dao.CRUD;
import com.example.sistemaparagerenciamento.model.Peca;
import com.example.sistemaparagerenciamento.model.Servico;

public interface ServicoDAO {

    public Boolean removerPecaDoServico(Peca peca);

    public Peca adicionarPecaAoServico(Peca peca);
}
