package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Mylistener2;
import com.example.sistemaparagerenciamento.model.Ordem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CardOrdemController {

    @FXML
    private ImageView img;

    private Mylistener2 mylistener2;

    private Ordem ordem;

    @FXML
    private Label avaliacao;

    @FXML
    private Label cliente;

    @FXML
    private Label idCliente;

    @FXML
    private Label idTecnico;
    @FXML
    private Label idOrdem;

    @FXML
    private Label status;

    @FXML
    void click(MouseEvent event) {
        mylistener2.onClickListener2(ordem);
    }

    public void setData(Ordem ordem, Mylistener2 mylistener2){
        this.ordem = ordem;
        this.mylistener2 = mylistener2;
        this.avaliacao.setText(ordem.getAvaliacaoFinal());
        this.cliente.setText(ordem.getNomeCliente());
        this.idOrdem.setText(String.valueOf(ordem.getOrdemId()));
        this.idCliente.setText(String.valueOf(ordem.getClienteId()));
        this.status.setText(String.valueOf(ordem.getStatus()));
        this.idTecnico.setText(String.valueOf(ordem.getTecnicoId()));
    }

}
