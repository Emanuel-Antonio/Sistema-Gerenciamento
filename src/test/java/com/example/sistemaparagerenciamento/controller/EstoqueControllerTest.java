package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.OrdemCompra;
import com.example.sistemaparagerenciamento.model.Peca;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EstoqueControllerTest {

    @AfterEach
    void tearDown() {

        DAO.getPeca().resetar();
        DAO.getOrdemCompra().resetar();

    }

    @Test
    void visualizarEstoque() {

        EstoqueController estoqueController = new EstoqueController();

        Peca peca = new Peca("RAM");
        peca.setQnt(20);
        peca.setValor(10.0);

        DAO.getPeca().criar(peca);

        Peca peca1 = new Peca("SSD");
        peca1.setQnt(10);
        peca1.setValor(20.0);

        DAO.getPeca().criar(peca1);

        assertEquals("Estoque: \n" + "\n" + "Nome: RAM\n" + "Valor: 10.0\n" + "Quantidade: 20\n" + "\n" + "Nome: SSD\n" + "Valor: 20.0\n" + "Quantidade: 10", estoqueController.visualizarEstoque(), "1° teste visualizarEstoque");

    }

    @Test
    void visualizarOrdensCompra(){

        EstoqueController estoqueController = new EstoqueController();

        OrdemCompra ordemCompra = new OrdemCompra(10, 79.0, "RAM");
        OrdemCompra ordemCompra1 = new OrdemCompra(10, 109.0, "SSD");

        DAO.getOrdemCompra().criar(ordemCompra);
        DAO.getOrdemCompra().criar(ordemCompra1);

        assertEquals("Ordens de compra: \n" + "\n" + "Nome: RAM\n" + "Valor: 79.0\n" + "Quantidade: 10\n" + "Id : 0\n" + "\n" + "Nome: SSD\n" + "Valor: 109.0\n" + "Quantidade: 10\n" + "Id : 1", estoqueController.visualizarOrdensCompra(), "1° teste visualizarOrdensCompra");

    }

    @Test
    void cadastrarOrdemCompra(){

        EstoqueController estoqueController = new EstoqueController();

        OrdemCompra ordemCompra = new OrdemCompra(10, 107, "SSD");

        DAO.getOrdemCompra().criar(ordemCompra);

        assertEquals(true, estoqueController.cadastrarOrdemCompra(10, 79.0, "RAM"), "1° teste cadastrarOrdemCompra" );
        assertEquals(true, estoqueController.cadastrarOrdemCompra(10,107,"SSD"), "2° teste cadastrarOrdemCompra" );

    }

    @Test
    void cadastrarPeca(){

        EstoqueController estoqueController = new EstoqueController();

        Peca peca = new Peca("RAM");
        peca.setValor(80.0);
        peca.setQnt(5);

        DAO.getPeca().criar(peca);

        assertEquals(true, estoqueController.cadastrarPeca("SSD"), "1° teste cadastrarPeca");
        assertEquals(false, estoqueController.cadastrarPeca("RAM"), "2° teste cadastrarPeca");

    }

    @Test
    void adicionarPeca(){

        EstoqueController estoqueController = new EstoqueController();

        Peca peca = new Peca("RAM");
        peca.setValor(80.0);
        peca.setQnt(5);

        Peca peca1 = new Peca("SSD");
        peca1.setValor(8.0);
        peca1.setQnt(5);

        DAO.getPeca().criar(peca);

        assertEquals(true, estoqueController.adicionarPeca(peca, 10, 83.0),"1° teste adicionarPeca");
        assertEquals(false, estoqueController.adicionarPeca(peca1, 5, 7.0), "2° teste adicionarPeca");
        assertEquals(15, DAO.getPeca().buscarPorNome("RAM").getQnt(),"3° teste adicionarPeca");
        assertEquals(82, DAO.getPeca().buscarPorNome("RAM").getValor(), "4° teste adicionarPeca");

    }

}