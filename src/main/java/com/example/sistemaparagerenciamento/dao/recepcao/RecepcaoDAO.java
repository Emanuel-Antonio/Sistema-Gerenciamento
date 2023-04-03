package com.example.sistemaparagerenciamento.dao.recepcao;

import com.example.sistemaparagerenciamento.model.Cliente;
import com.example.sistemaparagerenciamento.model.Tecnico;

public interface RecepcaoDAO{
    public Cliente registrarCliente(Cliente cliente);

    public Tecnico registrarTecnico(Tecnico tecnico);

}
