package com.example.sistemaparagerenciamento.dao.cliente;
import com.example.sistemaparagerenciamento.model.Cliente;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class ClienteFileImpl implements ClienteDAO{
    private String filename = "cliente.bin";
    private int novoId;
    private List<Cliente> clientes;


    public ClienteFileImpl(String filename) {
        this.filename = filename;
        this.novoId = 0;
        this.clientes = new ArrayList<>();
        this.clientes = ler();
    }

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
     * M&eacute;todo que cria um cliente e adiciona na lista de clientes
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
     * M&eacute;todo que atualiza um cliente
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
     * M&eacute;todo que deleta um cliente e remove da lista de clientes
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
     * M&eacute;todo que reseta a lista de clientes
     */
    @Override
    public void resetar(){
        this.clientes = new ArrayList<>();
        this.novoId = 0;
        salvar(this.clientes);
    }
}