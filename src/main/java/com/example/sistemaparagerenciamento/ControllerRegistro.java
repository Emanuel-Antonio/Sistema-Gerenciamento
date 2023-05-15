package com.example.sistemaparagerenciamento;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.Tecnico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControllerRegistro {

    @FXML
    private TextField email;

    @FXML
    private Label erroRegistar;

    @FXML
    private TextField nome;

    @FXML
    private PasswordField senha;

    @FXML
    void registrar(ActionEvent event) {
        try {
            for (int i = 0; i < DAO.getTecnico().getTecnicos().size(); i++) {
                //Aqui eu verifico se o técnico já existe
                if (DAO.getTecnico().getTecnicos().get(i).getEmail().equals(email.getText())) {
                    this.erroRegistar.setVisible(true);
                    System.out.println(email.toString());
                    return;
                }
            }
            Tecnico tecnico = new Tecnico(email.getText(), nome.getText(), senha.getText());
            if (DAO.getTecnico().getTecnicos().size() == 0) {
                //Aqui eu atribuo o cargo de administrador a técnico
                tecnico.setAdm(true);
            }
            //Aqui eu cadastro o técnico através do DAO de Tecnico
            DAO.getTecnico().criar(tecnico);
        }
        catch (Exception TecnicoInvalido){

        }
    }

}
