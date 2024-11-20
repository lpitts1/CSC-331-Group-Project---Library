package com.example.project_2_331;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainPageController {

    @FXML
    private Button browseButton;

    @FXML
    private ChoiceBox<?> searchMenuChoice;

    @FXML
    private Label searchMenuLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button viewAccountButton;

    @FXML
    public void accountButtonPress(ActionEvent event) throws Exception{
        // Loads the account info page from a button press called in the mainPage.fxml
        Parent root = FXMLLoader.load(getClass().getResource("accountInfo.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("accountInfo");
        stage.setScene(scene);
        stage.show();
    }
}
