package com.example.sistemaparagerenciamento.dao.tecnico;
import com.example.sistemaparagerenciamento.model.Tecnico;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

/**
 * Implementa&ccedil;&atilde;o de TecnicoDAO com arquivo
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class TecnicoFileImpl implements TecnicoDAO{
    private String filename;
    private List<Tecnico> tecnicos;
    private int novoId;

    /**
     * Construtor de TecnicoFileImpl, necess&aacute;rio para inicializar os atributos novoId e tecnicos e atribuir o nome do arquivo.
     */
    public TecnicoFileImpl(String filename) {
        this.filename = filename;
        this.novoId = 0;
        this.tecnicos = new ArrayList<>();
        this.tecnicos = ler();
    }

    /**
     * M&eacute;todo que salva a lista com os dados dos objetos em arquivo
     *
     * @param tecnicos valor referente a lista de t&eacute;cnicos
     */
    public void salvar(List<Tecnico> tecnicos) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.filename));
            for (Tecnico tecnico : tecnicos) {
                file.writeObject(tecnico);
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
    public List<Tecnico> ler() {
        List<Tecnico> tecnicos = new ArrayList<>();
        try {
            Tecnico tecnico = null;
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.filename));
            do {
                tecnico = (Tecnico) file.readObject();
                if (tecnico != null) {
                    tecnicos.add(tecnico);
                }
            } while (tecnico != null);
            file.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return tecnicos;
    }

    /**
     * M&eacute;todo que cria um t&eacute;cnico, adiciona na lista de t&eacute;cnicos e salva em arquivo
     *
     * @param tecnico valor referente a um objeto Tecnico
     * @return Tecnico
     */
    @Override
    public Tecnico criar(Tecnico tecnico) {
        tecnico.setTecnicoId(this.novoId);
        this.novoId++;
        this.tecnicos.add(tecnico);
        salvar(this.tecnicos);
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
     * M&eacute;todo que atualiza um t&eacute;cnico e salva em arquivo
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
        salvar(this.tecnicos);
    }

    /**
     * M&eacute;todo que deleta um t&eacute;cnico, remove da lista de t&eacute;cnicos e salva em arquivo
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
        salvar(this.tecnicos);
    }

    /**
     * M&eacute;todo que retorna a lista de t&eacute;cnicos
     *
     * @return List
     */
    public List<Tecnico> getTecnicos(){
        return this.tecnicos;
    }

    /**
     * M&eacute;todo que reseta a lista de t&eacute;cnicos e salva em arquivo
     */
    @Override
    public void resetar() {
        this.tecnicos = new ArrayList<>();
        this.novoId = 0;
        salvar(this.tecnicos);
    }

}
