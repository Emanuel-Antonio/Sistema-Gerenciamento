package com.example.sistemaparagerenciamento.dao.cliente;

import com.example.sistemaparagerenciamento.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteListImpl implements ClienteDAO{

    private int novoId;

    private List<Cliente> clientes;

    public ClienteListImpl() {
        this.novoId = 0;
        this.clientes = new ArrayList<Cliente>();
    }

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

    @Override
    public void atualizar(Cliente cliente) {
        for(int i = 0; i < this.clientes.size(); i++){
            if(this.clientes.get(i).getClienteId() == cliente.getClienteId()){
                this.clientes.set(i,cliente);
            }
        }
    }

    @Override
    public void deletar(int id) {
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).getClienteId() == id) {
                this.clientes.remove(i);
            }
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void resetar(){
        this.clientes = new ArrayList<>();
        this.novoId = 0;
    }
}