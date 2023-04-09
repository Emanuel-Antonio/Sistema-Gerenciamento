package com.example.sistemaparagerenciamento.dao.pagamento;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Fatura;
import com.example.sistemaparagerenciamento.model.Ordem;
import com.example.sistemaparagerenciamento.model.Pagamento;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoListImplTest {

    private Fatura fatura;

    private Ordem ordem;

    @BeforeEach
    void setUp() {
        this.ordem = new Ordem(null, 1);
        DAO.getOrdem().criar(ordem);
        this.fatura = new Fatura(0);
        DAO.getOrdem().buscarPorId(0).setFatura(this.fatura);
    }

    @AfterEach
    void tearDown() {
        DAO.getPagamento().resetar();
        DAO.getOrdem().buscarPorId(0).setFatura(null);
        DAO.getOrdem().resetar();
    }

    @Test
    void criar() {
        Pagamento pagamento = new Pagamento("pix", 10.0, this.fatura);
        DAO.getPagamento().criar(pagamento);

        assertEquals(10.0, DAO.getPagamento().buscarPorId(pagamento.getPagamentoId()).getValor(), "1° Teste de criar pagamento!");
        assertEquals("pix", DAO.getPagamento().buscarPorId(pagamento.getPagamentoId()).getTipoPagamento(), "2° Teste de criar pagamento!");
        assertEquals(this.fatura, DAO.getPagamento().buscarPorId(pagamento.getPagamentoId()).getFatura(), "3° Teste de criar pagamento!");
    }

    @Test
    void atualizar() {
        Pagamento pagamento = new Pagamento("pix", 10.0, this.fatura);
        DAO.getPagamento().criar(pagamento);

        Pagamento pagamento1 = new Pagamento("dinheiro", 20.0, this.fatura);
        pagamento1.setPagamentoId(0);
        DAO.getPagamento().atualizar(pagamento1);

        assertEquals(20.0, DAO.getPagamento().buscarPorId(pagamento.getPagamentoId()).getValor(), "1° Teste de atualizar pagamento!");
        assertEquals("dinheiro", DAO.getPagamento().buscarPorId(pagamento.getPagamentoId()).getTipoPagamento(), "2° Teste de atualizar pagamento!");
        assertEquals(this.fatura, DAO.getPagamento().buscarPorId(pagamento.getPagamentoId()).getFatura(), "3° Teste de atualizar pagamento!");
    }

    @Test
    void deletar() {
        Pagamento pagamento = new Pagamento("pix", 10.0, this.fatura);
        DAO.getPagamento().criar(pagamento);
        Pagamento pagamento1 = new Pagamento("dinheiro", 20.0, this.fatura);
        DAO.getPagamento().criar(pagamento1);

        DAO.getPagamento().deletar(pagamento);

        assertNotNull(DAO.getPagamento().buscarPorId(pagamento1.getPagamentoId()), "1° Teste de deletar pagamento!");
        assertNull(DAO.getPagamento().buscarPorId(pagamento.getPagamentoId()), "2° Teste de deletar pagamento!");

    }

    @Test
    void buscarPorId() {
        Pagamento pagamento = new Pagamento("pix", 10.0, this.fatura);
        DAO.getPagamento().criar(pagamento);
        Pagamento pagamento1 = new Pagamento("dinheiro", 20.0, this.fatura);
        DAO.getPagamento().criar(pagamento1);

        assertEquals(pagamento, DAO.getPagamento().buscarPorId(0), "1° Teste de buscar por id pagamento!");

        assertEquals(pagamento1, DAO.getPagamento().buscarPorId(1), "2° Teste de buscar por id pagamento!");
    }

    @Test
    void resetar() {
        Pagamento pagamento = new Pagamento("pix", 10.0, this.fatura);
        DAO.getPagamento().criar(pagamento);
        Pagamento pagamento1 = new Pagamento("dinheiro", 20.0, this.fatura);
        DAO.getPagamento().criar(pagamento1);

        DAO.getPagamento().resetar();

        assertNull(DAO.getPagamento().buscarPorId(pagamento.getPagamentoId()), "1° Teste de resetar pagamento!");
        assertNull(DAO.getPagamento().buscarPorId(pagamento1.getPagamentoId()), "2° Teste de resetar pagamento!");

    }

}
