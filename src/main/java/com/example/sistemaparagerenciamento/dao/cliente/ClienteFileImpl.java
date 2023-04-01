package com.example.sistemaparagerenciamento.dao.cliente;

import com.example.sistemaparagerenciamento.dao.CRUD;
import com.example.sistemaparagerenciamento.model.Cliente;

import java.util.ArrayList;
import java.util.List;
public class ClienteFileImpl implements ClienteDAO {

    private int novoId;

    private List<Cliente> clientes;

    public ClienteFileImpl() {
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
        for (Cliente cliente : this.clientes)
            if(cliente.getClienteId() == id)
                return cliente;
        return null;
    }

    @Override
    public void atualizar(Cliente obj) {

    }

    @Override
    public void deletar(int id) {

    }

}
