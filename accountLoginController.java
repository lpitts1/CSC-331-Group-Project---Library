package com.example.project_2_331;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class accountLoginController {
    Stage stage;
    @FXML
    private Button accountNumberEntryButton;

    @FXML
    private TextField accountNumberTextField;
    @FXML
    public void setStage(Stage stage){
        this.stage = stage;
    }

    @FXML
    public void accountInfoButtonPress(ActionEvent event) throws Exception {
        // Loads the account info page from a button press called in the mainPage.fxml
        try {
            // Create a new FXML object instance
            FXMLLoader loader = new FXMLLoader(getClass().getResource("accountInfo.fxml"));
            // Load FXML into root
            Parent root = loader.load();
            loader.setController("AccountInfoController");
            Scene scene = new Scene(root);
            stage.setTitle("Account Information");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
