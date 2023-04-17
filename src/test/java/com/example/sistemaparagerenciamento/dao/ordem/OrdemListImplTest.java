package com.example.sistemaparagerenciamento.dao.ordem;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrdemListImplTest {

    private Cliente cliente;
    private Tecnico tecnico;
    private Ordem ordem;

    @BeforeEach
    void setUp() {

        this.cliente = new Cliente("Paulo", "Dom Basílio", "991482050");
        DAO.getCliente().criar(this.cliente);
        this.tecnico = new Tecnico("Digo@gmail.com", "Rodrigo", "1234");
        DAO.getTecnico().criar(this.tecnico);
        this.ordem = new Ordem(this.cliente.getClienteId());
        DAO.getOrdem().criar(this.ordem);

    }

    @AfterEach
    void tearDown() {

        DAO.getCliente().resetar();
        DAO.getTecnico().resetar();
        DAO.getOrdem().resetar();

    }

    @Test
    void criar() {

        DAO.getOrdem().buscarPorId(ordem.getOrdemId()).setTecnicoId(this.tecnico.getTecnicoId());

        assertEquals(ordem.getOrdemId(), DAO.getOrdem().buscarPorId(ordem.getOrdemId()).getOrdemId(), "1° Teste de criar ordem!");
        assertEquals(this.tecnico.getTecnicoId(), DAO.getOrdem().buscarPorId(ordem.getOrdemId()).getTecnicoId(), "2° Teste de criar ordem!");
        assertEquals(this.cliente.getClienteId(), DAO.getOrdem().buscarPorId(ordem.getOrdemId()).getClienteId(), "3° Teste de criar ordem!");
        assertEquals(ordem.getStatus(), DAO.getOrdem().buscarPorId(ordem.getOrdemId()).getStatus(), "4° Teste de criar ordem!");

    }

    @Test
    void buscarPorId() {

        assertEquals(ordem, DAO.getOrdem().buscarPorId(ordem.getOrdemId()), "1° Teste de buscar por id ordem!");

    }

    @Test
    void atualizar() {

        Ordem ordem1 = new Ordem( this.cliente.getClienteId());
        ordem1.setStatus(StatusOrdem.PAGAMENTO);
        DAO.getOrdem().atualizar(ordem1);

        assertEquals(StatusOrdem.PAGAMENTO, DAO.getOrdem().buscarPorId(this.ordem.getOrdemId()).getStatus(), "1° Teste de atualizar ordem!");

    }

    @Test
    void deletar() {

        Ordem ordem1 = new Ordem(this.cliente.getClienteId());
        ordem1.setStatus(StatusOrdem.PAGAMENTO);
        DAO.getOrdem().criar(ordem1);
        DAO.getOrdem().deletar(this.ordem.getOrdemId());

        assertEquals(StatusOrdem.PAGAMENTO, DAO.getOrdem().buscarPorId(ordem1.getOrdemId()).getStatus(), "1° Teste de deletar ordem!");
        assertNull(DAO.getOrdem().buscarPorId(this.ordem.getOrdemId()), "2° Teste de deletar ordem!");

    }

    @Test
    void resetar() {

        Ordem ordem1 = new Ordem( this.cliente.getClienteId());
        ordem1.setStatus(StatusOrdem.PAGAMENTO);
        DAO.getOrdem().criar(ordem1);
        DAO.getOrdem().resetar();

        assertNull(DAO.getOrdem().buscarPorId(this.ordem.getOrdemId()), "1° Teste de resetar ordem!");
        assertNull(DAO.getOrdem().buscarPorId(ordem1.getOrdemId()), "2° Teste de resetar ordem!");

    }

}