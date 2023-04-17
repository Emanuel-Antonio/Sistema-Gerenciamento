package com.example.sistemaparagerenciamento.model;

import java.util.List;

/**
 * @author Emanuel Antonio Lima Pereira e Émerson Rodrigo Lima Pereira
 * @version 1.0
 *
 * Classe responsável por representar uma abstração de cliente
 */
public class Cliente {

    private final String nome;
    private String endereco;
    private String telefone;
    private List<Ordem> ordens;
    private int clienteId;

    /**
     * construtor de cliente, será necessário passar alguns parametros para cria um objeto Cliente, tais quais os listados abaixo.
     *
     * @param nome valor referente ao nome do cliente
     * @param endereco valor referente ao endereço do cliente
     * @param telefone valor referente ao telefone do cliente
     */
    public Cliente(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
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

    /**
     * sobrescrever do método equals para comparação de objetos Cliente, a comparação é feita atraves do identificador do cliente (clienteId)
     *
     * @param obj valor referente ao objeto Cliente
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cliente c){
            return c.getClienteId() == this.clienteId;
        }
        return false;
    }

    /**
     * sobrescrever do método toString para definir qual mensagem deverá ser retornada
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "Id: " + this.getClienteId() + "Endereço: " +
                this.getEndereco() + "Telefone: " + this.getTelefone();
    }

}