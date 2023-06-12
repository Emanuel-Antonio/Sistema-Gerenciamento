package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.dao.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class FaturaController {

    @FXML
    private GridPane gridContainer;

    @FXML
    private Button home;

    @FXML
    private Button sair;

    @FXML
    void clientesOnAction(ActionEvent event) {
        Main.telaScreen("clientes");
    }

    @FXML
    void faturaOnAction(ActionEvent event) {
         Main.telaScreen("fatura");
    }

    @FXML
    void homeOnAction(ActionEvent event) {
        Main.telaScreen("paginaprincipal");
    }

    @FXML
    void onMouseEntered(MouseEvent event) {

    }

    @FXML
    void ordemOnAction(ActionEvent event) {
        Main.telaScreen("ordens");
    }

    @FXML
    void estoqueOnAction(ActionEvent event) {
        Main.telaScreen("estoque");
    }

    @FXML
    void sairOnAction(ActionEvent event) {
        DAO.getTecnico().setTecnicoLogado(null);
        Main.telaScreen("login");
    }

}
