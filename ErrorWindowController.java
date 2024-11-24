package com.example.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
//error window
public class ErrorWindowController {
    Stage stage;
    @FXML
    private Button okayButton;

    @FXML
    private TextField accountNumberTextField;
    @FXML
    public void setStage(Stage stage){
        this.stage = stage;
    }
//action event
//ok button closes window 
    @FXML
    public void okayButtonPress(ActionEvent event) throws Exception {
        okayButton.setOnAction(actionEvent -> {
            try {
                stage.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    }

