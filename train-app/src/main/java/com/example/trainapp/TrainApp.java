package com.example.trainapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TrainApp extends Application {
    public static Stage primaryStage;
    public static Scene locomotives;
    public static Scene series;
    public static Scene routes;
    public static Scene trips;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        locomotives = createScene("/locomotive-view.fxml");
        series = createScene("/series-view.fxml");
        routes = createScene("/route-view.fxml");
        trips = createScene("/trip-view.fxml");

        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(675);
        primaryStage.setTitle("Управление локомотивным депо");

        locomotives.getStylesheets().add("/base-styles.css");
        series.getStylesheets().add("/base-styles.css");
        routes.getStylesheets().add("/base-styles.css");
        trips.getStylesheets().add("/base-styles.css");

        primaryStage.setScene(locomotives);
        primaryStage.show();
    }

    private Scene createScene(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        return new Scene(loader.load());
    }

    public static void main(String[] args) {
        launch();
    }
}