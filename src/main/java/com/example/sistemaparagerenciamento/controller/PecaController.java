package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Mylistener;
import com.example.sistemaparagerenciamento.model.Peca;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

public class PecaController {

    @FXML
    private ImageView img;

    @FXML
    private Label pecas;

    @FXML
    private Label quantidade;

    @FXML
    private Label nome;

    @FXML
    private Label qtd;

    private Peca peca;

    private Mylistener mylistener;

    @FXML
    private void click(MouseEvent mouseEvent){
        mylistener.onClickListener(peca);
    }

    public void setData(Peca peca, Mylistener mylistener){
        this.peca = peca;
        this.mylistener = mylistener;
        qtd.setText(String.valueOf(peca.getQnt()));
        nome.setText(peca.getNome());
    }

}
