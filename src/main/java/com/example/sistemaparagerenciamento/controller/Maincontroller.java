package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Ordem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class Maincontroller {

    @FXML
    private Button cliente;

    @FXML
    private Button estoque;

    @FXML
    private Button home;

    @FXML
    private ListView<?> listOrdens;

    @FXML
    private Button ordem;

    @FXML
    private Button sair;

}
