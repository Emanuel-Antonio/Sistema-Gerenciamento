package com.example.sistemaparagerenciamento.dao.pagamento;

import com.example.sistemaparagerenciamento.model.Pagamento;

public interface PagamentoDAO {

    public Pagamento criar(Pagamento pagamento);

    public Pagamento atualizar(Pagamento pagamento);

    public void deletar(Pagamento pagamento);

    public Pagamento buscarPorId(int id);

    public void resetar();

}
