package com.example.sistemaparagerenciamento.dao.tecnico;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Tecnico;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TecnicoListImplTest {

    @AfterEach
    void tearDown() {

        DAO.getTecnico().resetar();

    }

    @Test
    void criar() {

        Tecnico tecnico = new Tecnico("antonystark@gmail.com", "Antony Stark", "jarvis");
        tecnico.setAdm(true);
        tecnico.setOrdem(null);

        DAO.getTecnico().criar(tecnico);

        assertEquals(tecnico, DAO.getTecnico().buscarPorId(0), " 1° Teste criar tecnico");

    }

    @Test
    void buscarPorId() {

        Tecnico tecnico = new Tecnico("antonystark@gmail.com", "Antony Stark", "jarvis");
        tecnico.setAdm(true);
        tecnico.setOrdem(null);

        DAO.getTecnico().criar(tecnico);

        Tecnico tecnico1 = new Tecnico("antonyrusso@gmail.com", "Antony Russo", "diretor");
        tecnico1.setAdm(true);
        tecnico1.setOrdem(null);

        DAO.getTecnico().criar(tecnico1);

        assertEquals(tecnico, DAO.getTecnico().buscarPorId(0), " 1° Teste BuscarPorId tecnico!");
        assertEquals(tecnico1, DAO.getTecnico().buscarPorId(1), " 2° Teste BuscarPorId tecnico!");

    }

    @Test
    void atualizar() {

        Tecnico tecnico = new Tecnico("antonystark@gmail.com", "Antony Stark", "jarvis");
        tecnico.setAdm(true);
        tecnico.setOrdem(null);

        DAO.getTecnico().criar(tecnico);

        tecnico.setAdm(false);

        DAO.getTecnico().atualizar(tecnico);

        assertEquals(false, DAO.getTecnico().buscarPorId(0).isAdm(), " 1° Teste atualizar tecnico");
        assertEquals(tecnico, DAO.getTecnico().buscarPorId(0), " 2° Teste atualizar tecnico");

    }

    @Test
    void deletar() {

        Tecnico tecnico = new Tecnico("antonystark@gmail.com", "Antony Stark", "jarvis");
        tecnico.setAdm(true);
        tecnico.setOrdem(null);

        DAO.getTecnico().criar(tecnico);

        Tecnico tecnico1 = new Tecnico("antonyrusso@gmail.com", "Antony Russo", "diretor");
        tecnico1.setAdm(true);
        tecnico1.setOrdem(null);

        DAO.getTecnico().criar(tecnico1);

        DAO.getTecnico().deletar(tecnico.getTecnicoId());

        assertNull(DAO.getTecnico().buscarPorId(0), " 1° Teste deletar tecnico!");
        assertNotNull(DAO.getTecnico().buscarPorId(1), " 2° Teste deletar tecnico!");

    }

    @Test
    void resetar() {

        Tecnico tecnico = new Tecnico("antonystark@gmail.com", "Antony Stark", "jarvis");
        tecnico.setAdm(true);
        tecnico.setOrdem(null);

        DAO.getTecnico().criar(tecnico);

        Tecnico tecnico1 = new Tecnico("antonyrusso@gmail.com", "Antony Russo", "diretor");
        tecnico1.setAdm(true);
        tecnico1.setOrdem(null);

        DAO.getTecnico().criar(tecnico1);

        DAO.getTecnico().resetar();

        assertNull(DAO.getTecnico().buscarPorId(0), " 1° Teste resetar tecnico!");
        assertNull(DAO.getTecnico().buscarPorId(1), " 2° Teste resetar Tecnico!");

    }

}