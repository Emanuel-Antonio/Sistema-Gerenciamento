package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.dao.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
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
                if (DAO.getTecnico().getTecnicos().get(i).getEmail().equals(email.getText()) && DAO.getTecnico().getTecnicos().get(i).getSenha().equals(senha.getText())) {
                    DAO.getTecnico().setTecnicoLogado(DAO.getTecnico().getTecnicos().get(i));
                    Main.telaScreen("paginaprincipal");
                }
            }
            if(DAO.getTecnico().getTecnicoLogado() == null && !("".equals(email.getText())) && !("".equals(senha.getText())))
                mensagem.setText("Dados Inválidos!!");
        }
        catch (Exception e) {
            mensagem.setText("Erro ao logar Usuário!");
            mensagem.setVisible(true);
        }
    }




    @FXML
    void registrar(ActionEvent event) {
        Main.telaScreen("registro");
    }
}
