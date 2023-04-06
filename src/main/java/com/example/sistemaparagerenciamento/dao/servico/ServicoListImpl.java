package com.example.sistemaparagerenciamento.dao.servico;

import com.example.sistemaparagerenciamento.model.Servico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ServicoListImpl implements ServicoDAO {

    public List<Servico> servicos;

    public ServicoListImpl() {
        this.servicos = new ArrayList<Servico>();
    }

    @Override
    public Servico criar(Servico servico) {
        servico.setHorarioAbertura(Calendar.getInstance());

        this.servicos.add(servico);

        return servico;
    }

    @Override
    public Servico buscarPorId(int id) {
        for (Servico servico : this.servicos) {
            if (servico.getServicoId() == id)
                return servico;

        }
        return null;
    }

    @Override
    public void atualizar(Servico servico) {
        for(int i = 0; i < this.servicos.size(); i++){
            if (this.servicos.get(i).equals(servico))
                this.servicos.set(i, servico);
        }
    }

    @Override
    public void deletar(Servico servico) {
        for(int i = 0; i < this.servicos.size(); i++){
            if (this.servicos.get(i).equals(servico))
                this.servicos.remove(i);
        }
    }

    /*@Override
    public void removerPecaDoServico(Peca peca) {
        for(int i = 0; i < this.pecas.size(); i++){
            if(this.pecas.get(i).equals(peca))
                this.pecas.remove(i);
        }

    }*/

    /*@Override
    public Peca adicionarPecaAoServico(Peca peca) {
        for(Peca i : this.pecas){
            if(i.equals(peca))
                return peca;
        }
        this.pecas.add(peca);

        return peca;
    }*/

}
