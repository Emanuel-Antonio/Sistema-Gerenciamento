package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadastrarCliente {

    @FXML
    private TextField enderecoCliente;

    @FXML
    private TextField nomeCliente;

    @FXML
    private TextField telefoneCliente;

    @FXML
    private Label erroRegistrar;

    @FXML
    void registrarCliente(ActionEvent event) {
        for (int i = 0; i < DAO.getCliente().getClientes().size(); i++) {
            //Aqui eu verifico se o cliente já existe
            if (DAO.getCliente().getClientes().get(i).getNome().equals(nomeCliente.getText()) && DAO.getCliente().getClientes().get(i).getEndereco().equals(enderecoCliente.getText()) && DAO.getCliente().getClientes().get(i).getTelefone().equals(telefoneCliente.getText())) {
                this.erroRegistrar.setText("Esse Cliente já existe!");
                this.erroRegistrar.setVisible(true);
            }
        }
        if(("".equals(enderecoCliente.getText())) || ("".equals(nomeCliente.getText())) || ("".equals(telefoneCliente.getText()))){
            this.erroRegistrar.setText("Erro ao registrar cliente!");
            this.erroRegistrar.setVisible(true);
            System.out.println("1");
        }else if(!enderecoCliente.getText().matches("(\\(?\\d{2}\\)?\\s)?(\\d{4,5}-\\d{4})")){
            this.erroRegistrar.setText("Telefone Inválido!");
            this.erroRegistrar.setVisible(true);
            System.out.println("2");
        }else {
            Cliente cliente = new Cliente(nomeCliente.getText(), enderecoCliente.getText(), telefoneCliente.getText());
            //Aqui eu cadastro o cliente através do DAO de cliente
            DAO.getCliente().criar(cliente);
            Main.telaScreen("paginaprincipal");
            this.erroRegistrar.setText(null);
            this.erroRegistrar.setVisible(false);
            this.nomeCliente.setText(null);
            this.telefoneCliente.setText(null);
            this.enderecoCliente.setText(null);
        }
    }

    @FXML
    void voltar(ActionEvent event) {
        Main.telaScreen("paginaprincipal");
    }

}
