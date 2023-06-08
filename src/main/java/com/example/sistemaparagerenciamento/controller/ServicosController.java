package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.Mylistener3;
import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.CategoriaServico;
import com.example.sistemaparagerenciamento.model.Servico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ServicosController implements Initializable {

    @FXML
    private Button estoque;

    @FXML
    private Button home;

    @FXML
    private Button sair;

    @FXML
    private GridPane gridContainer;

    private Mylistener3 mylistener3;

    private List<Servico> servicos = new ArrayList<>();

    @FXML
    void clientesOnAction(ActionEvent event) {
        Main.telaScreen("clientes");
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
    void servicoOnAction(ActionEvent event) {
        Main.telaScreen("servico");
    }

    @FXML
    void ordemOnAction(ActionEvent event) {
        Main.telaScreen("ordens");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initialize();

    }

    public void initialize(){

        gridContainer.getChildren().clear();
        servicos.clear();
        servicos.addAll(getData());
        if(servicos.size()>0){
            mylistener3 = new Mylistener3() {
                @Override
                public void onClickListener3(Servico servico) {
                    setChosenCliente(servico);
                }
            };
        }
        try {

            int linha = 1;
            int coluna = 0;

            for (int i = 0; i < servicos.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("servico.fxml"));
                VBox card = fxmlLoader.load();

                CardServicoController cardServicoController = fxmlLoader.getController();
                cardServicoController.setData(servicos.get(i), mylistener3);

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

    public void setChosenCliente(Servico servico){
    }

    private List<Servico> getData(){
        return DAO.getServico().getServicos();
    }


}
