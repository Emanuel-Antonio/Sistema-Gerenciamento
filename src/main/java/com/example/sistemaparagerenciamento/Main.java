package com.example.sistemaparagerenciamento;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stage;

    private static Scene paginaScene;

    private static Scene registroScene;
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setTitle("home");

        Parent fxmlPagina = FXMLLoader.load(getClass().getResource("login.fxml"));
        paginaScene = new Scene(fxmlPagina, 500, 500);

        Parent fxmlRegistro = FXMLLoader.load(getClass().getResource("registro.fxml"));
        registroScene = new Scene(fxmlRegistro, 500, 500);

        primaryStage.setScene(paginaScene);
        primaryStage.show();
    }

    public static void telaScreen(String nome){
        switch (nome){
            case "pagina":
                stage.setScene(paginaScene);
                break;
            case "registro":
                stage.setScene(registroScene);
                break;
        }
    }
    public static void main(String[] args) { launch(args); }
}