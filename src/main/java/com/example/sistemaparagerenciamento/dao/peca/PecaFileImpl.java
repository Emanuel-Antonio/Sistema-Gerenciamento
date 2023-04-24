package com.example.sistemaparagerenciamento.dao.peca;

import com.example.sistemaparagerenciamento.model.Peca;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class PecaFileImpl implements PecaDAO{
    private String filename = "peca.bin";

    public List<Peca> pecas;


    public PecaFileImpl(String filename) {
        this.filename = filename;
        this.pecas = new ArrayList<>();
        this.pecas = ler();
    }

    public void salvar(List<Peca> pecas) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.filename));
            for (Peca peca : pecas) {
                file.writeObject(peca);
            }
            file.close();
        } catch (IOException e) {
        }
    }
    public List<Peca> ler() {
        List<Peca> pecas = new ArrayList<>();
        try {
            Peca peca = null;
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.filename));
            do {
                peca = (Peca) file.readObject();
                if (peca != null) {
                    pecas.add(peca);
                }
            } while (peca != null);
            file.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return pecas;
    }

    /**
     * M&eacute;todo que cria uma pe&ccedil;a e adiciona na lista de pe&ccedil;as
     *
     * @param peca valor referente a um objeto Peca
     * @return Peca
     */
    @Override
    public Peca criar(Peca peca) {
        this.pecas.add(peca);
        salvar(this.pecas);
        return peca;
    }

    /**
     * M&eacute;todo que atualiza uma pe&ccedil;a
     *
     * @param peca valor referente a um objeto Peca
     */
    @Override
    public void atualizar(Peca peca) {
        for(int i = 0; i < this.pecas.size(); i++){
            if (this.pecas.get(i).equals(peca))
                this.pecas.set(i, peca);
        }
        salvar(this.pecas);
    }

    /**
     * M&eacute;todo que deleta uma pe&ccedil;a e remove da lista de pe&ccedil;as
     *
     * @param peca valor referente a um objeto Peca
     */
    @Override
    public void deletar(Peca peca) {
        for(int i = 0; i < this.pecas.size(); i++){
            if (this.pecas.get(i).equals(peca))
                this.pecas.remove(i);
        }
        salvar(this.pecas);
    }

    /**
     * M&eacute;todo que busca uma pe&ccedil;a pelo seu nome
     *
     * @param nome valor referente ao nome da pe&ccedil;a
     * @return Peca
     */
    @Override
    public Peca buscarPorNome(String nome) {
        for (Peca peca : this.pecas) {
            if (peca.getNome().equals(nome))
                return peca;
        }
        return null;
    }

    /**
     * M&eacute;todo que retorna a lista de pe&ccedil;as
     *
     * @return List
     */
    public List<Peca> getPecas() {
        return this.pecas;
    }

    /**
     * M&eacute;todo que reseta a lista de pe&ccedil;as
     */
    @Override
    public void resetar() {
        this.pecas = new ArrayList<>();
        salvar(this.pecas);
    }

}
