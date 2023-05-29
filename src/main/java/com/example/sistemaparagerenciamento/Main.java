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

    private static Scene clientesScene;

    private static Scene estoqueScene;

    private static Scene ordemScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setTitle("home");

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("login.fxml"));
        loginScene = new Scene(fxmlLogin);

        primaryStage.setScene(loginScene);
        primaryStage.setWidth(1200);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.show();

        Parent fxmlRegistro = FXMLLoader.load(getClass().getResource("registro.fxml"));
        registroScene = new Scene(fxmlRegistro);

        Parent fxmlPaginaPrincipal = FXMLLoader.load(getClass().getResource("paginaprincipal0.fxml"));
        paginaPrincipalScene = new Scene(fxmlPaginaPrincipal);

        Parent fxmlClientes = FXMLLoader.load(getClass().getResource("clientes.fxml"));
        clientesScene = new Scene(fxmlClientes);

        Parent fxmlEstoque = FXMLLoader.load(getClass().getResource("estoque.fxml"));
        estoqueScene = new Scene(fxmlEstoque);

        Parent fxmlOrdem = FXMLLoader.load(getClass().getResource("ordens.fxml"));
        ordemScene = new Scene(fxmlOrdem);
    }



    public static void telaScreen(String nome) {
        switch (nome) {
            case "login":
                stage.setScene(loginScene);
                stage.setWidth(1200);
                stage.setHeight(600);
                stage.setResizable(false);
                break;
            case "registro":
                stage.setScene(registroScene);
                stage.setWidth(1200);
                stage.setHeight(600);
                stage.setResizable(false);
                break;
            case "paginaprincipal":
                stage.setScene(paginaPrincipalScene);
                stage.setWidth(1200);
                stage.setHeight(600);
                stage.setResizable(false);
                break;
            case "clientes":
                stage.setScene(clientesScene);
                stage.setWidth(1200);
                stage.setHeight(600);
                stage.setResizable(false);
                break;
            case "estoque":
                stage.setScene(estoqueScene);
                stage.setWidth(1200);
                stage.setHeight(600);
                stage.setResizable(false);
                break;
            case "ordens":
                stage.setScene(ordemScene);
                stage.setWidth(1200);
                stage.setHeight(600);
                stage.setResizable(false);
                break;
        }
    }
    public static void main(String[] args) { launch(args); }
}