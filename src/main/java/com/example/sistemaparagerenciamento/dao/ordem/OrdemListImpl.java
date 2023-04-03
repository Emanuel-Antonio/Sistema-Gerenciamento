package com.example.sistemaparagerenciamento.dao.ordem;

import com.example.sistemaparagerenciamento.model.Ordem;
import com.example.sistemaparagerenciamento.model.Servico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.spi.CalendarDataProvider;

public class OrdemListImpl implements OrdemDAO {

    private Integer novoId;

    private List<Ordem> ordens;

    private List<Servico> servicos;

    public OrdemListImpl() {
        this.novoId = 0;
        this.ordens = new ArrayList<Ordem>();
        this.servicos = new ArrayList<Servico>();
    }

    @Override
    public Ordem criar(Ordem ordem) {
        ordem.setOrdemId(this.novoId);
        this.novoId++;

        this.ordens.add(ordem);

        return ordem;
    }

    @Override
    public Ordem buscarPorId(Integer id) {
        for(Ordem ordem : this.ordens){
            if(ordem.getOrdemId() == id)
                return ordem;
        }
        return null;
    }

    @Override
    public Servico adicionarServico(Servico servico) {
        for(Servico i : this.servicos){
            if(i.getHorarioAbertura().equals(servico.getHorarioAbertura())){
                return servico;
            }
        }
        this.servicos.add(servico);

        return servico;
    }

    @Override
    public Boolean removerServico(Servico servico) {
        for(Servico i : this.servicos) {
            if (i.getHorarioAbertura().equals(servico.getHorarioAbertura())) {
                this.servicos.remove(servico);
                return true;
            }
        }
        return false;
    }

    @Override
    public void atualizar(Ordem ordem) {
        for (int i = 0; i < this.ordens.size(); i++) {
            if (this.ordens.get(i).getOrdemId() == ordem.getOrdemId()) {
                this.ordens.set(i, ordem);
            }
        }
    }

    @Override
    public void deletar(Integer id) {
        for (int i = 0; i < this.ordens.size(); i++) {
            if (this.ordens.get(i).getOrdemId() == id) {
                this.ordens.remove(i);
            }
        }
    }
}