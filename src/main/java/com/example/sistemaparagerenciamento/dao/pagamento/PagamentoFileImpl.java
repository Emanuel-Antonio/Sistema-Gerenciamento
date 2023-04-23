package com.example.sistemaparagerenciamento.dao.pagamento;

import com.example.sistemaparagerenciamento.model.Pagamento;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class PagamentoFileImpl {
    private String filename = "pagamento.bin";

    public PagamentoFileImpl(String filename) {
        this.filename = filename;
    }

    public void save(List<Pagamento> pagamentos) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.filename));
            for (Pagamento pagamento : pagamentos) {
                file.writeObject(pagamento);
            }
            file.close();
        } catch (IOException e) {
        }
    }
    public List<Pagamento> load() {
        List<Pagamento> pagamentos = new ArrayList<>();
        try {
            Pagamento pagamento = null;
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.filename));
            do {
                pagamento = (Pagamento) file.readObject();
                if (pagamento != null) {
                    pagamentos.add(pagamento);
                }
            } while (pagamento != null);
            file.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return pagamentos;
    }
}
