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

public class FaturaController implements Initializable {

    @FXML
    private GridPane gridContainer;

    @FXML
    private Button home;

    @FXML
    private Button sair;

    @FXML
    private TextField inputOrdemId;

    @FXML
    private Label nomeTela;

    @FXML
    private Label nomeTela1;

    @FXML
    private Button salvarCadastro;


    @FXML
    private ChoiceBox<String> inputTipoPagamento;


    @FXML
    private Button salvarPagamento;

    @FXML
    private VBox telaPagamento;

    @FXML
    private TextField inputValor;

    @FXML
    private VBox tela;

    private Mylistener mylistener;

    @FXML
    private Label valorPago;

    @FXML
    private Label valorTotal;

    @FXML
    private TableView<Pagamento> tabelaPagamentos;

    @FXML
    private TableView<Servico> tabelaServicos;

    private List<Fatura> faturas = new ArrayList<>();

    private Fatura fatura;

    @FXML
    private HBox verFatura;

    @FXML
    private HBox verCardFaturas;

    @FXML
    private TableColumn<Servico, String> descricaoTabela;

    @FXML
    private TableColumn<Pagamento, String> tipoPagamentoTabela;

    @FXML
    private TableColumn<Servico, CategoriaServico> tipoServicoTabela;

    @FXML
    private TableColumn<Pagamento, Integer> valorPagamentoTabela;

    @FXML
    private TableColumn<Servico, Integer> valorServicoTabela;

    private ObservableList<Servico> servicos = FXCollections.observableArrayList();

    private ObservableList<Pagamento> pagamentos = FXCollections.observableArrayList();

    public void preencherTabelas(){
        this.valorPago.setText(String.valueOf(this.fatura.getValorPago()));
        this.valorTotal.setText(String.valueOf(this.fatura.getValorTotal()));
        this.servicos.clear();
        List<Servico> servicos1 = new ArrayList<>();
        for(int i = 0; i < DAO.getOrdem().buscarPorId(this.fatura.getOrdemId()).getServicos().size(); i++){
            servicos1.add(DAO.getOrdem().buscarPorId(this.fatura.getOrdemId()).getServicos().get(i));
        }
        this.servicos.addAll(servicos1);

        descricaoTabela.setCellValueFactory(new PropertyValueFactory<Servico, String>("descricao"));
        valorServicoTabela.setCellValueFactory(new PropertyValueFactory<Servico, Integer>("valor"));
        tipoServicoTabela.setCellValueFactory(new PropertyValueFactory<Servico, CategoriaServico>("categoria"));

        this.tabelaServicos.setItems(servicos);

        this.pagamentos.clear();
        List<Pagamento> pagamentos1 = new ArrayList<>();
        for(int i = 0; i < this.fatura.getPagamentos().size(); i++){
            pagamentos1.add(this.fatura.getPagamentos().get(i));
        }
        this.pagamentos.addAll(pagamentos1);

        tipoPagamentoTabela.setCellValueFactory(new PropertyValueFactory<Pagamento, String>("tipoPagamento"));
        valorPagamentoTabela.setCellValueFactory(new PropertyValueFactory<Pagamento, Integer>("valor"));

        this.tabelaPagamentos.setItems(pagamentos);
    }

    public void setChosenFatura(Fatura fatura){
        this.fatura = fatura;
        inputOrdemId.setText(String.valueOf(fatura.getOrdemId()));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.inputTipoPagamento.getItems().addAll("Dinheiro", "Cartão", "Pix", "Transferência", "Outro");
        this.nomeTela.setText("Cadastro");
        initialize();

    }

