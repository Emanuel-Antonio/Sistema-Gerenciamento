package com.example.sistemaparagerenciamento.dao.recepcao;

import com.example.sistemaparagerenciamento.model.Cliente;
import com.example.sistemaparagerenciamento.model.Tecnico;

import java.util.ArrayList;
import java.util.List;

public class RecepcaoListImpl {


    public List<Cliente> registroClientes;

    public int novoIdCliente;

    public int novoIdTecnico;

    public List<Tecnico> registroTecnicos;

    public RecepcaoFileImpl() {
        this.registroClientes = new ArrayList<Cliente>();
        this.registroTecnicos = new ArrayList<Tecnico>();
        this.novoIdCliente = 0;
        this.novoIdTecnico = 0;
    }

    public Cliente registrarCliente(Cliente cliente){
        cliente.setClienteId(this.novoIdCliente);
        this.novoIdCliente++;

        this.registroClientes.add(cliente);

        return cliente;
    }

    public Cliente buscarClienteId(int id) {
        for (Cliente cliente : registroClientes)
            if(cliente.getClienteId() == id)
                return cliente;
        return null;
    }

    public Tecnico registrarTecnico(Tecnico tecnico){
        tecnico.setTecnicoId(this.novoIdTecnico);
        this.novoIdTecnico++;

        this.registroTecnicos.add(tecnico);
        return tecnico;
    }

    public Tecnico buscarTecnicoId(int id) {
        for (Tecnico tecnico : registroTecnicos)
            if(tecnico.getTecnicoId() == id)
                return tecnico;
        return null;
    }
}
