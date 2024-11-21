package com.example.project_2_331;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception{
        // Loads the main page
        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Welcome to the Library");
        stage.setScene(scene);
        stage.show();
    }
}
