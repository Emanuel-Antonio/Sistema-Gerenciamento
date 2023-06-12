package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Mylistener;
import com.example.sistemaparagerenciamento.model.Cliente;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CardClienteController {

    @FXML
    private Label endereco;

    @FXML
    private ImageView img;

    @FXML
    private Label nomeCliente;

    @FXML
    private Label telefone;

    private Mylistener mylistener1;

    private Cliente cliente;

    @FXML
    void click(MouseEvent event) {
        mylistener1.onClickListener(cliente);
    }

    public void setData(Cliente cliente, Mylistener mylistener1){
        this.cliente = cliente;
        this.mylistener1 = mylistener1;
        telefone.setText(cliente.getTelefone());
        nomeCliente.setText(cliente.getNome());
        endereco.setText(cliente.getEndereco());
    }

}