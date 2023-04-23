package com.example.sistemaparagerenciamento.dao.servico;

import com.example.sistemaparagerenciamento.model.Servico;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class ServicoFileImpl {
    private String filename = "servico.bin";

    public ServicoFileImpl(String filename) {
        this.filename = filename;
    }

    public void save(List<Servico> servicos) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.filename));
            for (Servico servico : servicos) {
                file.writeObject(servico);
            }
            file.close();
        } catch (IOException e) {
        }
    }
    public List<Servico> load() {
        List<Servico> servicos = new ArrayList<>();
        try {
            Servico servico = null;
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.filename));
            do {
                servico = (Servico) file.readObject();
                if (servico != null) {
                    servicos.add(servico);
                }
            } while (servico != null);
            file.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return servicos;
    }
}

