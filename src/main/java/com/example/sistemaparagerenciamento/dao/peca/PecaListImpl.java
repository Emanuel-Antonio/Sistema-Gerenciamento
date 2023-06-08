package com.example.sistemaparagerenciamento.dao.peca;

import com.example.sistemaparagerenciamento.model.Peca;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementa&ccedil;&atilde;o de PecaDAO com lista
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class PecaListImpl implements PecaDAO{

    public List<Peca> pecas;

    /**
     * Construtor de PecaListImpl, necess&aacute;rio para inicializar o atributo pecas.
     */
    public PecaListImpl() {
        this.pecas = new ArrayList<>();
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
        return pecas;
    }

    /**
     * M&eacute;todo que reseta a lista de pe&ccedil;as
     */
    @Override
    public void resetar() {
        this.pecas = new ArrayList<>();
    }

    public List<String> listPecasNomes(){
        List<String> pecas = new ArrayList<>();
        for(int i = 0; i< this.pecas.size(); i++){
            pecas.add(this.pecas.get(i).getNome());
        }
        return pecas;
    }

}