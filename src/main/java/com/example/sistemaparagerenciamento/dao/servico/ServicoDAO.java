package com.example.sistemaparagerenciamento.dao.servico;

import com.example.sistemaparagerenciamento.dao.CRUD;
import com.example.sistemaparagerenciamento.model.Peca;
import com.example.sistemaparagerenciamento.model.Servico;

import java.util.Calendar;

public interface ServicoDAO {

    public Servico criar(Servico servico);

    public void atualizar(Servico servico);

    public void deletar(Servico servico);

    public Servico buscarPorHorarioAbertura(Servico servico);

    //public void removerPecaDoServico(Peca peca);

    //public Peca adicionarPecaAoServico(Peca peca);
}
