package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.model.Peca;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.awt.event.MouseEvent;

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

    public void setData(Peca peca){
        this.peca = peca;
        qtd.setText(String.valueOf(peca.getQnt()));
        nome.setText(peca.getNome());
    }

}
