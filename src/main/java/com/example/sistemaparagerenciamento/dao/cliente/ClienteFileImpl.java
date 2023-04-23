package com.example.sistemaparagerenciamento.dao.cliente;
import com.example.sistemaparagerenciamento.model.Cliente;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class ClienteFileImpl {
    private String filename = "cliente.bin";

    public ClienteFileImpl(String filename) {
        this.filename = filename;
    }

    public void save(List<Cliente> clientes) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.filename));
            for (Cliente cliente : clientes) {
                file.writeObject(cliente);
            }
            file.close();
        } catch (IOException e) {
        }
    }
    public List<Cliente> load() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            Cliente cliente = null;
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.filename));
            do {
                cliente = (Cliente) file.readObject();
                if (cliente != null) {
                    clientes.add(cliente);
                }
            } while (cliente != null);
            file.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return clientes;
    }
}