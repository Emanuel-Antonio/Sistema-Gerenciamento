package com.example.sistemaparagerenciamento.dao.controller;

import com.example.sistemaparagerenciamento.model.Cliente;
import com.example.sistemaparagerenciamento.model.Controller;
import com.example.sistemaparagerenciamento.model.Tecnico;

public interface ControllerDAO {
    public Cliente registrarCliente(Cliente cliente);

    public Cliente buscarClienteId(int id);

    public Tecnico registrarTecnico(Tecnico tecnico);

}
