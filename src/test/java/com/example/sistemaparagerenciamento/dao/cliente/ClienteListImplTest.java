package com.example.sistemaparagerenciamento.dao.cliente;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Cliente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class ClienteListImplTest {

    private Cliente cliente;

    @BeforeEach
    void beforeAll() {
        this.cliente = new Cliente("Paulo", "Dom Basílio", "991482050");
        DAO.getCliente().criar(this.cliente);
    }
    @AfterEach
    void tearDown() {
        DAO.getCliente().resetar();
    }

    @Test
    void criar() {
        assertEquals("Paulo", DAO.getCliente().buscarPorId(this.cliente.getClienteId()).getNome(), "1° Teste de criar cliente!");
        assertEquals("Dom Basílio", DAO.getCliente().buscarPorId(this.cliente.getClienteId()).getEndereco(), "2° Teste de criar cliente!");
        assertEquals("991482050", DAO.getCliente().buscarPorId(this.cliente.getClienteId()).getTelefone(), "3° Teste de criar cliente!");
    }

    @Test
    void buscarPorId() {
        assertEquals(cliente, DAO.getCliente().buscarPorId(0), "1° Teste de buscar por id cliente!");
    }

    @Test
    void atualizar() {
        Cliente cliente1 = new Cliente("Paulo", "Feira de Santana", "991501300");
        cliente1.setClienteId(0);
        DAO.getCliente().atualizar(cliente1);

        assertEquals("Paulo", DAO.getCliente().buscarPorId(this.cliente.getClienteId()).getNome(), "1° Teste de atualizar cliente!");
        assertEquals("Feira de Santana", DAO.getCliente().buscarPorId(this.cliente.getClienteId()).getEndereco(), "2° Teste de atualizar cliente!");
        assertEquals("991501300", DAO.getCliente().buscarPorId(this.cliente.getClienteId()).getTelefone(), "3° Teste de atualizar cliente!");
    }

    @Test
    void deletar() {
        Cliente cliente1 = new Cliente("Paulo", "Feira de Santana", "991501300");
        DAO.getCliente().criar(cliente1);

        DAO.getCliente().deletar(this.cliente.getClienteId());

        assertNull(DAO.getCliente().buscarPorId(this.cliente.getClienteId()), "1° Teste de deletar cliente!");
        assertNotNull(DAO.getCliente().buscarPorId(cliente1.getClienteId()), "2° Teste de deletar cliente!");

    }

    @Test
    void resetar() {
        Cliente cliente1 = new Cliente("Paulo", "Feira de Santana", "991501300");
        DAO.getCliente().criar(cliente1);

        DAO.getCliente().resetar();

        assertNull(DAO.getCliente().buscarPorId(this.cliente.getClienteId()), "1° Teste de resetar cliente!");
        assertNull(DAO.getCliente().buscarPorId(cliente1.getClienteId()), "2° Teste de resetar cliente!");
    }


}