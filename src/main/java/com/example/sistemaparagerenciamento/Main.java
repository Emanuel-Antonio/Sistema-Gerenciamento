package com.example.sistemaparagerenciamento;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;

public class Main extends Application {

    private static Stage stage;

    private static Scene loginScene;

    private static Scene registroScene;

    private static Scene paginaPrincipalScene;

    private static Scene clientesScene;

    private static Scene estoqueScene;

    private static Scene ordemScene;

    private static Scene servicoScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setTitle("");
        primaryStage.getIcons().add(new Image("C:\\Users\\55779\\IdeaProjects\\Sistema-Gerenciamento\\src\\main\\resources\\com\\example\\sistemaparagerenciamento\\img\\icone-app.png"));

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("login.fxml"));
        loginScene = new Scene(fxmlLogin);

        primaryStage.setScene(loginScene);
        primaryStage.setWidth(1300);
        primaryStage.setHeight(680);
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

        Parent fxmlServico = FXMLLoader.load(getClass().getResource("servicos.fxml"));
        servicoScene = new Scene(fxmlServico);
    }



    public static void telaScreen(String nome) {
        switch (nome) {
            case "login":
                stage.setScene(loginScene);
                stage.setWidth(1300);
                stage.setHeight(680);
                stage.setResizable(false);
                break;
            case "registro":
                stage.setScene(registroScene);
                stage.setWidth(1300);
                stage.setHeight(680);
                stage.setResizable(false);
                break;
            case "paginaprincipal":
                stage.setScene(paginaPrincipalScene);
                stage.setWidth(1300);
                stage.setHeight(680);
                stage.setResizable(false);
                break;
            case "clientes":
                stage.setScene(clientesScene);
                stage.setWidth(1300);
                stage.setHeight(680);
                stage.setResizable(false);
                break;
            case "estoque":
                stage.setScene(estoqueScene);
                stage.setWidth(1300);
                stage.setHeight(680);
                stage.setResizable(false);
                break;
            case "ordens":
                stage.setScene(ordemScene);
                stage.setWidth(1300);
                stage.setHeight(680);
                stage.setResizable(false);
                break;
            case "servico":
                stage.setScene(servicoScene);
                stage.setWidth(1300);
                stage.setHeight(680);
                stage.setResizable(false);
        }
    }
    public static void main(String[] args) { launch(args); }
}