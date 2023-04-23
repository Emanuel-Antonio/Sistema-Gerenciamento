package com.example.sistemaparagerenciamento.dao.tecnico;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Tecnico;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TecnicoFileImplTest {
    private TecnicoFileImpl bancoDadosTecnico;
    private Tecnico tecnico;
    @BeforeEach
    void setUp() {
        this.bancoDadosTecnico = new TecnicoFileImpl("tecnicodata.bin");
        this.tecnico = new Tecnico("tonystark@gmail.com","antony stark", "jarvis");
        this.tecnico.setAdm(true);
        DAO.getTecnico().criar(this.tecnico);
    }

    @AfterEach
    void tearDown() {
        DAO.getTecnico().resetar();
    }

    @Test
    void save() {
        this.bancoDadosTecnico.save(DAO.getTecnico().getTecnicos());
        assertEquals(this.tecnico, this.bancoDadosTecnico.load().get(0));
    }

    @Test
    void load() {
        List<Tecnico> tecnicos = this.bancoDadosTecnico.load();
        assertEquals("tonystark@gmail.com",tecnicos.get(0).getEmail());
        assertEquals("antony stark", tecnicos.get(0).getNome());
        assertEquals("jarvis", tecnicos.get(0).getSenha());
        assertEquals(0,tecnicos.get(0).getTecnicoId());
        assertEquals(true, tecnicos.get(0).isAdm());
    }
}