package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Mylistener3;
import com.example.sistemaparagerenciamento.model.Servico;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CardServicoController {

    @FXML
    private Label categoria;

    @FXML
    private Label ordemId;

    @FXML
    private Label servicoId;

    @FXML
    private Label valor;

    @FXML
    private ImageView img;

    private Mylistener3 mylistener3;

    private Servico servico;

    @FXML
    void click(MouseEvent event) {
        mylistener3.onClickListener3(servico);
    }

    public void setData(Servico servico, Mylistener3 mylistener3){
        this.servico = servico;
        this.mylistener3 = mylistener3;
        this.servicoId.setText(String.valueOf(servico.getServicoId()));
        this.ordemId.setText(String.valueOf(servico.getOrdemId()));
        this.categoria.setText(servico.getCategoria().toString());
        this.valor.setText(String.valueOf(servico.getValor()));

    }

}
