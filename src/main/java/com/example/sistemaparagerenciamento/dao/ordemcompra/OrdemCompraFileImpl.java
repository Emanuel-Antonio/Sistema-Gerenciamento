package com.example.sistemaparagerenciamento.dao.ordemcompra;
import com.example.sistemaparagerenciamento.model.OrdemCompra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class OrdemCompraFileImpl {
    private String filename = "OrdemCompra.bin";

    public OrdemCompraFileImpl(String filename) {
        this.filename = filename;
    }

    public void save(List<OrdemCompra> ordensCompra) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.filename));
            for (OrdemCompra ordemCompra : ordensCompra) {
                file.writeObject(ordemCompra);
            }
            file.close();
        } catch (IOException e) {
        }
    }
    public List<OrdemCompra> load() {
        List<OrdemCompra> ordensCompra = new ArrayList<>();
        try {
            OrdemCompra ordemCompra = null;
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.filename));
            do {
                ordemCompra = (OrdemCompra) file.readObject();
                if (ordemCompra != null) {
                    ordensCompra.add(ordemCompra);
                }
            } while (ordemCompra != null);
            file.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return ordensCompra;
    }
}