    public void initialize(){

        gridContainer.getChildren().clear();
        faturas.clear();
        faturas.addAll(getData());
        if(faturas.size()>0){
            mylistener = new Mylistener() {
                @Override
                public void onClickListener(Object fatura) {

                    Fatura fatura1 = (Fatura) fatura;
                    setChosenFatura(fatura1);
                }
            };
        }
        try {

            int linha = 1;
            int coluna = 0;

            for (int i = 0; i < faturas.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("cardFatura.fxml"));
                VBox card = fxmlLoader.load();

                CardFaturaController cardFaturaController = fxmlLoader.getController();
                cardFaturaController.setData(faturas.get(i), mylistener);

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

    private List<Fatura> getData(){
        List<Ordem> ordens = DAO.getOrdem().getOrdens();
        List<Fatura> faturas = new ArrayList<>();
        for (Ordem ordem:ordens) {
            if(ordem.getFatura() != null && !(faturas.contains(ordem.getFatura()))){
                faturas.add(ordem.getFatura());
            }
        }
        return faturas;
    }

    @FXML
    void adicionarPagamentoOnAction(ActionEvent event) {
        this.verFatura.setVisible(false);
        this.verCardFaturas.setVisible(true);
        this.telaPagamento.setVisible(true);
        this.tela.setVisible(false);
    }

    @FXML
    void cadastrarFaturaOnAction(ActionEvent event) {
        this.verFatura.setVisible(false);
        this.verCardFaturas.setVisible(true);
        this.telaPagamento.setVisible(false);
        this.tela.setVisible(true);
    }

    @FXML
    void salvarCadastroOnAction(ActionEvent event) {
        try{
            if(!(this.inputOrdemId.getText().equals(""))){
                if(DAO.getOrdem().buscarPorId(Integer.parseInt(this.inputOrdemId.getText())) != null){
                    if(DAO.getOrdem().buscarPorId(Integer.parseInt(this.inputOrdemId.getText())).getStatus().toString().equals("PAGAMENTO")){
                        Fatura fatura = new Fatura(Integer.parseInt(inputOrdemId.getText()));
                        double valor = 0;
                        for (Servico servico: DAO.getOrdem().buscarPorId(Integer.parseInt(this.inputOrdemId.getText())).getServicos() ){
                            valor += servico.getValor();
                        }
                        fatura.setValorTotal(valor);
                        Ordem ordem = DAO.getOrdem().buscarPorId(Integer.parseInt(inputOrdemId.getText()));
                        ordem.setFatura(fatura);
                        DAO.getOrdem().atualizar(ordem);
                        initialize();
                    }else{
                        this.nomeTela.setText("O Status dessa Ordem não permite criar uma fatura!");
                    }

                }else{
                    this.nomeTela.setText("Essa Ordem não existe!");
                }


            }else{
                this.nomeTela.setText("Preencha o campo obrigatório!");
            }
        }catch (Exception e){
            this.nomeTela.setText("Só pode ser número!");
        }

    }

    @FXML
    void salvarPagamentoOnAction(ActionEvent event) {
        try {
            if(!(this.inputValor.getText().equals("")) && !(this.inputTipoPagamento.getValue().equals(""))){

                    if (Integer.parseInt(this.inputValor.getText()) > 0) {
                        if (Double.parseDouble(this.inputValor.getText()) <= this.fatura.getValorTotal() - this.fatura.getValorPago()) {
                            Pagamento pagamento = new Pagamento(this.inputTipoPagamento.getValue(), Double.parseDouble(this.inputValor.getText()), this.fatura);
                            List<Pagamento> pagamentos = this.fatura.getPagamentos();
                            pagamentos.add(pagamento);
                            this.fatura.setPagamentos(pagamentos);
                            Ordem ordem = DAO.getOrdem().buscarPorId(this.fatura.getOrdemId());
                            this.fatura.setValorPago(this.fatura.getValorPago()+Double.parseDouble(this.inputValor.getText()));
                            ordem.setFatura(this.fatura);
                            DAO.getOrdem().atualizar(ordem);
                            initialize();
                        } else {
                            this.nomeTela1.setText("Esse valor é maior do que o que você deve!");
                        }
                    } else {
                     this.nomeTela1.setText("Os valores tem que ser maiores que zero!");
                    }

            }else{
                this.nomeTela1.setText("Preencha os campos obrigatórios!");
            }
        }catch (Exception e){
            this.nomeTela1.setText("Só pode ser número!");
        }

    }

    @FXML
    void visualizarFaturaOnAction(ActionEvent event) {
        verCardFaturas.setVisible(false);
        verFatura.setVisible(true);
        preencherTabelas();
    }


    @FXML
    void clientesOnAction(ActionEvent event) {
        this.verFatura.setVisible(false);
        this.verCardFaturas.setVisible(true);
        Main.telaScreen("clientes");
    }

    @FXML
    void faturaOnAction(ActionEvent event) {
        this.verFatura.setVisible(false);
        this.verCardFaturas.setVisible(true);
         Main.telaScreen("fatura");
    }

    @FXML
    void homeOnAction(ActionEvent event) {
        this.verFatura.setVisible(false);
        this.verCardFaturas.setVisible(true);
        Main.telaScreen("paginaprincipal");
    }

    @FXML
    void onMouseEntered(MouseEvent event) {

    }

    @FXML
    void ordemOnAction(ActionEvent event) {
        this.verFatura.setVisible(false);
        this.verCardFaturas.setVisible(true);
        Main.telaScreen("ordens");
    }

    @FXML
    void estoqueOnAction(ActionEvent event) {
        this.verFatura.setVisible(false);
        this.verCardFaturas.setVisible(true);
        Main.telaScreen("estoque");
    }

    @FXML
    void sairOnAction(ActionEvent event) {
        this.verFatura.setVisible(false);
        this.verCardFaturas.setVisible(true);
        DAO.getTecnico().setTecnicoLogado(null);
        Main.telaScreen("login");
    }

}
