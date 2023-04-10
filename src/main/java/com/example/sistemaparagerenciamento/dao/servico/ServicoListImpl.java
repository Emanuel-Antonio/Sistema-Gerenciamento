package com.example.sistemaparagerenciamento.dao.servico;

import com.example.sistemaparagerenciamento.model.Servico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ServicoListImpl implements ServicoDAO {

    public List<Servico> servicos;

    public int novoId;

    public ServicoListImpl() {
        this.servicos = new ArrayList<Servico>();
        this.novoId = 0;
    }

    @Override
    public Servico criar(Servico servico) {
        servico.setHorarioAbertura(Calendar.getInstance());
        servico.setServicoId(this.novoId);
        this.novoId++;
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

    public List<Servico> getServicos() {
        return servicos;
    }

    @Override
    public void resetar() {
        this.servicos = new ArrayList<>();
    }

}
