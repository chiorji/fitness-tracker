package com.fitnesstracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FitnessTracker extends Application {

    private static final int APP_WIDTH = 375;
    private static final int APP_HEIGHT = 475;
    private ComboBox<String> intensities;
    private TextField age, HRmaxValue, HRrestValue;

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = createScene();
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        stage.setTitle("Fitness Tracker");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private Scene createScene() {
        VBox box = new VBox();
        box.getStyleClass().add("body");

        Label appLabel = new Label("Heart Rate Tracker");
        appLabel.setAlignment(Pos.CENTER);
        appLabel.setMaxWidth(Double.MAX_VALUE);
        appLabel.getStyleClass().add("app-label");

        Label description = new Label("This app let's you calculate your heart rate");
        description.setAlignment(Pos.CENTER);
        description.setMaxWidth(Double.MAX_VALUE);
        description.getStyleClass().add("app-description");

        GridPane outputContainer = createOutputContainer();
        GridPane controlContainer = createControlButtonsContainer();

        Button calculateButton = new Button("Calculate Target Heart Rate");
        calculateButton.setMaxWidth(Double.MAX_VALUE);
        calculateButton.setMinHeight(50);
        calculateButton.setAlignment(Pos.CENTER);
        calculateButton.getStyleClass().add("calculate-button");

        StackPane calculateButtonPane = new StackPane();
        calculateButtonPane.setPadding(new Insets(40, 20, 20, 20));
        calculateButtonPane.getChildren().add(calculateButton);

        box.getChildren().addAll(appLabel, description, outputContainer, controlContainer, calculateButtonPane);

        return new Scene(box, APP_WIDTH, APP_HEIGHT);
    }


    private GridPane createOutputContainer() {
        GridPane gridPane = new GridPane();
        VBox box = new VBox();

        gridPane.setHgap(20);
        gridPane.setVgap(10);
//        gridPane.setGridLinesVisible(true);
        gridPane.setMaxWidth(Double.MAX_VALUE);
        gridPane.setPadding(new Insets(10, 0, 20, 20));

        Label normalTHRLabel = new Label("Target Heart Rate (THR): ");
//        normalTHRLabel.getStyleClass().add("property-label");
        Label normalTHRValue = new Label("162.5 bpm");
//        normalTHRValue.getStyleClass().add("property-value-label");

        Label estimatedTHRLabel = new Label("THR with Estimated HRmax: ");
//        estimatedTHRLabel.getStyleClass().add("property-label");
        Label estimatedTHROutputValue = new Label("178.3 bpm");
//        estimatedTHROutputValue.getStyleClass().add("property-value-label");

        gridPane.addRow(0, normalTHRLabel, normalTHRValue);
        gridPane.addRow(1, estimatedTHRLabel, estimatedTHROutputValue);

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        column1.setPercentWidth(60);
        column2.setPercentWidth(40);
        gridPane.setMinHeight(40);

        gridPane.getColumnConstraints().addAll(column1, column2);
        gridPane.getStyleClass().add("output-gridpane");
        return gridPane;
    }

    private GridPane createControlButtonsContainer() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(10);
//        gridPane.setGridLinesVisible(true);
        gridPane.setMaxWidth(Double.MAX_VALUE);
        gridPane.setPadding(new Insets(20, 20, 20, 20));

        Label ageLabel = new Label("Age");
        ageLabel.getStyleClass().add("property-label");
        age = new TextField("30");
        age.getStyleClass().add("property-value-label");

        Label HRmaxLabel = new Label("Heart Rate Maximum");
        HRmaxLabel.getStyleClass().add("property-label");
        HRmaxValue = new TextField("15");
        HRmaxValue.getStyleClass().add("property-value-label");

        Label HRrestLabel = new Label("Heart Rate Resting");
        HRrestLabel.getStyleClass().add("property-label");
        HRrestValue = new TextField("15");
        HRrestValue.getStyleClass().add("property-value-label");

        Label intensityLabel = new Label("Intensity");
        intensityLabel.getStyleClass().add("property-label");
        intensities = new ComboBox<>();
        intensities.setMaxWidth(Double.MAX_VALUE);
        intensities.setMinHeight(40);
        intensities.getStyleClass().add("text-field");

        gridPane.addRow(0, ageLabel, age);
        gridPane.addRow(1, HRmaxLabel, HRmaxValue);
        gridPane.addRow(2, HRrestLabel, HRrestValue);
        gridPane.addRow(3, intensityLabel, intensities);
        gridPane.setMinHeight(40);

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        column1.setPercentWidth(60);
        column2.setPercentWidth(40);

        gridPane.getColumnConstraints().addAll(column1, column2);
        return gridPane;
    }

    public static void main(String[] args) {
        launch();
    }
}