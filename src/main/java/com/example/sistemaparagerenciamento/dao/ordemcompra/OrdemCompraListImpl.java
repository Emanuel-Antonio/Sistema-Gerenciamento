package com.example.sistemaparagerenciamento.dao.ordemcompra;

import com.example.sistemaparagerenciamento.model.OrdemCompra;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementa&ccedil;&atilde;o de OrdemCompraDAO com lista
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class OrdemCompraListImpl implements OrdemCompraDAO{

    public List<OrdemCompra> ordensCompra;
    public int novoId;

    /**
     * Construtor de OrdemCompraListImpl, necess&aacute;rio para inicializar os atributos novoId e ordensCompra.
     */
    public OrdemCompraListImpl() {
        this.ordensCompra = new ArrayList<>();
        this.novoId = 0;
    }

    /**
     * M&eacute;todo que cria uma ordem de compra e adiciona na lista de ordens de compra
     *
     * @param ordemCompra valor referente a um objeto OrdemCompra
     * @return OrdemCompra
     */
    @Override
    public OrdemCompra criar(OrdemCompra ordemCompra) {
        ordemCompra.setOrdemCompraId(this.novoId);
        this.novoId++;
        this.ordensCompra.add(ordemCompra);
        return ordemCompra;
    }

    /**
     * M&eacute;todo que busca uma ordem de compra pelo seu identificador
     *
     * @param id valor referente ao identificador da ordem de compra
     * @return OrdemCompra
     */
    @Override
    public OrdemCompra buscarPorId(int id) {
        for(OrdemCompra ordemCompra : this.ordensCompra){
            if(ordemCompra.getOrdemCompraId() == id){
                return ordemCompra;
            }
        }
        return null;
    }

    /**
     * M&eacute;todo que atualiza uma ordem de compra
     *
     * @param ordemCompra valor referente a um objeto OrdemCompra
     */
    @Override
    public void atualizar(OrdemCompra ordemCompra) {
        for(int i = 0; i < this.ordensCompra.size(); i++){
            if(this.ordensCompra.get(i).equals(ordemCompra)){
                this.ordensCompra.set(i,ordemCompra);
            }
        }
    }

    /**
     * M&eacute;todo que deleta uma ordem de compra e remove da lista de ordens de compra
     *
     * @param ordemCompra valor referente a um objeto OrdemCompra
     */
    @Override
    public void deletar(OrdemCompra ordemCompra) {
        for(int i = 0; i < this.ordensCompra.size(); i++){
            if (this.ordensCompra.get(i).equals(ordemCompra))
                this.ordensCompra.remove(i);
        }
    }

    /**
     * M&eacute;todo que retorna a lista de ordens de compra
     *
     * @return List
     */
    @Override
    public List<OrdemCompra> getOrdensCompra() {
        return ordensCompra;
    }

    /**
     * M&eacute;todo que reseta a lista de ordens de compra
     */
    @Override
    public void resetar(){
        this.ordensCompra = new ArrayList<>();
        this.novoId = 0;
    }

}