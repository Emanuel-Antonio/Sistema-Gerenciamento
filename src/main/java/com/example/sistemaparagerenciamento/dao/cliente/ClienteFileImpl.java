package com.example.sistemaparagerenciamento.dao.cliente;
import com.example.sistemaparagerenciamento.model.Cliente;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

/**
 * Implementa&ccedil;&atilde;o de ClienteDAO com arquivo
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class ClienteFileImpl implements ClienteDAO{
    private String filename;
    private int novoId;
    private List<Cliente> clientes;

    /**
     * Construtor de ClienteFileImpl, necess&aacute;rio para inicializar os atributos novoId e clientes e atribuir o nome do arquivo.
     */
    public ClienteFileImpl(String filename) {
        this.filename = filename;
        this.clientes = new ArrayList<>();
        this.clientes = ler();
        if(this.clientes.isEmpty()){
            this.novoId = 0;
        }
        else{
            this.novoId = this.clientes.get(this.clientes.size() - 1).getClienteId() + 1;
        }
    }

    /**
     * M&eacute;todo que salva a lista com os dados dos objetos em arquivo
     *
     * @param clientes valor referente a lista de clientes
     */
    public void salvar(List<Cliente> clientes) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.filename));
            for (Cliente cliente : clientes) {
                file.writeObject(cliente);
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
    public List<Cliente> ler() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            Cliente cliente = null;
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.filename));
            do {
                cliente = (Cliente) file.readObject();
                if (cliente != null) {
                    clientes.add(cliente);
                }
            } while (cliente != null);
            file.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return clientes;
    }

    /**
     * M&eacute;todo que cria um cliente, adiciona na lista de clientes e salva em arquivo
     *
     * @param cliente valor referente a um objeto Cliente
     * @return Cliente
     */
    @Override
    public Cliente criar(Cliente cliente) {
        cliente.setClienteId(this.novoId);
        this.novoId++;
        this.clientes.add(cliente);
        salvar(this.clientes);
        return cliente;
    }


    /**
     * M&eacute;todo que busca um cliente pelo seu identificador
     *
     * @param id valor referente ao identificador do cliente
     * @return Cliente
     */
    @Override
    public Cliente buscarPorId(int id) {
        for(Cliente cliente : this.clientes){
            if(cliente.getClienteId() == id){
                return cliente;
            }
        }
        return null;
    }

    /**
     * M&eacute;todo que atualiza um cliente e salva em arquivo
     *
     * @param cliente valor referente a um objeto Cliente
     */
    @Override
    public void atualizar(Cliente cliente) {
        for(int i = 0; i < this.clientes.size(); i++){
            if(this.clientes.get(i).getClienteId() == cliente.getClienteId()){
                this.clientes.set(i,cliente);
            }
        }
        salvar(this.clientes);
    }

    /**
     * M&eacute;todo que deleta um cliente, remove da lista de clientes e salva em arquivo
     *
     * @param id valor referente ao identificador do objeto Cliente
     */
    @Override
    public void deletar(int id) {
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).getClienteId() == id) {
                this.clientes.remove(i);
            }
        }
        salvar(this.clientes);
    }

    /**
     * M&eacute;todo que retorna a lista de clientes
     *
     * @return List
     */
    @Override
    public List<Cliente> getClientes() {
        return this.clientes;
    }

    /**
     * M&eacute;todo que reseta a lista de clientes e salva em arquivo
     */
    @Override
    public void resetar(){
        this.clientes = new ArrayList<>();
        this.novoId = 0;
        salvar(this.clientes);
    }
}