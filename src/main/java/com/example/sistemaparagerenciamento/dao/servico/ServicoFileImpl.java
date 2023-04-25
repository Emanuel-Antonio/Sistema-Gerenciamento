package com.example.sistemaparagerenciamento.dao.servico;

import com.example.sistemaparagerenciamento.model.Servico;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

/**
 * Implementa&ccedil;&atilde;o de ServicoDAO com arquivo
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class ServicoFileImpl implements ServicoDAO{
    private String filename;

    public int novoId;

    public List<Servico> servicos;

    /**
     * Construtor de ServicoFileImpl, necess&aacute;rio para inicializar os atributos novoId e servicos e atribuir o nome do arquivo.
     */
    public ServicoFileImpl(String filename) {
        this.filename = filename;
        this.servicos = new ArrayList<>();
        this.servicos = ler();
        if(this.servicos.isEmpty()){
            this.novoId = 0;
        }
        else{
            this.novoId = this.servicos.get(this.servicos.size() - 1).getServicoId() + 1;
        }
    }

    /**
     * M&eacute;todo que salva a lista com os dados dos objetos em arquivo
     *
     * @param servicos valor referente a lista de servi&ccedil;os
     */
    public void salvar(List<Servico> servicos) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.filename));
            file.writeObject(servicos);
            file.close();
        } catch (Exception e) {
        }
    }

    /**
     * M&eacute;todo que faz a leitura do arquivo e retorna uma lista com os dados dos objetos
     *
     * @return List
     */
    public List<Servico> ler() {
        List<Servico> servicos = new ArrayList<>();
        try {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.filename));
            servicos = (List<Servico>) file.readObject();
            file.close();
        } catch (Exception e) {
        }
        return servicos;
    }

    /**
     * M&eacute;todo que cria um servi&ccedil;o, adiciona na lista de servi&ccedil;os e salva em arquivo
     *
     * @param servico valor referente a um objeto Servico
     * @return Servico
     */
    @Override
    public Servico criar(Servico servico) {
        servico.setServicoId(this.novoId);
        this.novoId++;
        this.servicos.add(servico);
        salvar(this.servicos);
        return servico;
    }

    /**
     * M&eacute;todo que busca um servi&ccedil;o pelo seu identificador
     *
     * @param id valor referente ao identificador do servi&ccedil;o
     * @return Servico
     */
    @Override
    public Servico buscarPorId(int id) {
        for (Servico servico : this.servicos) {
            if (servico.getServicoId() == id)
                return servico;
        }
        return null;
    }

    /**
     * M&eacute;todo que atualiza um servi&ccedil;o e salva em arquivo
     *
     * @param servico valor referente a um objeto Servico
     */
    @Override
    public void atualizar(Servico servico) {
        for(int i = 0; i < this.servicos.size(); i++){
            if (this.servicos.get(i).equals(servico))
                this.servicos.set(i, servico);
        }
        salvar(this.servicos);
    }

    /**
     * M&eacute;todo que deleta um servi&ccedil;o, remove da lista de servi&ccedil;os e salva em arquivo
     *
     * @param servico valor referente ao objeto Servico
     */
    @Override
    public void deletar(Servico servico) {
        for(int i = 0; i < this.servicos.size(); i++){
            if (this.servicos.get(i).equals(servico))
                this.servicos.remove(i);
        }
        salvar(this.servicos);
    }

    /**
     * M&eacute;todo que retorna a lista de servi&ccedil;os
     *
     * @return List
     */
    public List<Servico> getServicos() {
        return this.servicos;
    }

    /**
     * M&eacute;todo que reseta a lista de servi&ccedil;os e salva em arquivo
     */
    @Override
    public void resetar() {
        this.servicos = new ArrayList<>();
        salvar(this.servicos);
    }

}

