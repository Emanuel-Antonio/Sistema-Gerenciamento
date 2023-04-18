package com.example.sistemaparagerenciamento.dao.ordem;

import com.example.sistemaparagerenciamento.model.Ordem;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementa&ccedil;&atilde;o de OrdemDAO com lista
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class OrdemListImpl implements OrdemDAO {

    private int novoId;
    private List<Ordem> ordens;

    /**
     * Construtor de OrdemListImpl, necess&aacute;rio para inicializar os atributos novoId e ordens.
     */
    public OrdemListImpl() {
        this.novoId = 0;
        this.ordens = new ArrayList<>();
    }

    /**
     * M&eacute;todo que cria um ordem e adiciona na lista de ordens
     *
     * @param ordem valor referente a um objeto Ordem
     * @return Ordem
     */
    @Override
    public Ordem criar(Ordem ordem) {
        ordem.setOrdemId(this.novoId);
        this.novoId++;
        this.ordens.add(ordem);
        return ordem;
    }

    /**
     * M&eacute;todo que busca uma ordem pelo seu identificador
     *
     * @param id valor referente ao identificador da ordem
     * @return Ordem
     */
    @Override
    public Ordem buscarPorId(int id) {
        for(Ordem ordem : this.ordens){
            if(ordem.getOrdemId() == id)
                return ordem;
        }
        return null;
    }

    /**
     * M&eacute;todo que atualiza um ordem
     *
     * @param ordem valor referente a um objeto Ordem
     */
    @Override
    public void atualizar(Ordem ordem) {
        for (int i = 0; i < this.ordens.size(); i++) {
            if (this.ordens.get(i).equals(ordem)) {
                this.ordens.set(i, ordem);
            }
        }
    }

    /**
     * M&eacute;todo que deleta uma ordem e remove da lista de ordens
     *
     * @param id valor referente ao identificador do objeto Ordem
     */
    @Override
    public void deletar(int id) {
        for (int i = 0; i < this.ordens.size(); i++) {
            if (this.ordens.get(i).getOrdemId() == id) {
                this.ordens.remove(i);
            }
        }
    }

    /**
     * M&eacute;todo que retorna a lista de ordens
     *
     * @return List
     */
    @Override
    public List<Ordem> getOrdens() {
        return ordens;
    }

    /**
     * M&eacute;todo que reseta a lista de ordens
     */
    @Override
    public void resetar(){
        this.ordens = new ArrayList<>();
        this.novoId = 0;
    }

}