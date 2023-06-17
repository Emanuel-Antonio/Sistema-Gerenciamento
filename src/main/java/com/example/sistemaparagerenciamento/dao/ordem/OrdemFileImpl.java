package com.example.sistemaparagerenciamento.dao.ordem;
import com.example.sistemaparagerenciamento.model.Ordem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

/**
 * Implementa&ccedil;&atilde;o de OrdemDAO com arquivo
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class OrdemFileImpl implements OrdemDAO{
    private String filename;
    private int novoId;
    private List<Ordem> ordens;

    /**
     * Construtor de OrdemFileImpl, necess&aacute;rio para inicializar os atributos novoId e ordens e atribuir o nome do arquivo.
     */
    public OrdemFileImpl(String filename) {
        this.filename = filename;
        this.ordens = new ArrayList<>();
        this.ordens = ler();
        if(this.ordens.isEmpty()){
            this.novoId = 0;
        }
        else{
            this.novoId = this.ordens.get(this.ordens.size() - 1).getOrdemId() + 1;
        }
    }

    /**
     * M&eacute;todo que salva a lista com os dados dos objetos em arquivo
     *
     * @param ordens valor referente a lista de ordens
     */
    public void salvar(List<Ordem> ordens) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.filename));
            for (Ordem ordem : ordens) {
                file.writeObject(ordem);
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
    public List<Ordem> ler() {
        List<Ordem> ordens = new ArrayList<>();
        try {
            Ordem ordem = null;
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.filename));
            do {
                ordem = (Ordem) file.readObject();
                if (ordem != null) {
                    ordens.add(ordem);
                }
            } while (ordem != null);
            file.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return ordens;
    }

    /**
     * M&eacute;todo que cria um ordem, adiciona na lista de ordens e salva em arquivo
     *
     * @param ordem valor referente a um objeto Ordem
     * @return Ordem
     */
    @Override
    public Ordem criar(Ordem ordem) {
        ordem.setOrdemId(this.novoId);
        this.novoId++;
        this.ordens.add(ordem);
        salvar(this.ordens);
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
     * M&eacute;todo que atualiza um ordem e salva em arquivo
     *
     * @param ordem valor referente a um objeto Ordem
     */
    @Override
    public void atualizar(Ordem ordem) {
        for (int i = 0; i < this.ordens.size(); i++) {
            if (this.ordens.get(i).getOrdemId() == ordem.getOrdemId()) {
                this.ordens.set(i, ordem);
            }
        }
        salvar(this.ordens);
    }

    /**
     * M&eacute;todo que deleta uma ordem, remove da lista de ordens e salva em arquivo
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
        salvar(this.ordens);
    }

    /**
     * M&eacute;todo que retorna a lista de ordens
     *
     * @return List
     */
    @Override
    public List<Ordem> getOrdens() {
        return this.ordens;
    }

    /**
     * M&eacute;todo que reseta a lista de ordens e salva em arquivo
     */
    @Override
    public void resetar(){
        this.ordens = new ArrayList<>();
        this.novoId = 0;
        salvar(this.ordens);
    }
}