package com.example.sistemaparagerenciamento.dao.Servico;

import com.example.sistemaparagerenciamento.model.Peca;

import java.util.ArrayList;
import java.util.List;

public class ServicoListImpl implements ServicoDAO {

    public List<Peca> pecas;

    public Peca peca;
    private int ordemId;

    public ServicoListImpl() {
        this.pecas = new ArrayList<Peca>();
    }

    @Override
    public void removerPecaDoServico(Peca peca) {
        for(Peca i : this.pecas){
            if(i.getNome() == peca.getNome())
                this.pecas.remove(peca);
        }

    }

    @Override
    public Peca adicionarPecaAoServico(Peca peca) {
        this.pecas.add(peca);

        return peca;
    }

}
