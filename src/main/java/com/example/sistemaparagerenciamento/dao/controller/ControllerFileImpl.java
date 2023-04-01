package com.example.sistemaparagerenciamento.dao.controller;

import com.example.sistemaparagerenciamento.model.Cliente;
import com.example.sistemaparagerenciamento.model.Controller;

import java.util.ArrayList;
import java.util.List;

public class ControllerFileImpl implements ControllerDAO{

    public List<Cliente> registroClientes;

    public ControllerFileImpl() {
        this.registroClientes = new ArrayList<Cliente>();
    }

    @Override
    public Controller criar(Controller obj) {
        return null;
    }

    @Override
    public Controller buscarPorId(int id) {
        return null;
    }

    @Override
    public void atualizar(Controller obj) {

    }

    @Override
    public void deletar(int id) {

    }

    public Cliente registrarCliente(Cliente cliente){
        this.registroClientes.add(cliente);

        return cliente;
    }

}
