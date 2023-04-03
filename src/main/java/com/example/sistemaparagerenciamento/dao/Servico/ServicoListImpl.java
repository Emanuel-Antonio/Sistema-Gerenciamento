package com.example.sistemaparagerenciamento.dao.Servico;

import com.example.sistemaparagerenciamento.model.Peca;
import com.example.sistemaparagerenciamento.model.Servico;

import java.util.ArrayList;
import java.util.List;

public class ServicoListImpl implements ServicoDAO {

    public List<Peca> pecas;

    public Peca peca;
    private Integer ordemId;

    public ServicoListImpl() {
        this.pecas = new ArrayList<Peca>();
    }

    @Override
    public Boolean removerPecaDoServico(Peca peca) {
        this.pecas.remove(peca);

        return null;
    }

    @Override
    public Peca adicionarPecaAoServico(Peca peca) {
        this.pecas.add(peca);

        return peca;
    }

}
