package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Cliente;
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

public class ClienteController implements Initializable {

    @FXML
    private Button estoque;

    @FXML
    private Button home;

    @FXML
    private Button sair;

    @FXML
    private Button ordens;
    @FXML
    private TableView<Cliente> tabelaClientes;

    @FXML
    private TableColumn<Cliente, String> enderecoCliente;

    @FXML
    private TableColumn<Cliente, Integer> idCliente;

    @FXML
    private TableColumn<Cliente, String> nomeCliente;

    @FXML
    private TableColumn<Cliente, String> telefoneCliente;

    private ObservableList<Cliente> clientes = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.clientes.addAll(DAO.getCliente().getClientes());

        enderecoCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("endereco"));
        nomeCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        idCliente.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("clienteId"));
        telefoneCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));

        this.tabelaClientes.setItems(clientes);

    }

    @FXML
    void estoqueOnAction(ActionEvent event) {
        Main.telaScreen("estoque");
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
    void ordemOnAction(ActionEvent event) {
        Main.telaScreen("ordens");
    }
}
