package com.example.demo;

import com.example.demo.Controller.PrototypeBL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;


public class Main extends Application {
    private static PrototypeBL bl;
    private static Scene mainScene;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        mainScene = scene;
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void changeScene(String sceneName) throws IOException {
        String scene = sceneName + ".fxml";
        Parent parent = null;
        parent = FXMLLoader.load(Main.class.getResource(scene));
        mainScene.setRoot(parent);
    }

    public static Optional<ButtonType> showAlertChangeScene(String title, String msj, String txtBoton, String scene, Alert.AlertType alertType) throws IOException {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(msj);
        ButtonType OK = new ButtonType(txtBoton);
        alert.getButtonTypes().setAll(OK);
        Optional<ButtonType> result = alert.showAndWait();
        Main.changeScene(scene);
        return result;
    }

    public static Optional<ButtonType> showAlert(String titlle, String msj, String txtBoton, Alert.AlertType alertType) throws IOException {
        Alert alert = new Alert(alertType);
        alert.setTitle(titlle);
        alert.setContentText(msj);
        ButtonType OK = new ButtonType(txtBoton);
        alert.getButtonTypes().setAll(OK);
        Optional<ButtonType> result = alert.showAndWait();
        return result;

    }
}