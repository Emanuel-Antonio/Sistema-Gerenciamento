package com.example.sistemaparagerenciamento.dao.ordem;

import com.example.sistemaparagerenciamento.model.Ordem;

import java.util.ArrayList;
import java.util.List;

public class OrdemListImpl implements OrdemDAO {

    private int novoId;

    private List<Ordem> ordens;

    public OrdemListImpl() {
        this.novoId = 0;
        this.ordens = new ArrayList<Ordem>();
    }


    @Override
    public Ordem criar(Ordem ordem) {
        ordem.setOrdemId(this.novoId);
        this.novoId++;

        this.ordens.add(ordem);

        return ordem;
    }

    @Override
    public Ordem buscarPorId(int id) {
        for(Ordem ordem : this.ordens){
            if(ordem.equals(id))
                return ordem;
        }
        return null;
    }

    @Override
    public void atualizar(Ordem ordem) {
        for (int i = 0; i < this.ordens.size(); i++) {
            if (this.ordens.get(i).equals(ordem)) {
                this.ordens.set(i, ordem);
            }
        }
    }

    @Override
    public void deletar(int id) {
        for (int i = 0; i < this.ordens.size(); i++) {
            if (this.ordens.get(i).getOrdemId() == id) {
                this.ordens.remove(i);
            }
        }
    }

    @Override
    public List<Ordem> getOrdens() {
        return ordens;
    }

    @Override
    public void resetar(){
        this.ordens = new ArrayList<>();
        this.novoId = 0;
    }
}