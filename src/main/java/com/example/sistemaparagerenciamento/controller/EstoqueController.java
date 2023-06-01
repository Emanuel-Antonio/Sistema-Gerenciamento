package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.Mylistener;
import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Peca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
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

    private Mylistener mylistener;

    @FXML
    private TextField inputPreco;

    @FXML
    private TextField inputQtd;

    @FXML
    private Label preco;

    @FXML
    private TextField inputPeca;

    public void setChosenPeca(Peca peca){
        nome.setText(peca.getNome());
        qtd.setText(String.valueOf(peca.getQnt()));
        preco.setText(String.valueOf(peca.getValor()));
        inputPreco.setText(String.valueOf(peca.getValor()));
        inputQtd.setText(String.valueOf(peca.getQnt()));
        inputPeca.setText(peca.getNome());
    }

    @FXML
    void salvarOnAction(ActionEvent event) {

        DAO.getPeca().buscarPorNome(nome.getText()).setQnt(Integer.parseInt(inputQtd.getText()));
        DAO.getPeca().buscarPorNome(nome.getText()).setValor(Double.valueOf((inputPreco.getText())));
        setChosenPeca(DAO.getPeca().buscarPorNome(nome.getText()));
        Peca peca = new Peca(nome.getText());
        peca.setQnt(Integer.parseInt(inputQtd.getText()));
        peca.setValor(Double.valueOf((inputPreco.getText())));
        DAO.getPeca().atualizar(peca);
        initialize();
        inputQtd.setText("");
        inputPreco.setText("");
        inputPeca.setText("");
    }


    @FXML
    private Label nome;

    @FXML
    private Label qtd;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initialize();

    }

    public void initialize(){
        gridContainer.getChildren().clear();
        pecas.clear();
        pecas.addAll(getData());
        if(pecas.size()>0){
            mylistener = new Mylistener() {
                @Override
                public void onClickListener(Peca peca) {
                    setChosenPeca(peca);
                }
            };
        }
        try {

            int linha = 1;
            int coluna = 0;

            for (int i = 0; i < pecas.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("peca.fxml"));
                VBox card = fxmlLoader.load();

                PecaController pecaController = fxmlLoader.getController();
                pecaController.setData(pecas.get(i), mylistener);

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
    private List<Peca> pecas = new ArrayList<>();

    private List<Peca> getData(){
        return DAO.getPeca().getPecas();
    }
}
