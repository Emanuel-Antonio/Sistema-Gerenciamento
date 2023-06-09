package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.Mylistener2;
import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Cliente;
import com.example.sistemaparagerenciamento.model.Ordem;

import com.example.sistemaparagerenciamento.model.StatusOrdem;
import com.example.sistemaparagerenciamento.model.Tecnico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class OrdemController implements Initializable {
    @FXML
    private Button home;

    @FXML
    private Button sair;

    @FXML
    private Button estoque;

    @FXML
    private GridPane gridContainer;

    private List<Ordem> ordens = new ArrayList<>();

    private Mylistener2 mylistener2;

    @FXML
    private Label nomeTela;

    @FXML
    private ChoiceBox<String> inputAvaliacao;

    @FXML
    private ChoiceBox<String> inputStatus;

    @FXML
    private TextField inputIdCliente;

    @FXML
    private TextField inputIdServico;

    @FXML
    private TextField inputIdTecnico;

    @FXML
    private TextField inputNomeCliente;

    @FXML
    private TextField inputIdOrdem;

    @FXML
    private Button salvarAtualizacao;

    @FXML
    private Button salvarCadastro;

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
    @FXML
    void servicoOnAction(ActionEvent event) {
        Main.telaScreen("servico");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.inputStatus.getItems().addAll("PAGAMENTO", "FECHADA", "CANCELADA", "ANDAMENTO");
        this.inputAvaliacao.getItems().addAll("Ótimo", "Bom", "Médio", "Ruim", "Péssimo");
        initialize();

    }

    public void initialize(){

        gridContainer.getChildren().clear();
        ordens.clear();
        ordens.addAll(getData());
        if(ordens.size()>0){
            mylistener2 = new Mylistener2() {
                @Override
                public void onClickListener2(Ordem ordem) {
                    setChosenCliente(ordem);
                }
            };
        }
        try {

            int linha = 1;
            int coluna = 0;

            for (int i = 0; i < ordens.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ordem.fxml"));
                VBox card = fxmlLoader.load();

                CardOrdemController cardOrdemController = fxmlLoader.getController();
                cardOrdemController.setData(ordens.get(i), mylistener2);

                if (coluna == 4) {

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

    public void setChosenCliente(Ordem ordem){
        this.inputNomeCliente.setText(ordem.getNomeCliente());
        this.inputIdCliente.setText(String.valueOf(ordem.getClienteId()));
        this.inputIdTecnico.setText(String.valueOf(ordem.getTecnicoId()));
        this.inputAvaliacao.setValue(ordem.getAvaliacaoFinal());
        this.inputStatus.setValue(String.valueOf(ordem.getStatus()));
        this.inputIdOrdem.setText(String.valueOf(ordem.getOrdemId()));
    }

    private List<Ordem> getData(){
        return DAO.getOrdem().getOrdens();
    }

}
