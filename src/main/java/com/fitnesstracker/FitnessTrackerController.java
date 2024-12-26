package com.fitnesstracker;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FitnessTrackerController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}