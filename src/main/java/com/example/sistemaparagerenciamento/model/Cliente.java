package com.example.sistemaparagerenciamento.model;

import java.util.List;
import java.util.Objects;

public class Cliente {
    private String nome;

    private String endereco;

    private String telefone;

    private List<Ordem> ordens;

    private int clienteId;

    public Cliente(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Ordem> getOrdens() {
        return ordens;
    }

    public void setOrdens(List<Ordem> ordens) {
        this.ordens = ordens;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cliente){
            Cliente c = (Cliente) obj;
            if(c.getClienteId() == this.clienteId){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "Id: " + this.getClienteId() + "Endereço: " +
                this.getEndereco() + "Telefone: " + this.getTelefone();

    }
}
