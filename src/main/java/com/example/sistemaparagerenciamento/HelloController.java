package com.example.sistemaparagerenciamento;

import com.example.sistemaparagerenciamento.dao.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.paint.Color.RED;

public class HelloController{
    @FXML
    private TextField email;

    @FXML
    private PasswordField senha;

    @FXML
    private Label mensagem;

    @FXML
    void entrar(ActionEvent event) {
        try {
            for (int i = 0; i < DAO.getTecnico().getTecnicos().size(); i++) {
                //Aqui verifica se o técnico foi encontrado
                if (DAO.getTecnico().getTecnicos().get(i).getEmail().equals(email) && DAO.getTecnico().getTecnicos().get(i).getSenha().equals(senha)) {
                    DAO.getTecnico().setTecnicoLogado(DAO.getTecnico().getTecnicos().get(i));
                }
            }
            if(DAO.getTecnico().getTecnicoLogado() == null)
                mensagem.setText("Usuário não cadastrado!");
        }
        catch (Exception e) {
            mensagem.setText("Erro ao logar Usuário!");
        }
    }




    @FXML
    protected void registrar(ActionEvent event) {
        System.out.println("passou");
        HelloApplication.telaScreen("registro");
    }
}
