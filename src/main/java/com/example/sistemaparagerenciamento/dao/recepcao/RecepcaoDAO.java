package com.example.sistemaparagerenciamento.dao.recepcao;

import com.example.sistemaparagerenciamento.dao.CRUD;
import com.example.sistemaparagerenciamento.model.Cliente;
import com.example.sistemaparagerenciamento.model.Recepcao;
import com.example.sistemaparagerenciamento.model.Tecnico;

public interface RecepcaoDAO extends CRUD<Recepcao> {
    public Cliente registrarCliente(Cliente cliente);

    public Tecnico registrarTecnico(Tecnico tecnico);

}
