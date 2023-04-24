package com.example.sistemaparagerenciamento.dao.ordemcompra;
import com.example.sistemaparagerenciamento.model.OrdemCompra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

/**
 * Implementa&ccedil;&atilde;o de OrdemCompraDAO com arquivo
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class OrdemCompraFileImpl implements OrdemCompraDAO{
    private String filename;

    public List<OrdemCompra> ordensCompra;

    public int novoId;

    /**
     * Construtor de OrdemCompraFileImpl, necess&aacute;rio para inicializar os atributos novoId e ordensCompra e atribuir o nome do arquivo.
     */
    public OrdemCompraFileImpl(String filename) {
        this.filename = filename;
        this.ordensCompra = new ArrayList<>();
        this.novoId = 0;
        this.ordensCompra = ler();
    }

    /**
     * M&eacute;todo que salva a lista com os dados dos objetos em arquivo
     *
     * @param ordensCompra valor referente a lista de ordens de compra
     */
    public void salvar(List<OrdemCompra> ordensCompra) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.filename));
            for (OrdemCompra ordemCompra : ordensCompra) {
                file.writeObject(ordemCompra);
            }
            file.close();
        } catch (IOException e) {
        }
    }

    /**
     * M&eacute;todo que faz a leitura do arquivo e retorna uma lista com os dados dos objetos
     *
     * @return List
     */
    public List<OrdemCompra> ler() {
        List<OrdemCompra> ordensCompra = new ArrayList<>();
        try {
            OrdemCompra ordemCompra = null;
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.filename));
            do {
                ordemCompra = (OrdemCompra) file.readObject();
                if (ordemCompra != null) {
                    ordensCompra.add(ordemCompra);
                }
            } while (ordemCompra != null);
            file.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return ordensCompra;
    }

    /**
     * M&eacute;todo que cria uma ordem de compra, adiciona na lista de ordens de compra e salva em arquivo
     *
     * @param ordemCompra valor referente a um objeto OrdemCompra
     * @return OrdemCompra
     */
    @Override
    public OrdemCompra criar(OrdemCompra ordemCompra) {
        ordemCompra.setOrdemCompraId(this.novoId);
        this.novoId++;
        this.ordensCompra.add(ordemCompra);
        salvar(this.ordensCompra);
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
     * M&eacute;todo que atualiza uma ordem de compra e salva em arquivo
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
        salvar(this.ordensCompra);
    }

    /**
     * M&eacute;todo que deleta uma ordem de compra, remove da lista de ordens de compra e salva em arquivo
     *
     * @param ordemCompra valor referente a um objeto OrdemCompra
     */
    @Override
    public void deletar(OrdemCompra ordemCompra) {
        for(int i = 0; i < this.ordensCompra.size(); i++){
            if (this.ordensCompra.get(i).equals(ordemCompra))
                this.ordensCompra.remove(i);
        }
        salvar(this.ordensCompra);
    }

    /**
     * M&eacute;todo que retorna a lista de ordens de compra
     *
     * @return List
     */
    @Override
    public List<OrdemCompra> getOrdensCompra() {
        return this.ordensCompra;
    }

    /**
     * M&eacute;todo que reseta a lista de ordens de compra e salva em arquivo
     */
    @Override
    public void resetar(){
        this.ordensCompra = new ArrayList<>();
        this.novoId = 0;
        salvar(this.ordensCompra);
    }

}