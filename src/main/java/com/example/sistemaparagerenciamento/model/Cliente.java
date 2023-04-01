package com.example.sistemaparagerenciamento.model;

import java.util.List;

public class Cliente {
    private String nome;

    private String endereco;

    private String telefone;

    private List<Ordem> ordem;

    private Integer clienteId;

    public Cliente(String nome, Integer clienteId) {
        this.nome = nome;
        this.clienteId = clienteId;
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

    public List<Ordem> getOrdem() {
        return ordem;
    }

    public void setOrdem(List<Ordem> ordem) {
        this.ordem = ordem;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
}
