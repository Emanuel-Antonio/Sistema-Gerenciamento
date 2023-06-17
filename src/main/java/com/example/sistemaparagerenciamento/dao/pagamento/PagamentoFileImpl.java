package com.example.sistemaparagerenciamento.dao.pagamento;

import com.example.sistemaparagerenciamento.model.Pagamento;
import com.example.sistemaparagerenciamento.model.Peca;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

/**
 * Implementa&ccedil;&atilde;o de PagamentoDAO com arquivo
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class PagamentoFileImpl implements PagamentoDAO{
    private String filename;

    public List<Pagamento> pagamentos;

    public int novoId;

    /**
     * Construtor de PagamentoFileImpl, necess&aacute;rio para inicializar os atributos novoId e pagamentos e atribuir o nome do arquivo.
     */
    public PagamentoFileImpl(String filename) {
        this.filename = filename;
        this.pagamentos = new ArrayList<>();
        this.pagamentos = ler();
        if(this.pagamentos.isEmpty()){
            this.novoId = 0;
        }
        else{
            this.novoId = this.pagamentos.get(this.pagamentos.size() - 1).getPagamentoId() + 1;
        }
    }

    /**
     * M&eacute;todo que salva a lista com os dados dos objetos em arquivo
     *
     * @param pagamentos valor referente a lista de pagamentos
     */
    public void salvar(List<Pagamento> pagamentos) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.filename));
            for (Pagamento pagamento : pagamentos) {
                file.writeObject(pagamento);
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
    public List<Pagamento> ler() {
        List<Pagamento> pagamentos = new ArrayList<>();
        try {
            Pagamento pagamento = null;
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.filename));
            do {
                pagamento = (Pagamento) file.readObject();
                if (pagamento != null) {
                    pagamentos.add(pagamento);
                }
            } while (pagamento != null);
            file.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return pagamentos;
    }

    /**
     * M&eacute;todo que cria um pagamento, adiciona na lista de pagamentos e salva em arquivo
     *
     * @param pagamento valor referente a um objeto Pagamento
     * @return Pagamento
     */
    @Override
    public Pagamento criar(Pagamento pagamento) {
        pagamento.setPagamentoId(this.novoId);
        this.novoId++;
        this.pagamentos.add(pagamento);
        salvar(this.pagamentos);
        return pagamento;
    }

    /**
     * M&eacute;todo que atualiza um pagamento e salva em arquivo
     *
     * @param pagamento valor referente a um objeto Pagamento
     */
    @Override
    public Pagamento atualizar(Pagamento pagamento) {
        for (int i = 0; i < this.pagamentos.size(); i++) {
            if (this.pagamentos.get(i).equals(pagamento)) {
                this.pagamentos.set(i, pagamento);
                salvar(this.pagamentos);
                return pagamento;
            }
        }
        return null;
    }

    /**
     * M&eacute;todo que deleta um pagamento, remove da lista de pagamentos e salva em arquivo
     *
     * @param pagamento valor referente a um objeto Pagamento
     */
    @Override
    public void deletar(Pagamento pagamento) {
        for (int i = 0; i < this.pagamentos.size(); i++) {
            if (this.pagamentos.get(i).equals(pagamento))
                this.pagamentos.remove(i);
        }
        salvar(this.pagamentos);
    }

    /**
     * M&eacute;todo que busca um pagamento pelo seu identificador
     *
     * @param id valor referente ao identificador do pagamento
     * @return Pagamento
     */
    @Override
    public Pagamento buscarPorId(int id) {
        for(Pagamento pagamento : this.pagamentos){
            if(pagamento.getPagamentoId() == id){
                return pagamento;
            }
        }
        return null;
    }

    /**
     * M&eacute;todo que reseta a lista de pagamentos e salva em arquivo
     */
    @Override
    public void resetar() {
        this.pagamentos = new ArrayList<>();
        this.novoId = 0;
        salvar(this.pagamentos);
    }

    public List<Pagamento> getPagamentos() {
        return this.pagamentos;
    }
}
