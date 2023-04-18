package com.example.sistemaparagerenciamento.dao.pagamento;

import com.example.sistemaparagerenciamento.model.Pagamento;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementa&ccedil;&atilde;o de PagamentoDAO com lista
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class PagamentoListImpl implements PagamentoDAO {

    public List<Pagamento> pagamentos;
    public int novoId;

    /**
     * Construtor de PagamentoListImpl, necess&aacute;rio para inicializar os atributos novoId e pagamentos.
     */
    public PagamentoListImpl(){
        this.pagamentos = new ArrayList<>();
        this.novoId = 0;
    }

    @Override
    public Pagamento criar(Pagamento pagamento) {
        pagamento.setPagamentoId(this.novoId);
        this.novoId++;
        this.pagamentos.add(pagamento);
        return pagamento;
    }

    @Override
    public Pagamento atualizar(Pagamento pagamento) {
        for (int i = 0; i < this.pagamentos.size(); i++) {
            if (this.pagamentos.get(i).equals(pagamento)) {
                this.pagamentos.set(i, pagamento);
                return pagamento;
            }
        }
        return null;
    }

    @Override
    public void deletar(Pagamento pagamento) {
        for (int i = 0; i < this.pagamentos.size(); i++) {
            if (this.pagamentos.get(i).equals(pagamento))
                this.pagamentos.remove(i);
        }
    }

    @Override
    public Pagamento buscarPorId(int id) {
        for(Pagamento pagamento : this.pagamentos){
            if(pagamento.getPagamentoId() == id){
                return pagamento;
            }
        }
        return null;
    }

    @Override
    public void resetar() {
        this.pagamentos = new ArrayList<>();
        this.novoId = 0;
    }

}