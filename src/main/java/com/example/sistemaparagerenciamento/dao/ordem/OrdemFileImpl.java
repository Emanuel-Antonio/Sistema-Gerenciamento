package com.example.sistemaparagerenciamento.dao.ordem;
import com.example.sistemaparagerenciamento.model.Ordem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class OrdemFileImpl {
    private String filename = "Ordem.bin";

    public OrdemFileImpl(String filename) {
        this.filename = filename;
    }

    public void save(List<Ordem> ordens) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.filename));
            for (Ordem ordem : ordens) {
                file.writeObject(ordem);
            }
            file.close();
        } catch (IOException e) {
        }
    }
    public List<Ordem> load() {
        List<Ordem> ordens = new ArrayList<>();
        try {
            Ordem ordem = null;
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.filename));
            do {
                ordem = (Ordem) file.readObject();
                if (ordem != null) {
                    ordens.add(ordem);
                }
            } while (ordem != null);
            file.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return ordens;
    }
}