package com.example.sistemaparagerenciamento.dao.cliente;

import com.example.sistemaparagerenciamento.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClienteListImpl implements ClienteDAO{

    private Integer novoId;

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
    public Cliente buscarPorId(Integer id) {
        for(Cliente cliente : this.clientes){
            if(Objects.equals(cliente.getClienteId(), id)){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Cliente cliente) {
        for(int i = 0; i < this.clientes.size(); i++){
            if(this.clientes.get(i).equals(cliente)){
                this.clientes.set(i,cliente);
            }
        }
    }

    @Override
    public void deletar(Integer id) {
        for (int i = 0; i < this.clientes.size(); i++) {
            if (Objects.equals(this.clientes.get(i).getClienteId(), id)) {
                this.clientes.remove(i);
            }
        }
    }
}