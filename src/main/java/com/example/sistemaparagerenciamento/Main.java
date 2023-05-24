package com.example.sistemaparagerenciamento;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stage;

    private static Scene loginScene;

    private static Scene registroScene;

    private static Scene paginaPrincipalScene;

    private static Scene registroClienteScene;
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setTitle("home");

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("login.fxml"));
        loginScene = new Scene(fxmlLogin);

        primaryStage.setScene(loginScene);
        primaryStage.setMaximized(true);
        primaryStage.show();

        Parent fxmlRegistro = FXMLLoader.load(getClass().getResource("registro.fxml"));
        registroScene = new Scene(fxmlRegistro);

        Parent fxmlPaginaPrincipal = FXMLLoader.load(getClass().getResource("paginaprincipal.fxml"));
        paginaPrincipalScene = new Scene(fxmlPaginaPrincipal);

        Parent fxmlRegistroCliente = FXMLLoader.load(getClass().getResource("registrocliente.fxml"));
        registroClienteScene = new Scene(fxmlRegistroCliente);
    }



    public static void telaScreen(String nome) {
        switch (nome) {
            case "login":
                stage.setScene(loginScene);
                stage.setMaximized(true);
                break;
            case "registro":
                stage.setScene(registroScene);
                stage.setMaximized(true);
                break;
            case "paginaprincipal":
                stage.setScene(paginaPrincipalScene);
                stage.setMaximized(true);
                break;
            case "registrocliente":
                stage.setScene(registroClienteScene);
                stage.setMaximized(true);
                break;
        }
    }
    public static void main(String[] args) { launch(args); }
}