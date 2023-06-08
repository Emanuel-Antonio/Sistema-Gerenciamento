package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Mylistener1;
import com.example.sistemaparagerenciamento.Mylistener3;
import com.example.sistemaparagerenciamento.model.Cliente;
import com.example.sistemaparagerenciamento.model.Servico;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CardServicoController {

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
    }

}
