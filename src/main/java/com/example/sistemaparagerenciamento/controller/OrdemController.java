package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.dao.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class OrdemController {

    @FXML
    private Button home;

    @FXML
    private Button sair;

    @FXML
    private Button estoque;
    @FXML
    void clientesOnAction(ActionEvent event) {
        Main.telaScreen("clientes");
    }

    @FXML
    void homeOnAction(ActionEvent event) {
        Main.telaScreen("paginaprincipal");
    }

    @FXML
    void sairOnAction(ActionEvent event) {
        DAO.getTecnico().setTecnicoLogado(null);
        Main.telaScreen("login");
    }

    @FXML
    void estoqueOnAction(ActionEvent event) {
        Main.telaScreen("estoque");
    }

}
