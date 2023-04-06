package com.example.sistemaparagerenciamento.model;


import com.example.sistemaparagerenciamento.dao.DAO;

public class Recepcao {
    private String tipoPagamento;

    private Double valor;

    public boolean novoPagamento(Fatura fatura) {
        Pagamento pagamento = new Pagamento(this.tipoPagamento,this.valor,fatura);
        if(fatura.getValorTotal() >= (fatura.getValorPago() + pagamento.getValor())) {
            DAO.getPagamento().criar(pagamento);

            DAO.getPagamento().buscarPorId(pagamento.getPagamentoId()).getFatura().setValorPago(pagamento.getValor());
            return true;
        }
        return false;
    }

    public Fatura gerarFatura(int ordemId){
        if(DAO.getOrdem().buscarPorId(ordemId).getFatura() == null && DAO.getOrdem().buscarPorId(ordemId).getServico() != null){
            Fatura fatura = new Fatura(ordemId);
            return fatura;
        }
        return null;
    }

    public Ordem pegarOrdem(Tecnico tecnico){
        if(DAO.getOrdem().listaOrdens() != null){
            for(int i = 0; i < DAO.getOrdem().listaOrdens().size();i++){
                if(DAO.getOrdem().listaOrdens().get(i).getTecnicoId() == -1){
                    DAO.getTecnico().buscarPorId(tecnico.getTecnicoId()).setOrden(DAO.getOrdem().listaOrdens().get(i));
                    DAO.getOrdem().listaOrdens().get(i).setTecnicoId(tecnico.getTecnicoId());
                }
            }
        }
        return null;
    }



}
