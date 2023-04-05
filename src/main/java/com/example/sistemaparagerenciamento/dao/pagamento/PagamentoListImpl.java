package com.example.sistemaparagerenciamento.dao.pagamento;

import com.example.sistemaparagerenciamento.model.Pagamento;

import java.util.ArrayList;
import java.util.List;

public class PagamentoListImpl implements PagamentoDAO {

    public List<Pagamento> pagamentos;

    public PagamentoListImpl(){
        this.pagamentos = new ArrayList<Pagamento>();
    }

    @Override
    public Pagamento criar(Pagamento pagamento) {
        this.pagamentos.add(pagamento);

        return pagamento;
    }

}
