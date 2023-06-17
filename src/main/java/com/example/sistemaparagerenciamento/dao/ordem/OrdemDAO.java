package com.example.sistemaparagerenciamento.dao.ordem;

import com.example.sistemaparagerenciamento.dao.CRUD;
import com.example.sistemaparagerenciamento.model.Ordem;
import java.util.List;

/**
 * Interface OrdemDAO que extende o CRUD e define outros m&eacute;todos que devem implementados
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public interface OrdemDAO extends CRUD<Ordem> {

    /**
     * M&eacute;todo que retorna a lista de ordens
     *
     * @return List
     */
     List<Ordem> getOrdens();

    /**
     * M&eacute;todo que reseta a lista de ordens
     */
     void resetar();

    Ordem buscarPorId(int id);

    void atualizar(Ordem ordem);

    }