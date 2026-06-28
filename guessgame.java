package com.assignment2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;

public class guessgame extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Play a guessing game!");

        Random rand = new Random();
        int myNum = rand.nextInt(1000) + 1;

        System.out.println(myNum);

        HBox topHBox = new HBox();
        Label previousGuesses = new Label("Guess the number between 1 and 1000.");
        topHBox.getChildren().add(previousGuesses);
        topHBox.setAlignment(Pos.CENTER_LEFT);
        topHBox.setPadding(new Insets(0, 0, 0, 50));

        HBox secondHBox = new HBox(10);
        Label promptLabel = new Label("Enter a guess:");
        TextField guessEntry = new TextField();
        secondHBox.getChildren().addAll(promptLabel, guessEntry);
        secondHBox.setAlignment(Pos.CENTER_LEFT);
        secondHBox.setPadding(new Insets(0, 0, 0, 50));

        Button submitButton = new Button("Submit your guess");
        Label statusReport = new Label("Will say too high, too low or got it in X guesses");

        class ButtonClickHandler implements EventHandler<ActionEvent> {
            private int numGuesses = 0;
            private ArrayList<Integer> actualGuesses = new ArrayList<>();
            private String guessString = ""; // Declared right after your counters

            @Override
            public void handle(ActionEvent event) {
                String userTextInput = guessEntry.getText().trim();

                if (!userTextInput.isEmpty()) {
                    try {
                        int userGuess = Integer.parseInt(userTextInput);
                        numGuesses++;
                        actualGuesses.add(userGuess);
                        guessString = "Your guesses:";
                        for (int guess : actualGuesses) {
                            guessString += " " + guess;
                        }

                        previousGuesses.setText(guessString);
                        String resultMessage = compareGuess(userGuess, myNum, numGuesses);
                        statusReport.setText(resultMessage);

                        guessEntry.setText("");

                        if (userGuess == myNum) {
                            submitButton.setDisable(true);
                        }

                    } catch (NumberFormatException e) {
                        statusReport.setText("Please enter a valid whole number!");
                    }
                }
            }
        }

        submitButton.setOnAction(new ButtonClickHandler());

        VBox mainVBox = new VBox(20);
        mainVBox.setPadding(new Insets(25));
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.getChildren().addAll(topHBox, secondHBox, submitButton, statusReport);

        Scene scene = new Scene(mainVBox, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public String compareGuess(int guess, int target, int count) {
        if (guess > target) {
            return "Your guess was too high!";
        } else if (guess < target) {
            return "Your guess was too low!";
        } else {
            return "You guessed it in " + count + " guesses!";
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}