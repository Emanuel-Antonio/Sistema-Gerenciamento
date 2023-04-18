package com.example.sistemaparagerenciamento.dao.tecnico;

import com.example.sistemaparagerenciamento.model.Tecnico;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementa&ccedil;&atilde;o de TecnicoDAO com lista
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class TecnicoListImpl implements TecnicoDAO{

    private List<Tecnico> tecnicos;
    private int novoId;

    /**
     * Construtor de TecnicoListImpl, necess&aacute;rio para inicializar os atributos novoId e tecnicos.
     */
    public TecnicoListImpl() {
        this.novoId = 0;
        this.tecnicos = new ArrayList<>();
    }

    /**
     * M&eacute;todo que cria um t&eacute;cnico e adiciona na lista de t&eacute;cnicos
     *
     * @param tecnico valor referente a um objeto Tecnico
     * @return Tecnico
     */
    @Override
    public Tecnico criar(Tecnico tecnico) {
        tecnico.setTecnicoId(this.novoId);
        this.novoId++;
        this.tecnicos.add(tecnico);
        return tecnico;
    }

    /**
     * M&eacute;todo que busca um t&eacute;cnico pelo seu identificador
     *
     * @param id valor referente ao identificador do t&eacute;cnico
     * @return Tecnico
     */
    @Override
    public Tecnico buscarPorId(int id) {
        for (Tecnico tecnico : this.tecnicos) {
            if (tecnico.getTecnicoId() == id) {
                return tecnico;
            }
        }
        return null;
    }

    /**
     * M&eacute;todo que atualiza um t&eacute;cnico
     *
     * @param tecnico valor referente a um objeto Tecnico
     */
    @Override
    public void atualizar(Tecnico tecnico) {
        for (int i = 0; i < this.tecnicos.size(); i++) {
            if (this.tecnicos.get(i).getTecnicoId() == tecnico.getTecnicoId()) {
                this.tecnicos.set(i, tecnico);
            }
        }
    }

    /**
     * M&eacute;todo que deleta um t&eacute;cnico e remove da lista de t&eacute;cnicos
     *
     * @param id valor referente ao identificador do objeto Tecnico
     */
    @Override
    public void deletar(int id) {
        for (int i = 0; i < this.tecnicos.size(); i++) {
            if (this.tecnicos.get(i).getTecnicoId() == id) {
                this.tecnicos.remove(i);
            }
        }
    }

    /**
     * M&eacute;todo que retorna a lista de t&eacute;cnicos
     *
     * @return List
     */
    public List<Tecnico> getTecnicos(){
        return tecnicos;
    }

    /**
     * M&eacute;todo que reseta a lista de t&eacute;cnicos
     */
    @Override
    public void resetar() {
        this.tecnicos = new ArrayList<>();
        this.novoId = 0;
    }

}