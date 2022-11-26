package com.example.gamedemo1;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StartScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("World of Skovbrand");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        stage.setFullScreen(true);
    }

    public static void main(String[] args) {
        launch();
    }
}