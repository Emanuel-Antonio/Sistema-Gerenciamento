package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.Mylistener;
import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.CategoriaServico;
import com.example.sistemaparagerenciamento.model.Peca;
import com.example.sistemaparagerenciamento.model.Servico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.rgb;

public class ServicosController implements Initializable {

    @FXML
    private Button estoque;

    @FXML
    private Button home;

    @FXML
    private Button sair;

    @FXML
    private GridPane gridContainer;

    private Mylistener mylistener3;

    private List<Servico> servicos = new ArrayList<>();

    @FXML
    private ChoiceBox<String> inputCategoria;

    @FXML
    private TextField inputOrdemId;

    @FXML
    private TextField inputValor;

    @FXML
    private Label nomeTela;

    @FXML
    private VBox tela;

    @FXML
    private TextArea inputDescricao;

    @FXML
    private TextField inputServicoId;

    @FXML
    private TextField inputPeca;

    @FXML
    private Button salvarCadastro;

    @FXML
    void voltarOnAction(ActionEvent event) {
        Main.telaScreen("ordens");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.inputDescricao.setWrapText(true);
        this.nomeTela.setText("Cadastro");
        this.inputCategoria.getItems().addAll("LIMPEZA", "MONTAGEM_INSTALACAO", "FORMATACAO_INSTALACAO");
        initialize();

    }

    public void initialize(){

        gridContainer.getChildren().clear();
        servicos.clear();
        servicos.addAll(getData());
        if(servicos.size()>0){
            mylistener3 = new Mylistener() {
                @Override
                public void onClickListener(Object servico) {
                    Servico servico1 = (Servico) servico;
                    setChosenServico(servico1);
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

    public void setChosenServico(Servico servico){
        this.inputCategoria.setValue(servico.getCategoria().toString());
        this.inputOrdemId.setText(String.valueOf(servico.getOrdemId()));
        this.inputValor.setText(String.valueOf(servico.getValor()));
        this.inputServicoId.setText(String.valueOf(servico.getServicoId()));
        this.inputDescricao.setText(servico.getDescricao());
        try{
            this.inputPeca.setText(servico.getPecas().get(0).getNome());
        }catch (Exception e){

        }
    }

    private List<Servico> getData(){
        return DAO.getServico().getServicos();
    }

    @FXML
    void excluirOnAction(ActionEvent event) {
        try{
            if(DAO.getServico().buscarPorId(Integer.parseInt(this.inputServicoId.getText())).getOrdemId() != -1) {
                Peca peca = DAO.getPeca().buscarPorNome(inputPeca.getText());
                peca.setQnt(DAO.getPeca().buscarPorNome(inputPeca.getText()).getQnt() + 1);

                DAO.getPeca().atualizar(peca);

                DAO.getServico().deletar(DAO.getServico().buscarPorId(Integer.parseInt(inputServicoId.getText())));
                this.inputServicoId.setText("");
                this.inputDescricao.setText("");
                this.inputCategoria.setValue("");
                this.inputOrdemId.setText("");
                this.inputValor.setText("");
                this.inputPeca.setText("");

            }else{
                this.nomeTela.setTextFill(rgb(255,0,0));
                this.nomeTela.setText("Esse serviço não pode ser excluido!");
            }
            initialize();
        }
        catch(Exception e){

        }

    }

    @FXML
    void salvarCadastroOnAction(ActionEvent event) {
        boolean pecaExiste = false;
        for(int i =0; i < DAO.getPeca().getPecas().size(); i++){
            if(DAO.getPeca().getPecas().get(i).getNome().equals(this.inputPeca.getText())){
                pecaExiste = true;
            }
        }
            if(this.inputCategoria.getValue()!=null && !(this.inputDescricao.getText().equals(""))){
                if(this.inputPeca.getText().equals("") || DAO.getPeca().buscarPorNome(inputPeca.getText()).getQnt()>0){
                    boolean isNumericDescricao = (inputDescricao != null && inputDescricao.getText().matches("[0-9]+"));
                    if(!(isNumericDescricao)){
                        CategoriaServico categoriaServico;
                        if(this.inputCategoria.getValue().toString().equals("FORMATACAO_INSTALACAO")) {
                            categoriaServico = CategoriaServico.FORMATACAO_INSTALACAO;
                        }
                        else if(this.inputCategoria.getValue().toString().equals("MONTAGEM_INSTALACAO")) {
                            categoriaServico = CategoriaServico.MONTAGEM_INSTALACAO;
                        }
                        else{
                            categoriaServico = CategoriaServico.LIMPEZA;
                        }
                        Servico servico = new Servico(-1, categoriaServico);

                        try{
                            if(categoriaServico.toString().equals("LIMPEZA")){
                                servico.setValor(70);
                            } else if (categoriaServico.toString().equals("FORMATACAO_INSTALACAO") || categoriaServico.toString().equals("MONTAGEM_INSTALACAO")) {
                                servico.setValor(DAO.getPeca().buscarPorNome(inputPeca.getText()).getValor());
                            }
                        }
                        catch(Exception e){
                        }

                        servico.setDescricao(inputDescricao.getText());

                        try{
                            List<Peca> pecas = new ArrayList<>();
                            pecas.add(DAO.getPeca().buscarPorNome(inputPeca.getText()));
                            servico.setPeca(pecas);

                            Peca peca = new Peca(inputPeca.getText());
                            peca.setQnt(DAO.getPeca().buscarPorNome(inputPeca.getText()).getQnt() - 1);
                            peca.setValor(DAO.getPeca().buscarPorNome(inputPeca.getText()).getValor());

                            DAO.getPeca().atualizar(peca);
                        }
                        catch(Exception e){
                        }

                        if(!(this.inputPeca.getText().equals("")) && !(this.inputCategoria.getValue().toString().equals("LIMPEZA")) || this.inputPeca.getText().equals("") && this.inputCategoria.getValue().toString().equals("LIMPEZA")){
                            if(pecaExiste){
                                DAO.getServico().criar(servico);
                                initialize();
                                this.nomeTela.setText("Cadastro");
                            }
                            else if(!(pecaExiste) && this.inputCategoria.getValue().toString().equals("LIMPEZA")){
                                DAO.getServico().criar(servico);
                                initialize();
                                this.nomeTela.setText("Cadastro");
                            }
                            else{
                                this.nomeTela.setText("Essa peça não existe para ser adicionada");
                            }

                        }
                        else{
                            this.nomeTela.setText("Apenas LIMPEZA não exige o campo peça");
                        }
                    }
                    else{
                        this.nomeTela.setText("A descrição não pode conter só números");
                    }
                }else{
                    this.nomeTela.setText("Não há quantidade dessa peça no estoque");
                }
            }
            else{
                this.nomeTela.setText("Preencha os campos Obrigatórios");
            }
    }

    @FXML
    void onMouseMoved(MouseEvent event) {
        try{
            if(this.inputCategoria.getValue().equals("LIMPEZA")){
                this.inputPeca.setText("");
                this.inputPeca.setDisable(true);
            }
            else{
                this.inputPeca.setDisable(false);
            }
        }
        catch (Exception e){

        }

    }

    @FXML
    void onMouseEntered(MouseEvent event) {
        initialize();
    }
}
