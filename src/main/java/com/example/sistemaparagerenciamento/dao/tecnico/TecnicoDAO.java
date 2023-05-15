package com.example.sistemaparagerenciamento.dao.tecnico;

import com.example.sistemaparagerenciamento.dao.CRUD;
import com.example.sistemaparagerenciamento.model.Tecnico;
import java.util.List;

/**
 * Interface TecnicoDAO que extende o CRUD e define outros m&eacute;todos que devem implementados
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public interface TecnicoDAO extends CRUD<Tecnico> {

    /**
     * M&eacute;todo que retorna uma lista de t&eacute;cnicos
     *
     * @return List
     */

    void setTecnicoLogado(Tecnico tecnicoLogado);

    Tecnico getTecnicoLogado();

     List<Tecnico> getTecnicos();

    /**
     * M&eacute;todo que reseta a lista de t&eacute;cnicos
     */
    void resetar();

}