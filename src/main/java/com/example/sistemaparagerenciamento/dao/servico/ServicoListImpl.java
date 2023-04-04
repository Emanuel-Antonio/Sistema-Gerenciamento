package com.example.sistemaparagerenciamento.dao.servico;

import com.example.sistemaparagerenciamento.model.Peca;

import java.util.ArrayList;
import java.util.List;

public class ServicoListImpl implements ServicoDAO {

    public List<Peca> pecas;

    public ServicoListImpl() {
        this.pecas = new ArrayList<Peca>();
    }

    @Override
    public void removerPecaDoServico(Peca peca) {
        for(int i = 0; i < this.pecas.size(); i++){
            if(this.pecas.get(i).equals(peca))
                this.pecas.remove(i);
        }

    }

    @Override
    public Peca adicionarPecaAoServico(Peca peca) {
        for(Peca i : this.pecas){
            if(i.equals(peca))
                return peca;
        }
        this.pecas.add(peca);

        return peca;
    }

}
