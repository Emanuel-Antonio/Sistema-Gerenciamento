package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Mylistener3;
import com.example.sistemaparagerenciamento.model.Servico;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CardServicoController {

    @FXML
    private ImageView img;

    private Mylistener3 mylistener3;

    private Servico servico;

    @FXML
    private Label labelCategoria;

    @FXML
    private Label labelOrdemId;

    @FXML
    private Label labelValor;

    @FXML
    void click(MouseEvent event) {
        mylistener3.onClickListener3(servico);
    }

    public void setData(Servico servico, Mylistener3 mylistener3){
        this.servico = servico;
        this.mylistener3 = mylistener3;
        this.labelCategoria.setText(servico.getCategoria().toString());
        this.labelValor.setText(String.valueOf(servico.getValor()));
        this.labelOrdemId.setText(String.valueOf(servico.getOrdemId()));
    }

}
