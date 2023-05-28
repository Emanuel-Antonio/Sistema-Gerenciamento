package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Ordem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Maincontroller implements Initializable {

    @FXML
    private Button cliente;

    @FXML
    private TableColumn<Ordem, String> clienteIdTabela;

    @FXML
    private Button estoque;

    @FXML
    private Button home;

    @FXML
    private Button ordem;

    @FXML
    private TableColumn<Ordem, Integer> ordemIdTabela;

    @FXML
    private Button sair;

    @FXML
    private TableView<Ordem> tabelaOrdens;

    private ObservableList<Ordem> ordens0 = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Ordem, String> dataTabela;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.ordens0.addAll(DAO.getOrdem().getOrdens());

        clienteIdTabela.setCellValueFactory(new PropertyValueFactory<Ordem, String>("nomeCliente"));
        ordemIdTabela.setCellValueFactory(new PropertyValueFactory<Ordem, Integer>("ordemId"));
        dataTabela.setCellValueFactory(new PropertyValueFactory<Ordem, String>("data"));

        this.tabelaOrdens.setItems(ordens0);

    }

    @FXML
    void sairOnAction(ActionEvent event) {
        DAO.getTecnico().setTecnicoLogado(null);
        Main.telaScreen("login");
    }

    @FXML
    void homeOnAction(ActionEvent event) {
        Main.telaScreen("paginaprincipal");
    }

    @FXML
    void estoqueOnAction(ActionEvent event) {
        Main.telaScreen("estoque");
    }
}
