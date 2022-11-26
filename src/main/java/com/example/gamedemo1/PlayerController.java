package com.example.gamedemo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Node;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class PlayerController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    String name;
    double score;
    public ArrayList<String> playerInventory = new ArrayList<>();
}