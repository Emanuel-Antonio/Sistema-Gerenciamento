package com.example.sistemaparagerenciamento.dao.cliente;

import com.example.sistemaparagerenciamento.dao.CRUD;
import com.example.sistemaparagerenciamento.model.Cliente;
import java.util.List;

/**
 * Interface ClienteDAO que extende o CRUD e define outros m&eacute;todos que devem implementados
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public interface ClienteDAO extends CRUD<Cliente> {

    /**
     * M&eacute;todo que busca um cliente pelo seu identificador
     *
     * @param id valor referente ao identificador do cliente
     * @return Cliente
     */
     Cliente buscarPorId(int id);

    /**
     * M&eacute;todo que retorna a lista de clientes
     *
     * @return List<Cliente>
     */
    List<Cliente> getClientes();

    /**
     * M&eacute;todo que reseta a lista de clientes
     */
    void resetar();

}