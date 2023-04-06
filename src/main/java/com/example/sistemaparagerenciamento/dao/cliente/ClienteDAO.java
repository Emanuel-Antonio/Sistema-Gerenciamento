package com.example.sistemaparagerenciamento.dao.cliente;

import com.example.sistemaparagerenciamento.dao.CRUD;
import com.example.sistemaparagerenciamento.model.Cliente;

public interface ClienteDAO extends CRUD<Cliente> {
    public Cliente buscarPorId(int id);
}
