package com.example.sistemaparagerenciamento.dao.cliente;

import com.example.sistemaparagerenciamento.model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementa&ccedil;&atilde;o de ClienteDAO com lista
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class ClienteListImpl implements ClienteDAO{

    private int novoId;
    private List<Cliente> clientes;

    /**
     * Construtor de ClienteListImpl, necess&aacute;rio para inicializar os atributos novoId e clientes.
     */
    public ClienteListImpl() {
        this.novoId = 0;
        this.clientes = new ArrayList<>();
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
        return cliente;
    }

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
    }

    @Override
    public List<Cliente> getClientes() {
        return clientes;
    }

    @Override
    public void resetar(){
        this.clientes = new ArrayList<>();
        this.novoId = 0;
    }

}