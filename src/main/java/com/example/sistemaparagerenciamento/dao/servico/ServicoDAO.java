package com.example.sistemaparagerenciamento.dao.servico;

import com.example.sistemaparagerenciamento.model.Servico;

public interface ServicoDAO {

    public Servico criar(Servico servico);

    public void atualizar(Servico servico);

    public void deletar(Servico servico);

    public Servico buscarPorHorarioAbertura(Servico servico);

    //public void removerPecaDoServico(Peca peca);

    //public Peca adicionarPecaAoServico(Peca peca);
}
