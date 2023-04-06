package com.example.sistemaparagerenciamento.model;


public class Recepcao {

    public Boolean novoPagamento(Pagamento pagamento) {
        if(this.fatura.getValorTotal() >= (this.fatura.getValorPago() + pagamento.getValor())) {
            this.pagamentos.add(pagamento);

            this.fatura.setValorPago(pagamento.getValor());
            return true;
        }
        return false;
    }

}
