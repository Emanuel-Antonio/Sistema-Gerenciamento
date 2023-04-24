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

public class ServicoFileImpl implements ServicoDAO{
    private String filename = "servico.bin";

    public int novoId;

    public List<Servico> servicos;

    public ServicoFileImpl(String filename) {
        this.filename = filename;
        this.servicos = new ArrayList<>();
        this.novoId = 0;
        this.servicos = ler();
    }

    public void salvar(List<Servico> servicos) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.filename));
            file.writeObject(servicos);
            file.close();
        } catch (Exception e) {
        }
    }
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
     * M&eacute;todo que cria um servi&ccedil;o e adiciona na lista de servi&ccedil;os
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
     * M&eacute;todo que atualiza um servi&ccedil;o
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
     * M&eacute;todo que reseta a lista de servi&ccedil;os
     */
    @Override
    public void resetar() {
        this.servicos = new ArrayList<>();
        salvar(this.servicos);
    }

}

