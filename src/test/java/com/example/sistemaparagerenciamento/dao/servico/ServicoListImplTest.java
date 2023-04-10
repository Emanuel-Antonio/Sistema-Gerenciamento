package com.example.sistemaparagerenciamento.dao.servico;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.CategoriaServico;
import com.example.sistemaparagerenciamento.model.Servico;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.*;

class ServicoListImplTest {

    @AfterEach
    void tearDown() {
        DAO.getServico().resetar();
    }

    @Test
    void criar() {
        Servico servico = new Servico(0, CategoriaServico.LIMPEZA);
        servico.setValor(70);
        servico.setPeca(null);
        servico.setAvaliacaoCliente(5);
        servico.setDescricao("Limpeza interna e externa");
        Calendar calendar = Calendar.getInstance();
        servico.setHorarioFechamento(calendar);

        DAO.getServico().criar(servico);

        assertEquals(70, DAO.getServico().buscarPorId(0).getValor(), " 1° Teste criar servico");
        assertNull(DAO.getServico().buscarPorId(0).getPecas(), " 2° Teste criar servico");
        assertEquals(5, DAO.getServico().buscarPorId(0).getAvaliacaoCliente(), " 3° Teste criar servico");
        assertEquals("Limpeza interna e externa", DAO.getServico().buscarPorId(0).getDescricao(), " 4° Teste criar servico");
        assertEquals(calendar, DAO.getServico().buscarPorId(0).getHorarioFechamento(), " 5° Teste criar servico");
    }

    @Test
    void buscarPorId() {
        Servico servico = new Servico(0, CategoriaServico.LIMPEZA);
        servico.setValor(70);
        servico.setPeca(null);
        servico.setAvaliacaoCliente(5);
        servico.setDescricao("Limpeza interna e externa");
        Calendar calendar = Calendar.getInstance();
        servico.setHorarioFechamento(calendar);

        DAO.getServico().criar(servico);

        Servico servico1 = new Servico(0, CategoriaServico.FORMATACAO_INSTALACAO);
        servico1.setValor(60);
        servico1.setPeca(null);
        servico1.setAvaliacaoCliente(5);
        servico1.setDescricao("Formatação e instalação de programas");
        Calendar calendar1 = Calendar.getInstance();
        servico1.setHorarioFechamento(calendar1);

        DAO.getServico().criar(servico1);

        assertEquals(servico, DAO.getServico().buscarPorId(0), " 1° Teste BuscarPorId servico");
        assertEquals(servico1, DAO.getServico().buscarPorId(1), " 2° Teste BuscarPorId servico");
    }

    @Test
    void atualizar() {
        Servico servico = new Servico(0, CategoriaServico.LIMPEZA);
        servico.setValor(70);
        servico.setPeca(null);
        servico.setAvaliacaoCliente(5);
        servico.setDescricao("Limpeza interna e externa");
        Calendar calendar = Calendar.getInstance();
        servico.setHorarioFechamento(calendar);

        DAO.getServico().criar(servico);

        servico.setValor(60);
        servico.setPeca(null);
        servico.setAvaliacaoCliente(5);
        servico.setDescricao("Formatação e instalação de programas");
        Calendar calendar1 = Calendar.getInstance();
        servico.setHorarioFechamento(calendar1);

        DAO.getServico().atualizar(servico);

        assertEquals(60, DAO.getServico().buscarPorId(0).getValor(), " 1° Teste atualizar servico");
        assertNull(DAO.getServico().buscarPorId(0).getPecas(), " 2° Teste atualizar servico");
        assertEquals(5, DAO.getServico().buscarPorId(0).getAvaliacaoCliente(), " 3° Teste atualizar servico");
        assertEquals("Formatação e instalação de programas", DAO.getServico().buscarPorId(0).getDescricao(), " 4° Teste atualizar servico");
        assertEquals(calendar1, DAO.getServico().buscarPorId(0).getHorarioFechamento(), " 5° Teste atualizar servico");
    }

    @Test
    void deletar() {
        Servico servico = new Servico(0, CategoriaServico.LIMPEZA);
        servico.setValor(70);
        servico.setPeca(null);
        servico.setAvaliacaoCliente(5);
        servico.setDescricao("Limpeza interna e externa");
        Calendar calendar = Calendar.getInstance();
        servico.setHorarioFechamento(calendar);

        DAO.getServico().criar(servico);

        Servico servico1 = new Servico(0, CategoriaServico.FORMATACAO_INSTALACAO);
        servico1.setValor(60);
        servico1.setPeca(null);
        servico1.setAvaliacaoCliente(5);
        servico1.setDescricao("Formatação e instalação de programas");
        Calendar calendar1 = Calendar.getInstance();
        servico1.setHorarioFechamento(calendar1);

        DAO.getServico().criar(servico1);

        DAO.getServico().deletar(servico);

        assertNull(DAO.getServico().buscarPorId(0), " 1° Teste deletar servico!");
        assertNotNull(DAO.getServico().buscarPorId(1), " 2° Teste deletar servico!");
    }

    @Test
    void resetar() {
        Servico servico = new Servico(0, CategoriaServico.LIMPEZA);
        servico.setValor(70);
        servico.setPeca(null);
        servico.setAvaliacaoCliente(5);
        servico.setDescricao("Limpeza interna e externa");
        Calendar calendar = Calendar.getInstance();
        servico.setHorarioFechamento(calendar);

        DAO.getServico().criar(servico);

        Servico servico1 = new Servico(0, CategoriaServico.FORMATACAO_INSTALACAO);
        servico1.setValor(60);
        servico1.setPeca(null);
        servico1.setAvaliacaoCliente(5);
        servico1.setDescricao("Formatação e instalação de programas");
        Calendar calendar1 = Calendar.getInstance();
        servico1.setHorarioFechamento(calendar1);

        DAO.getServico().criar(servico1);

        DAO.getServico().resetar();

        assertNull(DAO.getServico().buscarPorId(0), " 1° Teste resetar servico!");
        assertNull(DAO.getServico().buscarPorId(1), " 2° Teste resetar servico! ");
    }
}