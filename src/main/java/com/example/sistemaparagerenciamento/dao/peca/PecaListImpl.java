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

    @Override
    public Peca criar(Peca peca) {
        this.pecas.add(peca);
        return peca;
    }

    @Override
    public void atualizar(Peca peca) {
        for(int i = 0; i < this.pecas.size(); i++){
            if (this.pecas.get(i).equals(peca))
                this.pecas.set(i, peca);
        }
    }

    @Override
    public void deletar(Peca peca) {
        for(int i = 0; i < this.pecas.size(); i++){
            if (this.pecas.get(i).equals(peca))
                this.pecas.remove(i);
        }
    }

    @Override
    public Peca buscarPorNome(String nome) {
        for (Peca peca : this.pecas) {
            if (peca.getNome().equals(nome))
                return peca;
        }
        return null;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    @Override
    public void resetar() {
        this.pecas = new ArrayList<>();
    }

}