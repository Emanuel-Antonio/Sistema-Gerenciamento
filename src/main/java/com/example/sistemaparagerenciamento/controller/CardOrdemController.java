package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Mylistener2;
import com.example.sistemaparagerenciamento.model.Ordem;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CardOrdemController {

    @FXML
    private ImageView img;

    private Mylistener2 mylistener2;

    private Ordem ordem;

    @FXML
    void click(MouseEvent event) {
        mylistener2.onClickListener2(ordem);
    }

    public void setData(Ordem ordem, Mylistener2 mylistener2){
        this.ordem = ordem;
        this.mylistener2 = mylistener2;

    }

}
