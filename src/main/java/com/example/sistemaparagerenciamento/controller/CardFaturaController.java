package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Mylistener;
import com.example.sistemaparagerenciamento.model.Fatura;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CardFaturaController {

    @FXML
    private Label idOrdem;

    @FXML
    private ImageView img;

    @FXML
    private Label valorPago;

    @FXML
    private Label valorTotal;

    private Mylistener mylistener;

    private Fatura fatura;

    @FXML
    void click(MouseEvent event) {
        mylistener.onClickListener(fatura);
    }

    public void setData(Fatura fatura, Mylistener mylistener){
        this.fatura = fatura;
        this.mylistener = mylistener;
        idOrdem.setText(String.valueOf(fatura.getOrdemId()));
        valorPago.setText(String.valueOf(fatura.getValorPago()));
        valorTotal.setText(String.valueOf(fatura.getValorTotal()));
    }

}