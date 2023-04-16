package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.*;

class RecepcaoTest {

    @AfterEach
    void tearDown() {
        DAO.getTecnico().resetar();
        DAO.getOrdem().resetar();
        DAO.getPeca().resetar();
        DAO.getCliente().resetar();
        DAO.getServico().resetar();
    }

    @Test
    void logoffTecnico(){

        Recepcao recepcao = new Recepcao();

        assertNull(recepcao.logoffTecnico(), "1° teste logoffTecnico");

    }

    @Test
    void loginTecnico(){

        Recepcao recepcao = new Recepcao();

        Tecnico tecnico = new Tecnico("antonystark@gmail.com", "antony stark", "jarvis");

        DAO.getTecnico().criar(tecnico);

        assertEquals(tecnico, recepcao.loginTecnico("antonystark@gmail.com","jarvis"), "1° teste loginTecnico");
        assertNull(recepcao.loginTecnico("Batman@gmail.com","alfred"), "2° teste loginTecnico");

    }

    @Test
    void pegarOrdem(){

        Recepcao recepcao = new Recepcao();

        Cliente cliente = new Cliente("Paulo", "Dom Basílio", "991482050");
        DAO.getCliente().criar(cliente);
        Tecnico tecnico = new Tecnico("Digo@gmail.com", "Rodrigo", "1234");
        DAO.getTecnico().criar(tecnico);
        Tecnico tecnico1 = new Tecnico("nel@gmail.com", "emanuel", "1234");
        DAO.getTecnico().criar(tecnico1);
        Ordem ordem = new Ordem(null, cliente.getClienteId());
        DAO.getOrdem().criar(ordem);

        assertEquals(ordem, recepcao.pegarOrdem(tecnico), "1° teste pegarOrdem");
        assertNull(recepcao.pegarOrdem(tecnico1), "2° teste pegarOrdem");

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
    void cadastrarTecnico(){

        Recepcao recepcao = new Recepcao();

        assertEquals(true, recepcao.cadastrarTecnico("antonystark@gmail.com", "antony stark", "jarvis"), "1° teste cadastrar tecnico");
        assertEquals(false, recepcao.cadastrarTecnico("antonystark@gmail.com", "antony stark", "jarvis"), "2° teste cadastrar tecnico");
        assertEquals(true, DAO.getTecnico().buscarPorId(0).isAdm(), "3° teste cadastrar tecnico");
        assertEquals(true, recepcao.cadastrarTecnico("Batman@gmail.com", "bruce wayne", "alfred"), "4° teste cadastrar tecnico");
        assertEquals(false, DAO.getTecnico().buscarPorId(1).isAdm(), "5° teste cadastrar tecnico");

    }

    @Test
    void cadastrarCliente(){

        Recepcao recepcao = new Recepcao();

        assertEquals(true, recepcao.cadastrarCliente("emanuel", "feira de santana", "991778899"), "1° teste cadastrarCliente");
        assertEquals(false, recepcao.cadastrarCliente("emanuel", "feira de santana", "991778899"), "2° teste cadastrarCliente");

    }

    @Test
    void custoPeca(){

        Cliente cliente = new Cliente("Paulo", "Dom Basílio", "991482050");
        DAO.getCliente().criar(cliente);

        Ordem ordem = new Ordem(null, 0);

        Peca peca = new Peca("RAM");
        peca.setQnt(20);
        peca.setValor(10.0);

        Peca peca1 = new Peca("SSD");
        peca1.setQnt(10);
        peca1.setValor(20.0);

        DAO.getPeca().criar(peca);
        DAO.getPeca().criar(peca1);


        List<Peca> pecas = new ArrayList<>();
        pecas.add(peca);

        Servico servico = new Servico(0, CategoriaServico.LIMPEZA);
        servico.setPeca(pecas);

        List<Peca> pecas1 = new ArrayList<>();
        pecas1.add(peca1);

        Servico servico1 = new Servico(0, CategoriaServico.FORMATACAO_INSTALACAO);
        servico1.setPeca(pecas1);

        List<Servico> servicos = new ArrayList<>();
        servicos.add(servico);
        servicos.add(servico1);

        ordem.setServicos(servicos);

        DAO.getServico().criar(servico);
        DAO.getServico().criar(servico1);

        DAO.getOrdem().criar(ordem);

        Recepcao recepcao = new Recepcao();

        assertEquals("\n\nNome: RAM\n" + "Valor: 10.0\n" + "Quantidade: 20\n" + "\n" + "Nome: SSD\n" + "Valor: 20.0\n" + "Quantidade: 10", recepcao.custoPeca(ordem));

    }

    @Test
    void mediaTempoDeEspera(){

        Recepcao recepcao = new Recepcao();

        Cliente cliente = new Cliente("Paulo", "Dom Basílio", "991482050");
        DAO.getCliente().criar(cliente);

        Ordem ordem = new Ordem(null, 0);

        Servico servico = new Servico(0, CategoriaServico.LIMPEZA);
        servico.setValor(70);
        servico.setPeca(null);
        servico.setAvaliacaoCliente(5);
        servico.setDescricao("Limpeza interna e externa");

        DAO.getServico().criar(servico);

        Servico servico1 = new Servico(0, CategoriaServico.FORMATACAO_INSTALACAO);
        servico1.setValor(60);
        servico1.setPeca(null);
        servico1.setAvaliacaoCliente(5);
        servico1.setDescricao("Formatação e instalação de programas");

        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();

        servico.setHorarioFechamento(calendar);
        servico1.setHorarioFechamento(calendar1);

        List<Servico> servicos = new ArrayList<>();
        servicos.add(servico);
        servicos.add(servico1);

        DAO.getServico().criar(servico1);

        DAO.getOrdem().criar(ordem);



        assertEquals(0.004583333333333333, recepcao.mediaTempoDeEspera(ordem));

    }

    @Test
    void relatorioGeral(){

    }

}