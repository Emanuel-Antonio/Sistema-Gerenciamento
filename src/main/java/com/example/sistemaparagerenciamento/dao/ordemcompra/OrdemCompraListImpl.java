package com.example.sistemaparagerenciamento.dao.ordemcompra;

import com.example.sistemaparagerenciamento.model.OrdemCompra;

import java.util.ArrayList;
import java.util.List;

public class OrdemCompraListImpl implements OrdemCompraDAO{

    public List<OrdemCompra> ordensCompra;

    public int novoId;

    public OrdemCompraListImpl() {
        this.ordensCompra = new ArrayList<OrdemCompra>();
        this.novoId = 0;
    }


    @Override
    public OrdemCompra criar(OrdemCompra ordemCompra) {
        ordemCompra.setOrdemCompraId(this.novoId);
        this.novoId++;

        this.ordensCompra.add(ordemCompra);

        return ordemCompra;
    }

    @Override
    public OrdemCompra buscarPorId(int id) {
        for(OrdemCompra ordemCompra : this.ordensCompra){
            if(ordemCompra.getOrdemCompraId() == id){
                return ordemCompra;
            }
        }
        return null;
    }

    @Override
    public void atualizar(OrdemCompra ordemCompra) {
        for(int i = 0; i < this.ordensCompra.size(); i++){
            if(this.ordensCompra.get(i).equals(ordemCompra)){
                this.ordensCompra.set(i,ordemCompra);
            }
        }
    }

    @Override
    public void deletar(OrdemCompra ordemCompra) {
        for(int i = 0; i < this.ordensCompra.size(); i++){
            if (this.ordensCompra.get(i).equals(ordemCompra))
                this.ordensCompra.remove(i);
        }
    }
}
