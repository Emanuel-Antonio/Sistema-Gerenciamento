package com.example.sistemaparagerenciamento.dao.fatura;

import com.example.sistemaparagerenciamento.dao.CRUD;
import com.example.sistemaparagerenciamento.model.Fatura;
import com.example.sistemaparagerenciamento.model.Pagamento;

public interface FaturaDAO {

    public Boolean novoPagamento(Pagamento pagamento);
}
