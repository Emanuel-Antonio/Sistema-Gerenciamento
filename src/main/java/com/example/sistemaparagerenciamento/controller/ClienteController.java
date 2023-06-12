package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.Mylistener;
import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Cliente;

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
    private VBox tela;

    @FXML
    private Label telefone;

    private List<Cliente> clientes = new ArrayList<>();

    private Mylistener mylistener1;

    @FXML
    private Label clienteId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.nomeTela.setText("Cadastro");
        initialize();

    }

    public void initialize(){

        gridContainer1.getChildren().clear();
        clientes.clear();
        clientes.addAll(getData());
        if(clientes.size()>0){
            mylistener1 = new Mylistener() {
                @Override
                public void onClickListener(Object cliente) {
                    Cliente cliente1 = (Cliente) cliente;
                    setChosenCliente(cliente1);
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

        try{
            this.inputCliente.setDisable(false);
            this.salvarAtualizacao.setVisible(false);
            this.salvarCadastro.setVisible(false);
            this.tela.setVisible(true);

            DAO.getCliente().deletar(Integer.parseInt(clienteId.getText()));

            this.inputCliente.setText("");
            this.inputEndereco.setText("");
            this.inputTelefone.setText("");
            this.nomeCliente.setText("");
            this.telefone.setText("");
            this.endereco.setText("");
            this.clienteId.setText("");

            initialize();
            this.nomeTela.setText("Excluir");
        }
        catch(Exception e){

        }


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
    void faturaOnAction(ActionEvent event) {
        Main.telaScreen("fatura");
    }

    @FXML
    void salvarAtualizacaoOnAction(ActionEvent event) {

        try {
            boolean isNumericEndereco = (inputEndereco != null && inputEndereco.getText().matches("[0-9]+"));
            if(isNumericEndereco){
                this.nomeTela.setText("Endereço inválido!");
            }
            else {
                if (("".equals(this.inputEndereco.getText())) || ("".equals(this.inputTelefone.getText()))) {
                    this.nomeTela.setText("Erro ao atualizar cliente!");
                    this.nomeTela.setVisible(true);
                    System.out.println("1");
                } else if (!inputTelefone.getText().matches("(\\(?\\d{2}\\)?\\s)?(\\d{4,5}-\\d{4})")) {
                    this.nomeTela.setText("Telefone Inválido!");
                    this.nomeTela.setVisible(true);
                    System.out.println("2");
                } else {
                    Cliente cliente = new Cliente(this.inputCliente.getText(), this.inputEndereco.getText(), this.inputTelefone.getText());
                    //Aqui eu cadastro o cliente através do DAO de cliente
                    setChosenCliente(DAO.getCliente().buscarPorId(Integer.parseInt(clienteId.getText())));
                    cliente.setClienteId(Integer.parseInt(clienteId.getText()));
                    DAO.getCliente().atualizar(cliente);
                    initialize();

                    nomeCliente.setText("");
                    endereco.setText("");
                    telefone.setText("");
                    inputCliente.setText("");
                    inputEndereco.setText("");
                    inputTelefone.setText("");
                    clienteId.setText("");
                    this.nomeTela.setText("Cadastro");
                    salvarAtualizacao.setVisible(false);
                    salvarCadastro.setVisible(true);
                    inputCliente.setDisable(false);

                }
            }
        }
        catch (Exception e){
            this.nomeTela.setText("Erro ao atualizar cliente!");
            this.nomeTela.setVisible(true);
        }

    }

    @FXML
    void salvarCadastroOnAction(ActionEvent event) {

        try {
            for (int i = 0; i < DAO.getCliente().getClientes().size(); i++) {
                //Aqui eu verifico se o cliente já existe
                if (DAO.getCliente().getClientes().get(i).getNome().equals(this.inputCliente.getText()) && DAO.getCliente().getClientes().get(i).getEndereco().equals(this.inputEndereco.getText()) && DAO.getCliente().getClientes().get(i).getTelefone().equals(this.inputTelefone.getText())) {
                    this.nomeTela.setText("Esse Cliente já existe!");
                    this.nomeTela.setVisible(true);
                }
            }
            if(!("Esse Cliente já existe!".equals(this.nomeTela.getText()))) {
                boolean isNumericNome = (inputCliente != null && inputCliente.getText().matches("[0-9]+"));
                boolean isNumericEndereco = (inputEndereco != null && inputEndereco.getText().matches("[0-9]+"));
                if (isNumericNome || isNumericEndereco) {
                    this.nomeTela.setText("Nome e endereço não podem conter apenas números");
                } else {
                    if (("".equals(this.inputEndereco.getText())) || ("".equals(this.inputCliente.getText())) || ("".equals(this.inputTelefone.getText()))) {
                        this.nomeTela.setText("Preencha todos os campos");
                        this.nomeTela.setVisible(true);
                    } else if (!inputTelefone.getText().matches("(\\(?\\d{2}\\)?\\s)?(\\d{4,5}-\\d{4})")) {
                        this.nomeTela.setText("Telefone Inválido!");
                        this.nomeTela.setVisible(true);
                    } else {
                        Cliente cliente = new Cliente(this.inputCliente.getText(), this.inputEndereco.getText(), this.inputTelefone.getText());
                        //Aqui eu cadastro o cliente através do DAO de cliente
                        DAO.getCliente().criar(cliente);
                        initialize();

                        inputCliente.setText("");
                        inputTelefone.setText("");
                        inputEndereco.setText("");
                        clienteId.setText("");
                        this.nomeTela.setText("Cadastro");

                    }
                }
            }
        }
        catch (Exception e){
            this.nomeTela.setText("Erro ao registrar cliente!");
            this.nomeTela.setVisible(true);
        }

    }

}
