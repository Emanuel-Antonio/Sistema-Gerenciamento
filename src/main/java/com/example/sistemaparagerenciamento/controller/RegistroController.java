package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.Main;
import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Tecnico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistroController {

    @FXML
    private TextField email;

    @FXML
    private Label erroRegistrar;

    @FXML
    private TextField nome;

    @FXML
    private PasswordField senha;

    @FXML
    void registrar(ActionEvent event) {

        try {
            for (int i = 0; i < DAO.getTecnico().getTecnicos().size(); i++) {
                //Aqui eu verifico se o técnico já existe

                if (DAO.getTecnico().getTecnicos().get(i).getEmail().equals(this.email.getText())) {
                    this.erroRegistrar.setText("Erro ao registrar usuário!");
                    this.erroRegistrar.setVisible(true);
                    return;
                }
            }
            Tecnico tecnico = new Tecnico(this.email.getText(), this.nome.getText(), this.senha.getText());
            if (DAO.getTecnico().getTecnicos().size() == 0) {
                //Aqui eu atribuo o cargo de administrador a técnico
                tecnico.setAdm(true);
            }
            int ii = this.email.getText().indexOf("@");
            String s = "";
            //Aqui eu cadastro o técnico através do DAO de Tecnico
            boolean isNumericNome = (nome != null && nome.getText().matches("[0-9]+"));
            if (isNumericNome) {
                this.erroRegistrar.setText("Dados inválidos");
                this.erroRegistrar.setVisible(true);
            } else {
                if (("".equals(this.email.getText())) || ("".equals(this.nome.getText())) || ("".equals(this.senha.getText()))) {
                    this.erroRegistrar.setText("Erro ao registrar técnico!");
                    this.erroRegistrar.setVisible(true);
                } else if (-1 == ii || email.getText().length() < 6) {
                    this.erroRegistrar.setText("Email Inválido!");
                    this.erroRegistrar.setVisible(true);
                } else {
                    DAO.getTecnico().criar(tecnico);
                    Main.telaScreen("login");
                    this.email.setText("");
                    this.senha.setText("");
                    this.nome.setText("");
                    this.erroRegistrar.setVisible(false);

                }

            }
        }
        catch (Exception TecnicoInvalido){
            this.erroRegistrar.setText("Erro ao registrar usuário!");
            this.erroRegistrar.setVisible(true);
        }
    }
    @FXML
    void voltar(ActionEvent event) {
        Main.telaScreen("login");
        this.email.setText("");
        this.senha.setText("");
        this.nome.setText("");
        this.erroRegistrar.setVisible(false);
    }

}
