package com.example.sistemaparagerenciamento.dao.ordemcompra;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.OrdemCompra;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrdemCompraListImplTest {

    private OrdemCompra ordemCompra;

    @BeforeEach
    void setUp() {

        this.ordemCompra = new OrdemCompra(2, 10.0, "RAM");
        DAO.getOrdemCompra().criar(ordemCompra);

    }

    @AfterEach
    void tearDown() {

        DAO.getOrdemCompra().resetar();

    }

    @Test
    void criar() {

        assertEquals(2, DAO.getOrdemCompra().buscarPorId(this.ordemCompra.getOrdemCompraId()).getQnt(), "1° Teste de criar ordem de compra!");
        assertEquals(10.0, DAO.getOrdemCompra().buscarPorId(this.ordemCompra.getOrdemCompraId()).getValorUnitario(), "2° Teste de criar ordem de compra!");
        assertEquals("RAM", DAO.getOrdemCompra().buscarPorId(this.ordemCompra.getOrdemCompraId()).getNome(), "3° Teste de criar ordem de compra!");

    }

    @Test
    void buscarPorId() {

        assertEquals(ordemCompra, DAO.getOrdemCompra().buscarPorId(0), "1° Teste de buscar por id ordem de compra!");

    }

    @Test
    void atualizar() {

        OrdemCompra ordemCompra1 = new OrdemCompra(2, 15.0, "RAM");
        ordemCompra1.setOrdemCompraId(0);
        DAO.getOrdemCompra().atualizar(ordemCompra1);

        assertEquals(2, DAO.getOrdemCompra().buscarPorId(this.ordemCompra.getOrdemCompraId()).getQnt(), "1° Teste de criar ordem de compra!");
        assertEquals(15.0, DAO.getOrdemCompra().buscarPorId(this.ordemCompra.getOrdemCompraId()).getValorUnitario(), "2° Teste de criar ordem de compra!");
        assertEquals("RAM", DAO.getOrdemCompra().buscarPorId(this.ordemCompra.getOrdemCompraId()).getNome(), "3° Teste de criar ordem de compra!");

    }

    @Test
    void deletar() {

        OrdemCompra ordemCompra1 = new OrdemCompra(2, 15.0, "RAM");
        DAO.getOrdemCompra().criar(ordemCompra1);

        DAO.getOrdemCompra().deletar(this.ordemCompra);

        assertNull(DAO.getOrdemCompra().buscarPorId(this.ordemCompra.getOrdemCompraId()), "1° Teste de deletar ordem de compra!");
        assertNotNull(DAO.getOrdemCompra().buscarPorId(ordemCompra1.getOrdemCompraId()), "2° Teste de deletar ordem de compra!");

    }

    @Test
    void resetar() {

        OrdemCompra ordemCompra1 = new OrdemCompra(2, 15.0, "RAM");
        DAO.getOrdemCompra().criar(ordemCompra1);

        DAO.getOrdemCompra().resetar();

        assertNull(DAO.getOrdemCompra().buscarPorId(this.ordemCompra.getOrdemCompraId()), "1° Teste de deletar ordem de compra!");
        assertNull(DAO.getOrdemCompra().buscarPorId(ordemCompra1.getOrdemCompraId()), "2° Teste de deletar ordem de compra!");

    }

}