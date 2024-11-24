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
    public void start(Stage mainStage) throws Exception{
        // Create a new FXML object instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainPage.fxml"));
        // Load FXML into root
        Parent root = loader.load();
        Scene scene = new Scene(root);
        mainStage.setTitle("Welcome to the Library");
        mainStage.setScene(scene);
        mainStage.show();
    }
}
