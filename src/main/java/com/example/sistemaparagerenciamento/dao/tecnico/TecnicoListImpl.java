package com.example.sistemaparagerenciamento.dao.tecnico;

import com.example.sistemaparagerenciamento.model.Ordem;
import com.example.sistemaparagerenciamento.model.Tecnico;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TecnicoListImpl implements TecnicoDAO{

    private List<Tecnico> tecnicos;

    private Integer novoId;

    public TecnicoListImpl() {
        this.novoId = 0;
        this.tecnicos = new ArrayList<Tecnico>();
    }

    @Override
    public Tecnico criar(Tecnico tecnico) {
        tecnico.setTecnicoId(this.novoId);
        this.novoId++;
        this.tecnicos.add(tecnico);
        return tecnico;
    }

    @Override
    public Tecnico buscarPorId(Integer id) {
        for(Tecnico tecnico : this.tecnicos){
            if(Objects.equals(tecnico.getTecnicoId(),id))
                return tecnico;
        }
        return null;
    }

    @Override
    public void atualizar(Tecnico tecnico) {
        for (int i = 0; i < this.tecnicos.size(); i++) {
            if (this.tecnicos.get(i).equals(tecnico)) {
                this.tecnicos.set(i, tecnico);
            }
        }
    }

    @Override
    public void deletar(Integer id) {
        for (int i = 0; i < this.tecnicos.size(); i++) {
            if (Objects.equals(this.tecnicos.get(i).getTecnicoId(),id)) {
                this.tecnicos.remove(i);
            }
        }
    }
}
