package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Maincontroller {

    @FXML
    private TableColumn<?, ?> clienteIdTabela;

    @FXML
    private Button estoque;

    @FXML
    private Button home;

    @FXML
    private Button ordem;

    @FXML
    private TableColumn<?, ?> ordemIdTabela;

    @FXML
    private Button sair;

    @FXML
    private TableView<?> tabelaOrdens;

    @FXML
    void registrarClientes(ActionEvent event) {
        Main.telaScreen("registrocliente");
    }

}
