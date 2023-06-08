package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.Mylistener;
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

public class EstoqueController implements Initializable{

    @FXML
    private GridPane gridContainer;

    private Mylistener mylistener;

    @FXML
    private Button home;

    @FXML
    private Button sair;

    @FXML
    private Button clientes;

    @FXML
    private Button ordens;

    @FXML
    private TextField inputPreco;

    @FXML
    private TextField inputPeca;

    @FXML
    private TextField inputQtd;

    @FXML
    private Label preco;

    @FXML
    private Label nome;

    @FXML
    private Label qtd;

    @FXML
    private VBox tela;

    @FXML
    private Label nomeTela;
    @FXML
    private Button salvarAtualizacao;

    @FXML
    private Button salvarCadastro;

    private List<Peca> pecas = new ArrayList<>();

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

    @FXML
    void servicoOnAction(ActionEvent event) {

        Main.telaScreen("servico");

    }

    public void setChosenPeca(Peca peca){

        nome.setText(peca.getNome());
        qtd.setText(String.valueOf(peca.getQnt()));
        preco.setText(String.valueOf(peca.getValor()));
        inputPreco.setText(String.valueOf(peca.getValor()));
        inputQtd.setText(String.valueOf(peca.getQnt()));
        inputPeca.setText(peca.getNome());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.nomeTela.setText("Cadastro");
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

    private List<Peca> getData(){
        return DAO.getPeca().getPecas();
    }

    @FXML
    void atualizarOnAction(ActionEvent event) {

        this.inputPeca.setDisable(true);
        this.nomeTela.setText("Alterar");
        this.salvarCadastro.setVisible(false);
        this.salvarAtualizacao.setVisible(true);

    }

    @FXML
    void cadastrarOnAction(ActionEvent event) {

        this.inputPeca.setDisable(false);
        this.inputQtd.setText("");
        this.inputPreco.setText("");
        this.inputPeca.setText("");
        this.nome.setText("");
        this.qtd.setText("");
        this.preco.setText("");
        this.nomeTela.setText("Cadastrar");
        this.salvarAtualizacao.setVisible(false);
        this.salvarCadastro.setVisible(true);

    }

    @FXML
    void excluirOnAction(ActionEvent event) {

        this.inputPeca.setDisable(false);
        this.nomeTela.setText("Excluir");
        this.salvarAtualizacao.setVisible(false);
        this.salvarCadastro.setVisible(false);

        DAO.getPeca().deletar(DAO.getPeca().buscarPorNome(inputPeca.getText()));

        this.inputQtd.setText("");
        this.inputPreco.setText("");
        this.inputPeca.setText("");
        this.nome.setText("");
        this.qtd.setText("");
        this.preco.setText("");

        initialize();

    }

    @FXML
    void salvarAtualizacaoOnAction(ActionEvent event) {

        try {
            boolean isAlphaQuantidade = (inputQtd != null && inputQtd.getText().matches("[a-z]+"));
            boolean isAlphaValor = (inputPreco != null && inputPreco.getText().matches("[a-z]+"));
            if (!(isAlphaValor || isAlphaQuantidade)) {
                if (("".equals(this.inputPreco.getText())) || ("".equals(this.inputQtd.getText()))) {
                    this.nomeTela.setText("Erro ao atualizar cliente!");
                    this.nomeTela.setVisible(true);
                    System.out.println("1");
                } else {
                    DAO.getPeca().buscarPorNome(nome.getText()).setQnt(Integer.parseInt(inputQtd.getText()));
                    DAO.getPeca().buscarPorNome(nome.getText()).setValor(Double.valueOf((inputPreco.getText())));
                    setChosenPeca(DAO.getPeca().buscarPorNome(nome.getText()));

                    initialize();

                    inputQtd.setText("");
                    inputPreco.setText("");
                    inputPeca.setText("");
                    nome.setText("");
                    qtd.setText("");
                    preco.setText("");
                    this.nomeTela.setText("Cadastro");
                    salvarAtualizacao.setVisible(false);
                    salvarCadastro.setVisible(true);
                    inputPeca.setDisable(false);

                }
                }
                else{
                    this.nomeTela.setText("Dados inválidos!");
                }
        }
        catch (Exception e){
            this.nomeTela.setText("Erro ao atualizar Peça!");
            this.nomeTela.setVisible(true);
        }

    }

    @FXML
    void salvarCadastroOnAction(ActionEvent event) {

        try {
            for (int i = 0; i < DAO.getPeca().getPecas().size(); i++) {
                //Aqui eu verifico se a peça já existe
                if (DAO.getPeca().getPecas().get(i).getNome().equals(this.inputPeca.getText())) {
                    this.nomeTela.setText("Essa Peça já existe!");
                    this.nomeTela.setVisible(true);
                }
            }
            if (!("Essa Peça já existe!".equals(this.nomeTela.getText()))) {
                boolean isNumericNome = (inputPeca != null && inputPeca.getText().matches("[0-9]+"));
                if (isNumericNome) {
                    this.nomeTela.setText("Dados inválidos!");
                } else {
                    boolean isAlphaQuantidade = (inputQtd != null && inputQtd.getText().matches("[a-z]+"));
                    boolean isAlphaValor = (inputPreco != null && inputPreco.getText().matches("[a-z]+"));
                    if (!(isAlphaValor || isAlphaQuantidade)) {
                        if (("".equals(this.inputPeca.getText())) || ("".equals(this.inputPreco.getText())) || ("".equals(this.inputQtd.getText()))) {
                            this.nomeTela.setText("Erro ao registrar cliente!");
                            this.nomeTela.setVisible(true);
                            System.out.println("1");
                        } else {
                            Peca peca = new Peca(inputPeca.getText());
                            peca.setQnt(Integer.parseInt(inputQtd.getText()));
                            peca.setValor(Double.valueOf(inputPreco.getText()));

                            DAO.getPeca().criar(peca);

                            initialize();

                            inputQtd.setText("");
                            inputPreco.setText("");
                            inputPeca.setText("");
                            nome.setText("");
                            qtd.setText("");
                            preco.setText("");
                            this.nomeTela.setText("Cadastro");

                        }
                    }
                    else{
                        this.nomeTela.setText("Dados inválidos!");
                    }
                }
            }
        }
        catch (Exception e){
                this.nomeTela.setText("Erro ao registrar Peça!");
                this.nomeTela.setVisible(true);
            }

        }

}
