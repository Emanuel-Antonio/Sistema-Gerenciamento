package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Peca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EstoqueController implements Initializable{

    @FXML
    private GridPane gridContainer;

    @FXML
    private Button home;

    @FXML
    private Button sair;

    @FXML
    private Button clientes;

    @FXML
    private Button ordens;

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

    @FXML
    void clientesOnAction(ActionEvent event) {
        Main.telaScreen("clientes");
    }

    @FXML
    void ordemOnAction(ActionEvent event) {
        Main.telaScreen("ordens");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pecas.addAll(getData());
        try {

            int linha = 1;
            int coluna = 0;

            for (int i = 0; i < pecas.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("peca.fxml"));
                VBox card = fxmlLoader.load();

                PecaController pecaController = fxmlLoader.getController();
                pecaController.setData(pecas.get(i));

                if (coluna == 3) {

                    coluna = 0;
                    linha++;
                }

                gridContainer.add(card, coluna++, linha);

                GridPane.setMargin(card, new Insets(10));


            }
        }
        catch (Exception e) {

        }
    }


    private List<Peca> pecas = new ArrayList<>();

    private List<Peca> getData(){
        return DAO.getPeca().getPecas();
    }
}
