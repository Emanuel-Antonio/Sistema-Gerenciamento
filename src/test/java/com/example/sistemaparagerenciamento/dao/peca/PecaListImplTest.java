package com.example.sistemaparagerenciamento.dao.peca;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Peca;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PecaListImplTest {

    @AfterEach
    void tearDown() {
        DAO.getPeca().resetar();
    }

    @Test
    void criar() {
        Peca peca = new Peca("RAM");
        peca.setQnt(10);
        peca.setValor(20.0);

        DAO.getPeca().criar(peca);

        assertEquals(10, DAO.getPeca().buscarPorNome(peca.getNome()).getQnt(), "1° Teste de criar Peca!");
        assertEquals(20.0, DAO.getPeca().buscarPorNome(peca.getNome()).getValor(), "2° Teste de criar Peca!");
        assertEquals("RAM", DAO.getPeca().buscarPorNome(peca.getNome()).getNome(), "3° Teste de criar Peca!");
    }

    @Test
    void atualizar() {
        Peca peca = new Peca("RAM");
        peca.setValor(20.0);
        peca.setQnt(10);
        DAO.getPeca().criar(peca);

        Peca peca1 = new Peca("RAM");
        peca1.setValor(10.0);
        peca1.setQnt(20);
        DAO.getPeca().atualizar(peca1);

        assertEquals(10.0, DAO.getPeca().buscarPorNome(peca.getNome()).getValor(), "1° Teste de atualizar peca!");
        assertEquals("RAM", DAO.getPeca().buscarPorNome(peca.getNome()).getNome(), "2° Teste de atualizar peca!");
        assertEquals(20, DAO.getPeca().buscarPorNome(peca.getNome()).getQnt(), "3° Teste de atualizar peca!");
    }

    @Test
    void deletar() {
        Peca peca = new Peca("RAM");
        peca.setQnt(20);
        peca.setValor(10.0);

        DAO.getPeca().criar(peca);

        Peca peca1 = new Peca("SSD");
        peca1.setQnt(10);
        peca1.setValor(20.0);

        DAO.getPeca().criar(peca1);

        DAO.getPeca().deletar(peca);

        assertNotNull(DAO.getPeca().buscarPorNome(peca1.getNome()), " 1° Teste de deletar peca!");
        assertNull(DAO.getPeca().buscarPorNome(peca.getNome()), " 2° Teste de deletar peca!");
    }

    @Test
    void buscarPorNome() {
        Peca peca = new Peca("RAM");
        peca.setValor(20.0);
        peca.setQnt(10);

        DAO.getPeca().criar(peca);

        Peca peca1 = new Peca("SSD");
        peca1.setQnt(20);
        peca1.setValor(10.0);

        DAO.getPeca().criar(peca1);

        assertEquals(peca, DAO.getPeca().buscarPorNome("RAM"), "1° Teste de buscar por id peca!");

        assertEquals(peca1, DAO.getPeca().buscarPorNome("SSD"), "2° Teste de buscar por id peca!");
    }

    @Test
    void resetar() {
        Peca peca = new Peca("RAM");
        peca.setValor(20.0);
        peca.setQnt(10);

        DAO.getPeca().criar(peca);

        Peca peca1 = new Peca("SSD");
        peca.setValor(10.0);
        peca.setQnt(20);

        DAO.getPeca().criar(peca1);

        DAO.getPeca().resetar();

        assertNull(DAO.getPeca().buscarPorNome(peca.getNome()), " 1° Teste de resetar peca!");
        assertNull(DAO.getPeca().buscarPorNome(peca1.getNome()), " 2° Teste de resetar peca!");

    }
}