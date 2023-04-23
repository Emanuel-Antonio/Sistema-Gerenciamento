package com.example.sistemaparagerenciamento.dao.peca;

import com.example.sistemaparagerenciamento.model.Peca;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class PecaFileImpl {
    private String filename = "peca.bin";

    public PecaFileImpl(String filename) {
        this.filename = filename;
    }

    public void save(List<Peca> pecas) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.filename));
            for (Peca peca : pecas) {
                file.writeObject(peca);
            }
            file.close();
        } catch (IOException e) {
        }
    }
    public List<Peca> load() {
        List<Peca> pecas = new ArrayList<>();
        try {
            Peca peca = null;
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.filename));
            do {
                peca = (Peca) file.readObject();
                if (peca != null) {
                    pecas.add(peca);
                }
            } while (peca != null);
            file.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return pecas;
    }
}
