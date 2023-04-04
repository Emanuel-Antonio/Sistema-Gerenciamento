package com.example.sistemaparagerenciamento.dao.fatura;

import com.example.sistemaparagerenciamento.model.Fatura;
import com.example.sistemaparagerenciamento.model.Pagamento;

import java.util.ArrayList;
import java.util.List;

public class FaturaListImpl implements FaturaDAO {

    public List<Pagamento> pagamentos;

    public Fatura fatura;

    public FaturaListImpl() {
        this.pagamentos = new ArrayList<Pagamento>();
    }

    @Override
    public Boolean novoPagamento(Pagamento pagamento) {
        if(this.fatura.getValorTotal() >= (this.fatura.getValorPago() + pagamento.getValor())) {
            this.pagamentos.add(pagamento);

            this.fatura.setValorPago(pagamento.getValor());
            return true;
        }
        return false;
    }
}
