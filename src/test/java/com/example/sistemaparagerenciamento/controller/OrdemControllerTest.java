package com.example.sistemaparagerenciamento.controller;


import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdemControllerTest {

    private Ordem ordem;

    private Ordem ordem1;

    @BeforeEach
    void setUp() {
        this.ordem = new Ordem(null, 0);
        DAO.getOrdem().criar(this.ordem);
        this.ordem1 = new Ordem( 0);
        DAO.getOrdem().criar(this.ordem1);
    }

    @AfterEach
    void tearDown() {
        DAO.getOrdem().resetar();
        DAO.getServico().resetar();
        DAO.getPagamento().resetar();
    }

    @Test
    void gerarFatura(){
        OrdemController ordemController = new OrdemController();
        Fatura fatura = new Fatura(this.ordem.getOrdemId());

        DAO.getOrdem().buscarPorId(this.ordem.getOrdemId()).setFatura(fatura);

        assertEquals("Id da ordem: " + "0" + "\n" + "Valor total: " + "0.0" + "\n" +
                "Valor pago: " + "0.0", ordemController.gerarFatura(this.ordem.getOrdemId()), "1° Teste de gerar Fatura!" );
    }

    @Test
    void atualizarStatusPagamento(){
        OrdemController ordemController = new OrdemController();

        Fatura fatura = new Fatura(this.ordem.getOrdemId());

        DAO.getOrdem().buscarPorId(this.ordem.getOrdemId()).setFatura(fatura);

        assertEquals(false, ordemController.atualizarStatusPagamento(this.ordem), "1° Teste de StatusPagamento!");
    }

    @Test
    void atualizarStatusFechada(){
        OrdemController ordemController = new OrdemController();

        Fatura fatura = new Fatura(this.ordem.getOrdemId());

        DAO.getOrdem().buscarPorId(this.ordem.getOrdemId()).setFatura(fatura);

        assertEquals(true, ordemController.atualizarStatusFechada(this.ordem), "1° Teste de StatusFechada!");
    }

    @Test
    void atualizarStatusCancelada(){
        OrdemController ordemController = new OrdemController();

        Fatura fatura = new Fatura(this.ordem.getOrdemId());

        DAO.getOrdem().buscarPorId(this.ordem.getOrdemId()).setFatura(fatura);

        assertEquals(true, ordemController.atualizarStatusCancelada(this.ordem), "1° Teste de StatusCancelada!");
    }

    @Test
    void cadastrarServico(){
        OrdemController ordemController = new OrdemController();

        Fatura fatura = new Fatura(this.ordem1.getOrdemId());

        DAO.getOrdem().buscarPorId(this.ordem1.getOrdemId()).setFatura(fatura);

        assertEquals(true, ordemController.cadastrarServico(1, CategoriaServico.MONTAGEM_INSTALACAO), "1° Teste de cadastrar Servico!");
        assertEquals(1, DAO.getOrdem().buscarPorId(1).getServicos().size(), "2° Teste de cadastrar Servico!");
        assertEquals(1, DAO.getServico().getServicos().size(), "3° Teste de cadastrar Servico!");
    }

    @Test
    void removerServico(){
        OrdemController ordemController = new OrdemController();

        Ordem ordem2 = new Ordem(0);
        DAO.getOrdem().criar(ordem2);

        Fatura fatura = new Fatura(ordem2.getOrdemId());

        DAO.getOrdem().buscarPorId(ordem2.getOrdemId()).setFatura(fatura);

        Fatura fatura1 = new Fatura(this.ordem1.getOrdemId());

        DAO.getOrdem().buscarPorId(this.ordem1.getOrdemId()).setFatura(fatura1);

        assertEquals(true, ordemController.cadastrarServico(1, CategoriaServico.MONTAGEM_INSTALACAO), "1° Teste de remover Servico!");
        assertEquals(true, ordemController.cadastrarServico(2, CategoriaServico.LIMPEZA), "2° Teste de remover Servico!");
        assertEquals(true, ordemController.removerServico(DAO.getOrdem().buscarPorId(this.ordem1.getOrdemId()).getServicos().get(0)), "3° Teste de remover Servico!");
    }

    @Test
    void novoPagamento(){
        OrdemController ordemController = new OrdemController();
        Fatura fatura = new Fatura(this.ordem.getOrdemId());

        DAO.getOrdem().buscarPorId(this.ordem.getOrdemId()).setFatura(fatura);

        assertEquals(true, ordemController.novoPagamento(fatura), "1° Teste de novo Pagamento!");
        assertEquals(1, DAO.getOrdem().buscarPorId(this.ordem.getOrdemId()).getFatura().getPagamentos().size(), "2° Teste de novo Pagamento!");
    }

    @Test
    void cadastrarOrdem(){
        OrdemController ordemController = new OrdemController();

        Cliente cliente = new Cliente("Paulo", "Dom Basílio", "991482050");
        DAO.getCliente().criar(cliente);

        assertEquals(true, ordemController.cadastrarOrdem(cliente.getClienteId()), "1° Teste de cadastrar Cliente!");
        assertEquals(false, ordemController.cadastrarOrdem(1), "2° Teste de cadastrar Cliente!");
    }
}