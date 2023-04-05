package com.example.sistemaparagerenciamento.dao.peca;

import com.example.sistemaparagerenciamento.model.Peca;
import com.example.sistemaparagerenciamento.model.Servico;

import java.util.ArrayList;
import java.util.List;

public class PecaListImpl implements PecaDAO{

    public List<Peca> pecas;

    public PecaListImpl() {
        this.pecas = new ArrayList<Peca>();
    }


    @Override
    public Peca criar(Peca peca) {
        this.pecas.add(peca);

        return peca;
    }

    @Override
    public void atualizar(Peca peca) {
        for(int i = 0; i < this.pecas.size(); i++){
            if (this.pecas.get(i).getNome().equals(peca.getNome()))
                this.pecas.set(i, peca);
        }
    }

    @Override
    public void deletar(Peca peca) {
        for(int i = 0; i < this.pecas.size(); i++){
            if (this.pecas.get(i).getNome().equals(peca.getNome()))
                this.pecas.remove(i);
        }
    }

    @Override
    public Peca buscarPorNome(Peca peca) {
        for (Peca i : this.pecas) {
            if (i.equals(peca))
                return peca;

        }
        return null;
    }
}
