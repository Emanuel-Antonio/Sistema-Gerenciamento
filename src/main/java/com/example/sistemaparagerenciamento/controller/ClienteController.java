package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.Mylistener;
import com.example.sistemaparagerenciamento.Mylistener1;
import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Cliente;
import com.example.sistemaparagerenciamento.model.Peca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClienteController implements Initializable {

    @FXML
    private Label endereco;

    @FXML
    private GridPane gridContainer1;

    @FXML
    private Button home;

    @FXML
    private TextField inputCliente;

    @FXML
    private TextField inputEndereco;

    @FXML
    private TextField inputTelefone;

    @FXML
    private Label nomeCliente;

    @FXML
    private Label nomeTela;

    @FXML
    private Button ordens;

    @FXML
    private Button sair;

    @FXML
    private Button salvarAtualizacao;

    @FXML
    private Button salvarCadastro;

    @FXML
    private Button salvarExclusao;

    @FXML
    private VBox tela;

    @FXML
    private Label telefone;

    private List<Cliente> clientes = new ArrayList<>();

    private Mylistener1 mylistener1;

    @FXML
    private Label clienteId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initialize();

    }

    public void initialize(){

        gridContainer1.getChildren().clear();
        clientes.clear();
        clientes.addAll(getData());
        if(clientes.size()>0){
            mylistener1 = new Mylistener1() {
                @Override
                public void onClickListener1(Cliente cliente) {
                    setChosenCliente(cliente);
                }
            };
        }
        try {

            int linha = 1;
            int coluna = 0;

            for (int i = 0; i < clientes.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("cliente.fxml"));
                VBox card = fxmlLoader.load();

                CardClienteController cardClienteController = fxmlLoader.getController();
                cardClienteController.setData(clientes.get(i), mylistener1);

                if (coluna == 4) {

                    coluna = 0;
                    linha++;

                }

                gridContainer1.add(card, coluna++, linha);
                GridPane.setMargin(card, new Insets(10));

            }
        }
        catch (Exception e) {

        }
    }

    public void setChosenCliente(Cliente cliente){

        clienteId.setText(String.valueOf(cliente.getClienteId()));
        nomeCliente.setText(cliente.getNome());
        endereco.setText(cliente.getEndereco());
        telefone.setText(cliente.getTelefone());
        inputCliente.setText(cliente.getNome());
        inputEndereco.setText(cliente.getEndereco());
        inputTelefone.setText(cliente.getTelefone());

    }

    private List<Cliente> getData(){
        return DAO.getCliente().getClientes();
    }

    @FXML
    void atualizarOnAction(ActionEvent event) {

        this.inputCliente.setDisable(true);
        this.nomeTela.setText("Alterar");
        this.clienteId.setText("");
        this.salvarExclusao.setVisible(false);
        this.salvarCadastro.setVisible(false);
        this.salvarAtualizacao.setVisible(true);
        this.tela.setVisible(true);

    }

    @FXML
    void cadastrarOnAction(ActionEvent event) {

        this.inputCliente.setDisable(false);
        this.inputCliente.setText("");
        this.inputTelefone.setText("");
        this.inputEndereco.setText("");
        this.nomeCliente.setText("");
        this.endereco.setText("");
        this.telefone.setText("");
        this.nomeTela.setText("Cadastrar");
        this.clienteId.setText("");
        this.salvarExclusao.setVisible(false);
        this.salvarAtualizacao.setVisible(false);
        this.salvarCadastro.setVisible(true);
        this.tela.setVisible(true);

    }

    @FXML
    void clientesOnAction(ActionEvent event) {

        Main.telaScreen("clientes");

    }

    @FXML
    void estoqueOnAction(ActionEvent event) {

        Main.telaScreen("estoque");


    }

    @FXML
    void excluirOnAction(ActionEvent event) {

        this.inputCliente.setDisable(true);
        this.nomeTela.setText("Excluir");
        this.clienteId.setText("");
        this.salvarAtualizacao.setVisible(false);
        this.salvarCadastro.setVisible(false);
        this.salvarExclusao.setVisible(true);
        this.tela.setVisible(true);

    }

    @FXML
    void homeOnAction(ActionEvent event) {

        Main.telaScreen("paginaprincipal");

    }

    @FXML
    void ordemOnAction(ActionEvent event) {

        Main.telaScreen("ordens");

    }

    @FXML
    void sairOnAction(ActionEvent event) {

        DAO.getTecnico().setTecnicoLogado(null);
        Main.telaScreen("login");

    }

    @FXML
    void salvarAtualizacaoOnAction(ActionEvent event) {

        DAO.getCliente().buscarPorId(Integer.parseInt(clienteId.getText())).setEndereco(inputEndereco.getText());
        DAO.getCliente().buscarPorId(Integer.parseInt(clienteId.getText())).setTelefone(inputTelefone.getText());
        setChosenCliente(DAO.getCliente().buscarPorId(Integer.parseInt(clienteId.getText())));
        Cliente cliente1 = new Cliente(inputCliente.getText(), inputEndereco.getText(),inputTelefone.getText());
        cliente1.setClienteId(Integer.parseInt(clienteId.getText()));
        DAO.getCliente().atualizar(cliente1);

        initialize();

        nomeCliente.setText("");
        endereco.setText("");
        telefone.setText("");
        inputCliente.setText("");
        inputEndereco.setText("");
        inputTelefone.setText("");
        clienteId.setText("");

    }

    @FXML
    void salvarCadastroOnAction(ActionEvent event) {

        Cliente cliente = new Cliente(inputCliente.getText(), inputEndereco.getText(), inputTelefone.getText());
        DAO.getCliente().criar(cliente);

        initialize();

        inputCliente.setText("");
        inputTelefone.setText("");
        inputEndereco.setText("");
        clienteId.setText("");

    }

    @FXML
    void salvarExclusaoOnAction(ActionEvent event) {

        DAO.getCliente().deletar(Integer.parseInt(clienteId.getText()));

        this.inputCliente.setText("");
        this.inputEndereco.setText("");
        this.inputTelefone.setText("");
        this.nomeCliente.setText("");
        this.telefone.setText("");
        this.endereco.setText("");
        this.clienteId.setText("");

        initialize();

    }

}
