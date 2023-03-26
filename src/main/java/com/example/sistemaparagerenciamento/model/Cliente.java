package com.example.sistemaparagerenciamento.model;

import java.util.List;

public class Cliente {
    private String nome;

    private String endereco;

    private String telefone;

    private List<Ordem> ordem;

    private Integer clienteid;

    public Cliente(String nome, Integer clienteid) {
        this.nome = nome;
        this.clienteid = clienteid;
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

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }
}
