package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.controller.test.ServicoController;
import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.CategoriaServico;
import com.example.sistemaparagerenciamento.model.Peca;
import com.example.sistemaparagerenciamento.model.Servico;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ServicoControllerTest {

    private Peca peca1;
    private Peca peca2;
    private Servico servico;

    @BeforeEach
    void setUp() {

        this.servico = new Servico(0, CategoriaServico.MONTAGEM_INSTALACAO);
        this.peca1 = new Peca("RAM");
        this.peca1.setQnt(1);
        this.peca2 = new Peca("SSD");

    }

    @AfterEach
    void tearDown() {

        DAO.getServico().resetar();
        DAO.getPeca().resetar();

    }

    @Test
    void removerPecaDoServico(){

        DAO.getServico().criar(this.servico);
        ServicoController servicoController = new ServicoController();

        DAO.getPeca().criar(peca1);
        DAO.getPeca().criar(peca2);

        List<Peca> pecas = new ArrayList<>();
        pecas.add(peca1);
        pecas.add(peca2);

        DAO.getServico().buscarPorId(this.servico.getServicoId()).setPeca(pecas);

        assertEquals(true,servicoController.removerPecaDoServico(this.servico, this.peca1), "1 Teste de remover peca do Servico!");
        assertEquals(1, DAO.getServico().buscarPorId(this.servico.getServicoId()).getPecas().size(), "2 Teste de remover peca do Servico!");
        assertEquals(2, DAO.getPeca().buscarPorNome(this.peca1.getNome()).getQnt(), "3 Teste de remover peca do Servico!");

    }

    @Test
    void adicionarPecaAoServico(){

        DAO.getServico().criar(this.servico);
        ServicoController servicoController = new ServicoController();

        DAO.getPeca().criar(peca1);
        DAO.getPeca().criar(peca2);

        assertEquals(true, servicoController.adicionarPecaAoServico(this.servico, this.peca1), "1 Teste de adicionar peca do Servico!");
        assertEquals(false, servicoController.adicionarPecaAoServico(this.servico, this.peca2), "2 Teste de adicionar peca do Servico!");
        assertEquals(0, DAO.getPeca().buscarPorNome(this.peca1.getNome()).getQnt(), "3 Teste de remover peca do Servico!");

    }

}