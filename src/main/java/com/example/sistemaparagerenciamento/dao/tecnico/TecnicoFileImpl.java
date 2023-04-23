package com.example.sistemaparagerenciamento.dao.tecnico;
import com.example.sistemaparagerenciamento.model.Tecnico;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class TecnicoFileImpl {
    private String filename = "tecnico.bin";

    public TecnicoFileImpl(String filename) {
        this.filename = filename;
    }

    public void save(List<Tecnico> tecnicos) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.filename));
            for (Tecnico tecnico : tecnicos) {
                file.writeObject(tecnico);
            }
            file.close();
        } catch (IOException e) {
        }
    }
    public List<Tecnico> load() {
        List<Tecnico> tecnicos = new ArrayList<>();
        try {
            Tecnico tecnico = null;
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.filename));
            do {
                tecnico = (Tecnico) file.readObject();
                if (tecnico != null) {
                    tecnicos.add(tecnico);
                }
            } while (tecnico != null);
            file.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return tecnicos;
    }
}
