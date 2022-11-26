package com.example.gamedemo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Node;
import java.io.IOException;
import java.util.*;

import javafx.scene.control.Label;

public class GameSessionController {
    String name;
    double score;
    Player player = new Player(name, score);
    int questionIndex;
    ScoreSystem scoreSystem = new ScoreSystem();
    StopWatch stopWatch = new StopWatch();
    public LinkedHashMap<String, String> questionsAndAnswers = new LinkedHashMap<>();
    public ArrayList<String> questionsRecieved = new ArrayList<>();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label InformationLabel;
    @FXML
    private RadioButton rButton1, rButton2, rButton3, rButton4, rButton5, rButton6, rButton7;
    @FXML
    Button BackButton;
    @FXML
    ImageView image1;
    @FXML
    Label QuestionBox1;
    @FXML
    Button QuestionButton1;
    @FXML
    TextField Answer1;
    @FXML
    TextField nameContainer;
    public void switchToMainMenu(ActionEvent event) throws IOException {
        // Setting the stage, scene and roots.
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainMenuScene.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        stage.setFullScreen(true);

        // Getting the name from the user input.
        player.name = nameContainer.getText();
    }

    public void informationScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InformationScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public void getInformation(ActionEvent event) throws IOException {
        if (rButton1.isSelected()) {
            InformationLabel.setText(
                    "Information 1"
            );
        } else if (rButton2.isSelected()) {
            InformationLabel.setText(
                    "Information 2"
            );
        } else if (rButton3.isSelected()) {
            InformationLabel.setText(
                    "Information 3"
            );
        } else if (rButton4.isSelected()) {
            InformationLabel.setText(
                    "Information 4"
            );
        } else if (rButton5.isSelected()) {
            InformationLabel.setText(
                    "Information 5"
            );
        } else if (rButton6.isSelected()) {
            InformationLabel.setText(
                    "Information 6"
            );
        } else if (rButton7.isSelected()) {
            InformationLabel.setText(
                    "Information 7"
            );
        }
    }

    public void mainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenuScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public void HelpScene(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass()).getResource("MainMenuHelp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public void HelpSceneInformation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InformationHelp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public void gameScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WorldMap.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        // Setting the questions and answers
        questionsAndAnswers.put("Skal man slukke sit ulovlige bål, når man er færdig med at bruge det?", "Ja");
        questionsAndAnswers.put("Hvor mange procent af skovbrande er menneskeskabte? \n" +
                "1: 30-45%\n" +
                "2: 50-60%\n" +
                "3: 75-90%", "3");
        questionsAndAnswers.put("Hvis en naturlig skovbrand starter, skal man så slukke den?", "Nej");
        questionsAndAnswers.put("Hvor mange huse blev ødelagt af skovbrande i Australien i 2020\n" +
                "1: 1365\n" +
                "2: 2439\n" +
                "3: 3698", "2");
        questionsAndAnswers.put("Hvor mange millioner hektar skov var der blevet brandt af i amazonas i 2020\n" +
                "1: 4.5 millioner\n" +
                "2: 5.1 millioner\n" +
                "3: 5.5 millioner", "3");
    }

    public void USA(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("USA.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    // USA
    public void getQuestionUSA(ActionEvent event) throws IOException {
        String[] questions = {"Spørgsmål 1", "Spørgsmål 2", "Spørgsmål 3"};
        Random random = new Random();
        questionIndex = random.nextInt(questions.length);
        QuestionBox1.setText(questions[questionIndex]);
        stopWatch.start();
    }

    public void checkAnswer(ActionEvent event) throws IOException {
        String[] answers = {"Ja", "Ja", "Nej"};
        String answer = Answer1.getText();
        if (answer.equals(answers[questionIndex])) {
            stopWatch.stop();
            long timeSpent = stopWatch.getElapsedTime();
            player.score += scoreSystem.addPoints(timeSpent, stopWatch.getMaxTime());
            System.out.println(player.score);
        } else {
            System.out.println("Forkert");
        }
    }
}
