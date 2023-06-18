package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Ordem;
import com.example.sistemaparagerenciamento.model.Tecnico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Maincontroller implements Initializable {

    @FXML
    private TableColumn<Ordem, String> clienteIdTabela;

    @FXML
    private Button home;

    @FXML
    private Label email;

    @FXML
    private Label idCliente;

    @FXML
    private Label idOrdem;

    @FXML
    private Label idTecnico;

    @FXML
    private Label nomeCliente;

    @FXML
    private Label statusOrdem;

    @FXML
    private Label nomeTecnico;

    @FXML
    private Label adm;

    @FXML
    private Label data;

    @FXML
    private TableColumn<Ordem, Integer> ordemIdTabela;

    @FXML
    private Button sair;

    @FXML
    private Button pegarOrdem;

    @FXML
    private Button ordens;

    @FXML
    private TableView<Ordem> tabelaOrdens;

    private ObservableList<Ordem> ordens0 = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Ordem, String> dataTabela;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initialize();

    }

    public void initialize(){
        this.ordens0.clear();
        List<Ordem> ordens = new ArrayList<>();
        for(int i = 0; i < DAO.getOrdem().getOrdens().size(); i++){
            if(DAO.getOrdem().getOrdens().get(i).getTecnicoId() == -1){
                ordens.add(DAO.getOrdem().getOrdens().get(i));
            }
        }
        this.ordens0.addAll(ordens);

        clienteIdTabela.setCellValueFactory(new PropertyValueFactory<Ordem, String>("nomeCliente"));
        ordemIdTabela.setCellValueFactory(new PropertyValueFactory<Ordem, Integer>("ordemId"));
        dataTabela.setCellValueFactory(new PropertyValueFactory<Ordem, String>("data"));

        this.tabelaOrdens.setItems(ordens0);

        try {
            if (DAO.getTecnico().getTecnicoLogado().isAdm()) {
                this.adm.setVisible(true);
            }else{
                this.adm.setVisible(false);
            }
            this.nomeTecnico.setText(DAO.getTecnico().getTecnicoLogado().getNome());
            this.email.setText(DAO.getTecnico().getTecnicoLogado().getEmail());
            this.idTecnico.setText(String.valueOf(DAO.getTecnico().getTecnicoLogado().getTecnicoId()));

            if(DAO.getTecnico().getTecnicoLogado().getOrdem() == null){
                this.nomeCliente.setText("");
                this.idCliente.setText("");
                this.idOrdem.setText("");
                this.statusOrdem.setText("");
                this.data.setText("");
            }else {
                this.nomeCliente.setText(DAO.getTecnico().getTecnicoLogado().getOrdem().getNomeCliente());
                this.idCliente.setText(String.valueOf(DAO.getTecnico().getTecnicoLogado().getOrdem().getClienteId()));
                this.idOrdem.setText(String.valueOf(DAO.getTecnico().getTecnicoLogado().getOrdem().getOrdemId()));
                this.statusOrdem.setText(String.valueOf(DAO.getTecnico().getTecnicoLogado().getOrdem().getStatus()));
                this.data.setText(DAO.getTecnico().getTecnicoLogado().getOrdem().getData());
            }
        }catch (Exception e){

        }
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

    @FXML
    void faturaOnAction(ActionEvent event) {
        Main.telaScreen("fatura");
    }

    @FXML
    void pegarOrdemOnAction(ActionEvent event) {
        if (DAO.getOrdem().getOrdens() != null) {
            for (int i = 0; i < DAO.getOrdem().getOrdens().size(); i++) {
                //Aqui verifica se a ordem não possui técnico
                if (DAO.getOrdem().getOrdens().get(i).getTecnicoId() == -1 && DAO.getTecnico().getTecnicoLogado().getOrdem() == null) {
                    //Aqui eu vinculo ordem a técnico
                    Tecnico tecnico = DAO.getTecnico().buscarPorId(Integer.parseInt(this.idTecnico.getText()));
                    tecnico.setOrdem(DAO.getOrdem().getOrdens().get(i));
                    DAO.getTecnico().atualizar(tecnico);
                    //Aqui eu vinculo técnico a ordem
                    Ordem ordem = DAO.getOrdem().getOrdens().get(i);
                    ordem.setTecnicoId(Integer.parseInt(this.idTecnico.getText()));
                    DAO.getOrdem().atualizar(ordem);
                }
            }
        }

        initialize();
    }

    @FXML
    void clientesOnAction(ActionEvent event) {
        Main.telaScreen("clientes");
    }

    @FXML
    void ordemOnAction(ActionEvent event) {
        Main.telaScreen("ordens");
    }

    @FXML
    void onMouseEntered(MouseEvent event) {

        initialize();
    }
}
