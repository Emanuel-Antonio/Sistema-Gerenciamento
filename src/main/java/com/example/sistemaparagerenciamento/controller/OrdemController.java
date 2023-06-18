package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.Mylistener;
import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    private Label data;

    @FXML
    private TableColumn<Servico, String> descricaoTabela;

    @FXML
    private Label endereco;

    @FXML
    private Label nomeCliente;

    @FXML
    private Label nometecnico;

    @FXML
    private TableView<Pagamento> tabelaPagamentos;

    @FXML
    private TableView<Servico> tabelaServicos;

    @FXML
    private Label telefone;

    @FXML
    private TableColumn<Pagamento, String> tipoPagamentoTabela;

    @FXML
    private TableColumn<Servico, CategoriaServico> tipoServicoTabela;

    @FXML
    private TableColumn<Pagamento, Integer> valorPagamentoTabela;

    @FXML
    private Label valorPago;

    @FXML
    private TableColumn<Servico, Integer> valorServicoTabela;

    @FXML
    private Label valorTotal;

    @FXML
    private HBox verRelatorio;

    @FXML
    private HBox verCardOrdens;

    private Ordem ordem;

    @FXML
    private Label avaliacao;

    private ObservableList<Servico> servicos = FXCollections.observableArrayList();

    private ObservableList<Pagamento> pagamentos = FXCollections.observableArrayList();

    public void preencherTabelas(){
        try{
            this.valorPago.setText(String.valueOf(this.ordem.getFatura().getValorPago()));
            this.valorTotal.setText(String.valueOf(this.ordem.getFatura().getValorTotal()));
            this.nometecnico.setText(String.valueOf(DAO.getTecnico().buscarPorId(this.ordem.getTecnicoId())));
            this.nomeCliente.setText(this.ordem.getNomeCliente());
            this.endereco.setText(DAO.getCliente().buscarPorId(this.ordem.getClienteId()).getEndereco());
            this.telefone.setText(DAO.getCliente().buscarPorId(this.ordem.getClienteId()).getTelefone());
            this.avaliacao.setText(this.ordem.getAvaliacaoFinal());
            this.data.setText(this.ordem.getData());
        }catch(Exception e){

        }

        this.servicos.clear();
        List<Servico> servicos1 = new ArrayList<>();
        for(int i = 0; i < DAO.getOrdem().buscarPorId(this.ordem.getOrdemId()).getServicos().size(); i++){
            servicos1.add(this.ordem.getServicos().get(i));
        }
        this.servicos.addAll(servicos1);

        descricaoTabela.setCellValueFactory(new PropertyValueFactory<Servico, String>("descricao"));
        valorServicoTabela.setCellValueFactory(new PropertyValueFactory<Servico, Integer>("valor"));
        tipoServicoTabela.setCellValueFactory(new PropertyValueFactory<Servico, CategoriaServico>("categoria"));

        this.tabelaServicos.setItems(servicos);

        this.pagamentos.clear();
        List<Pagamento> pagamentos1 = new ArrayList<>();
        for(int i = 0; i < this.ordem.getFatura().getPagamentos().size(); i++){
            pagamentos1.add(this.ordem.getFatura().getPagamentos().get(i));
        }
        this.pagamentos.addAll(pagamentos1);

        tipoPagamentoTabela.setCellValueFactory(new PropertyValueFactory<Pagamento, String>("tipoPagamento"));
        valorPagamentoTabela.setCellValueFactory(new PropertyValueFactory<Pagamento, Integer>("valor"));

        this.tabelaPagamentos.setItems(pagamentos);
    }

    @FXML
    void clientesOnAction(ActionEvent event) {
        this.verRelatorio.setVisible(false);
        this.verCardOrdens.setVisible(true);
        Main.telaScreen("clientes");
    }

    @FXML
    void homeOnAction(ActionEvent event) {
        this.verRelatorio.setVisible(false);
        this.verCardOrdens.setVisible(true);
        Main.telaScreen("paginaprincipal");
    }

    @FXML
    void sairOnAction(ActionEvent event) {
        this.verRelatorio.setVisible(false);
        this.verCardOrdens.setVisible(true);
        DAO.getTecnico().setTecnicoLogado(null);
        Main.telaScreen("login");
    }

    @FXML
    void estoqueOnAction(ActionEvent event) {
        this.verRelatorio.setVisible(false);
        this.verCardOrdens.setVisible(true);
        Main.telaScreen("estoque");
    }
    @FXML
    void servicoOnAction(ActionEvent event) {
        this.verRelatorio.setVisible(false);
        this.verCardOrdens.setVisible(true);
        Main.telaScreen("servico");
    }

    @FXML
    void faturaOnAction(ActionEvent event) {
        this.verRelatorio.setVisible(false);
        this.verCardOrdens.setVisible(true);
        Main.telaScreen("fatura");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.nomeTela.setText("Cadastro");
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
        this.ordem = ordem;
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
                Ordem ordem = DAO.getOrdem().buscarPorId((Integer.parseInt(this.inputIdOrdem.getText())));

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
                    this.nomeTela.setText("Dados Inválidos!");
                }
                DAO.getOrdem().atualizar(ordem);
                this.nomeTela.setText("Atualizar");
                initialize();
                this.inputIdOrdem.setText("");
                this.inputIdCliente.setText("");
                this.inputAvaliacao.setValue("");
                this.inputStatus.setValue("");
                this.inputIdServico.setText("");
                this.inputNomeCliente.setText("");
            }else{
                this.nomeTela.setText("Você não tem permissão para realizar essa ação!");
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
                this.nomeTela.setText("Cadastro");
                initialize();
                this.inputIdOrdem.setText("");
                this.inputIdCliente.setText("");
                this.inputAvaliacao.setValue("");
                this.inputStatus.setValue("");
                this.inputIdServico.setText("");
                this.inputNomeCliente.setText("");
            } else {
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
                    initialize();

                }
            }
            if(DAO.getOrdem().buscarPorId(Integer.parseInt(this.inputIdOrdem.getText())).getTecnicoId() != -1){
                Tecnico tecnico = DAO.getTecnico().buscarPorId(DAO.getOrdem().buscarPorId(Integer.parseInt(this.inputIdOrdem.getText())).getTecnicoId());
                tecnico.setOrdem(null);
                DAO.getTecnico().atualizar(tecnico);
                initialize();

            }
            for(int i = 0; i < DAO.getOrdem().buscarPorId(Integer.parseInt(this.inputIdOrdem.getText())).getServicos().size(); i++){
                DAO.getServico().deletar(DAO.getOrdem().buscarPorId(Integer.parseInt(this.inputIdOrdem.getText())).getServicos().get(i));
            }
            DAO.getOrdem().deletar(Integer.parseInt(this.inputIdOrdem.getText()));
            initialize();

            this.inputIdOrdem.setText("");
            this.inputIdCliente.setText("");
            this.inputAvaliacao.setValue("");
            this.inputStatus.setValue("");
            this.inputIdServico.setText("");
            this.inputNomeCliente.setText("");
        }else {
            this.nomeTela.setText("Você não tem permissão para realizar essa ação!");
            this.nomeTela.setVisible(true);
            this.verRelatorio.setVisible(false);
            this.verCardOrdens.setVisible(true);
        }
    }

    @FXML
    void atualizarOnAction(ActionEvent event) {
        this.inputIdCliente.setDisable(true);
        this.salvarAtualizacao.setVisible(true);
        this.salvarCadastro.setVisible(false);
        this.nomeTela.setText("Atualizar");
        this.verRelatorio.setVisible(false);
        this.verCardOrdens.setVisible(true);
    }

    @FXML
    void cadastrarOnAction(ActionEvent event) {
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
        this.verRelatorio.setVisible(false);
        this.verCardOrdens.setVisible(true);
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
    void gerarRelatorioOnAction(ActionEvent event) {
        if(DAO.getOrdem().buscarPorId(Integer.parseInt(this.inputIdOrdem.getText())).getTecnicoId() == DAO.getTecnico().getTecnicoLogado().getTecnicoId() || DAO.getTecnico().getTecnicoLogado().isAdm()){
            this.verRelatorio.setVisible(true);
            this.verCardOrdens.setVisible(false);
            preencherTabelas();
        }
        else{
            this.nomeTela.setText("Você não tem permissão para realizar essa ação");
        }

        this.inputIdOrdem.setText("");
        this.inputIdCliente.setText("");
        this.inputAvaliacao.setValue("");
        this.inputStatus.setValue("");
        this.inputIdServico.setText("");
        this.inputNomeCliente.setText("");
    }

    @FXML
    void onMouseEntered(MouseEvent event) {
        initialize();
    }
}
