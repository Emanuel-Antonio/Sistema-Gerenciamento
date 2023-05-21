package com.example.sistemaparagerenciamento.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Maincontroller {

    @FXML
    private Button cliente;

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

}
