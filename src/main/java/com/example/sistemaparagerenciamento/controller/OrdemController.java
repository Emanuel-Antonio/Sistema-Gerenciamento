package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.Mylistener;
import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.*;

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

    private Mylistener mylistener2;

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
        this.nomeTela.setTextFill(rgb(255, 255, 255));
    }

    @FXML
    void homeOnAction(ActionEvent event) {
        Main.telaScreen("paginaprincipal");
        this.nomeTela.setTextFill(rgb(255, 255, 255));
    }

    @FXML
    void sairOnAction(ActionEvent event) {
        DAO.getTecnico().setTecnicoLogado(null);
        Main.telaScreen("login");
        this.nomeTela.setTextFill(rgb(255, 255, 255));
    }

    @FXML
    void estoqueOnAction(ActionEvent event) {
        Main.telaScreen("estoque");
        this.nomeTela.setTextFill(rgb(255, 255, 255));
    }
    @FXML
    void servicoOnAction(ActionEvent event) {
        Main.telaScreen("servico");
        this.nomeTela.setTextFill(rgb(255, 255, 255));
    }

    @FXML
    void faturaOnAction(ActionEvent event) {
        Main.telaScreen("fatura");
        this.nomeTela.setTextFill(rgb(255, 255, 255));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.nomeTela.setText("Cadastro");
        this.nomeTela.setTextFill(rgb(255,255,255));
        this.inputStatus.getItems().addAll("PAGAMENTO", "FECHADA", "CANCELADA", "ANDAMENTO");
        this.inputAvaliacao.getItems().addAll("","Ótimo", "Bom", "Médio", "Ruim", "Péssimo");
        initialize();

    }

    public void initialize(){

        gridContainer.getChildren().clear();
        ordens.clear();
        ordens.addAll(getData());
        if(ordens.size()>0){
            mylistener2 = new Mylistener() {
                @Override
                public void onClickListener(Object ordem) {
                    Ordem ordem1 = (Ordem) ordem;
                    setChosenOrdem(ordem1);
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

    public void setChosenOrdem(Ordem ordem){
        this.inputNomeCliente.setText(ordem.getNomeCliente());
        this.inputIdCliente.setText(String.valueOf(ordem.getClienteId()));
        this.inputAvaliacao.setValue(ordem.getAvaliacaoFinal());
        this.inputStatus.setValue(String.valueOf(ordem.getStatus()));
        this.inputIdOrdem.setText(String.valueOf(ordem.getOrdemId()));
    }

    private List<Ordem> getData(){
        return DAO.getOrdem().getOrdens();
    }

    private boolean existeServicoId(String inputIdServico){
        if(isNumeric(inputIdServico)) {
            for (int i = 0; i < DAO.getServico().getServicos().size(); i++) {
                if (DAO.getServico().getServicos().get(i).getServicoId() == Integer.parseInt(inputIdServico)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean existeClienteId(String inputIdCliente){
        if(isNumeric(inputIdCliente)) {
            for (int i = 0; i < DAO.getCliente().getClientes().size(); i++) {
                if (DAO.getCliente().getClientes().get(i).getClienteId() == Integer.parseInt(inputIdCliente)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean isNumeric(String id){
        boolean isNumericId = (id != "" && id.matches("[0-9]+"));
        return isNumericId;
    }

    @FXML
    void salvarAtualizacaoOnAction(ActionEvent event) {
        try {
            if(DAO.getOrdem().buscarPorId(Integer.parseInt(this.inputIdOrdem.getText())).getTecnicoId() == -1 || DAO.getOrdem().buscarPorId(Integer.parseInt(this.inputIdOrdem.getText())).getTecnicoId() == DAO.getTecnico().getTecnicoLogado().getTecnicoId() || DAO.getTecnico().getTecnicoLogado().isAdm()) {
                this.inputIdCliente.setDisable(true);
                Ordem ordem = DAO.getOrdem().getOrdens().get(Integer.parseInt(this.inputIdOrdem.getText()));

                if (this.inputStatus.getValue().equals("ANDAMENTO")) {
                    ordem.setStatus(StatusOrdem.ANDAMENTO);
                } else if (this.inputStatus.getValue().equals("FECHADA")) {
                    ordem.setStatus(StatusOrdem.FECHADA);
                    Tecnico tecnico = DAO.getTecnico().getTecnicoLogado();
                    tecnico.setOrdem(null);
                    DAO.getTecnico().atualizar(tecnico);
                } else if (this.inputStatus.getValue().equals("CANCELADA")) {
                    ordem.setStatus(StatusOrdem.CANCELADA);
                } else if (this.inputStatus.getValue().equals("PAGAMENTO")) {
                    ordem.setStatus(StatusOrdem.PAGAMENTO);
                }

                if (this.inputStatus.getValue().equals("ANDAMENTO") && existeServicoId(inputIdServico.getText()) && DAO.getServico().buscarPorId(Integer.parseInt(inputIdServico.getText())).getOrdemId() == -1) {
                    if (DAO.getServico().buscarPorId(Integer.parseInt(inputIdServico.getText())).getOrdemId() == -1) {
                        List<Servico> servicos = DAO.getOrdem().getOrdens().get(Integer.parseInt(this.inputIdOrdem.getText())).getServicos();
                        servicos.add(DAO.getServico().buscarPorId(Integer.parseInt(this.inputIdServico.getText())));

                        ordem.setServicos(servicos);
                        Servico servico = DAO.getServico().buscarPorId(Integer.parseInt(inputIdServico.getText()));
                        servico.setOrdemId(DAO.getOrdem().buscarPorId(Integer.parseInt(this.inputIdOrdem.getText())).getOrdemId());
                        DAO.getServico().atualizar(servico);

                    }
                } else if (this.inputStatus.getValue().equals("FECHADA")) {
                    if (this.inputAvaliacao.getValue() != null) {
                        ordem.setAvaliacaoFinal(this.inputAvaliacao.getValue());
                    }
                } else {
                    this.nomeTela.setTextFill(rgb(255, 0, 0));
                    this.nomeTela.setText("Dados Inválidos!");
                }
                DAO.getOrdem().atualizar(ordem);
                this.nomeTela.setText("Atualizar");
                this.nomeTela.setTextFill(rgb(255,255,255));
                initialize();
                this.inputIdOrdem.setText("");
                this.inputIdCliente.setText("");
                this.inputAvaliacao.setValue("");
                this.inputStatus.setValue("");
                this.inputIdServico.setText("");
                this.inputNomeCliente.setText("");
            }else{
                this.nomeTela.setText("Você não tem permissão para realizar essa ação!");
                this.nomeTela.setTextFill(rgb(255,0,0));
                this.nomeTela.setVisible(true);
            }
        }catch (Exception e){

        }
    }

    @FXML
    void salvarCadastroOnAction(ActionEvent event) {
        try {
            if (existeClienteId(inputIdCliente.getText()) && existeServicoId(inputIdServico.getText()) && this.inputStatus.getValue() != null && DAO.getServico().buscarPorId(Integer.parseInt(inputIdServico.getText())).getOrdemId() == -1) {
                Ordem ordem = new Ordem(Integer.parseInt(inputIdCliente.getText()));
                List<Servico> servicos = new ArrayList<>();
                servicos.add(DAO.getServico().buscarPorId(Integer.parseInt(inputIdServico.getText())));
                ordem.setServicos(servicos);

                if(this.inputStatus.getValue().equals("ANDAMENTO")){
                    ordem.setStatus(StatusOrdem.ANDAMENTO);
                }else if(this.inputStatus.getValue().equals("FECHADA")){
                    ordem.setStatus(StatusOrdem.FECHADA);
                }else if(this.inputStatus.getValue().equals("CANCELADA")){
                    ordem.setStatus(StatusOrdem.CANCELADA);
                }else if(this.inputStatus.getValue().equals("PAGAMENTO")){
                    ordem.setStatus(StatusOrdem.PAGAMENTO);
                }
                DAO.getOrdem().criar(ordem);

                Servico servico = DAO.getServico().buscarPorId(Integer.parseInt(inputIdServico.getText()));
                servico.setOrdemId(ordem.getOrdemId());
                DAO.getServico().atualizar(servico);
                this.nomeTela.setTextFill(rgb(255, 255, 255));
                this.nomeTela.setText("Cadastro");
                initialize();
                this.inputIdOrdem.setText("");
                this.inputIdCliente.setText("");
                this.inputAvaliacao.setValue("");
                this.inputStatus.setValue("");
                this.inputIdServico.setText("");
                this.inputNomeCliente.setText("");
            } else {
                this.nomeTela.setTextFill(rgb(255, 0, 0));
                this.nomeTela.setText("Dados Inválidos!");
            }

        } catch (Exception e) {

        }
    }
    @FXML
    void excluirOnAction(ActionEvent event) {
        if(DAO.getOrdem().buscarPorId(Integer.parseInt(this.inputIdOrdem.getText())).getTecnicoId() == -1 || DAO.getOrdem().buscarPorId(Integer.parseInt(this.inputIdOrdem.getText())).getTecnicoId() == DAO.getTecnico().getTecnicoLogado().getTecnicoId() || DAO.getTecnico().getTecnicoLogado().isAdm()){
            for (int i = 0; i < DAO.getServico().getServicos().size(); i++) {
                if (DAO.getServico().getServicos().get(i).getOrdemId() == Integer.parseInt(this.inputIdOrdem.getText())) {
                    Servico servico = DAO.getServico().getServicos().get(i);
                    servico.setOrdemId(-1);
                    DAO.getServico().atualizar(servico);
                }
            }
            if(DAO.getOrdem().buscarPorId(Integer.parseInt(this.inputIdOrdem.getText())).getTecnicoId() != -1){
                Tecnico tecnico = DAO.getTecnico().buscarPorId(Integer.parseInt(this.inputIdOrdem.getText()));
                tecnico.setOrdem(null);
                DAO.getTecnico().atualizar(tecnico);
            }
            for(int i = 0; i < DAO.getOrdem().buscarPorId(Integer.parseInt(this.inputIdOrdem.getText())).getServicos().size(); i++){
                DAO.getServico().deletar(DAO.getOrdem().buscarPorId(Integer.parseInt(this.inputIdOrdem.getText())).getServicos().get(i));
            }
            DAO.getOrdem().deletar(Integer.parseInt(this.inputIdOrdem.getText()));

            this.nomeTela.setTextFill(rgb(255, 255, 255));
            this.inputIdOrdem.setText("");
            this.inputIdCliente.setText("");
            this.inputAvaliacao.setValue("");
            this.inputStatus.setValue("");
            this.inputIdServico.setText("");
            this.inputNomeCliente.setText("");
        }else {
            this.nomeTela.setText("Você não tem permissão para realizar essa ação!");
            this.nomeTela.setTextFill(rgb(255,0,0));
            this.nomeTela.setVisible(true);
        }
        initialize();
    }

    @FXML
    void atualizarOnAction(ActionEvent event) {
        this.nomeTela.setTextFill(rgb(255, 255, 255));
        this.inputIdCliente.setDisable(true);
        this.salvarAtualizacao.setVisible(true);
        this.salvarCadastro.setVisible(false);
        this.nomeTela.setText("Atualizar");
    }

    @FXML
    void cadastrarOnAction(ActionEvent event) {
        this.nomeTela.setTextFill(rgb(255, 255, 255));
        this.inputIdCliente.setDisable(false);
        this.salvarCadastro.setVisible(true);
        this.salvarAtualizacao.setVisible(false);
        this.inputIdServico.setDisable(false);
        this.inputIdOrdem.setText("");
        this.inputIdCliente.setText("");
        this.inputAvaliacao.setValue("");
        this.inputStatus.setValue("");
        this.inputIdServico.setText("");
        this.inputNomeCliente.setText("");
        this.nomeTela.setText("Cadastrar");
    }

    @FXML
    void onMouseMoved(MouseEvent event) {
        try {
            if (this.inputStatus.getValue().equals("ANDAMENTO") || this.inputStatus.getValue().equals("")) {
                this.inputIdServico.setDisable(false);
            } else {
                this.inputIdServico.setDisable(true);
            }
            if (this.inputStatus.getValue().equals("FECHADA")) {
                this.inputAvaliacao.setDisable(false);
            } else {
                this.inputAvaliacao.setDisable(true);
            }
        }catch (Exception e){

        }
    }
    @FXML
    void onMouseEntered(MouseEvent event) {
        initialize();
    }
}
