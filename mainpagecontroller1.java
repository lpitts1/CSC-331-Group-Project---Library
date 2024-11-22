package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.Accordion;
import javafx.scene.layout.VBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class MainPageController implements Initializable{
    @FXML
    private Label count84;

    @FXML
    private Label countGatsby;

    @FXML
    private Label countDragon;

    @FXML
    private Label countRings;

    @FXML
    private Label countHobbit;

    @FXML
    private Label countCode;

    @FXML
    private Label countRye;

    @FXML
    private Label countBird;

    @FXML
    private Button browseButton;

    @FXML
    private ChoiceBox<String> searchMenuChoice;

    @FXML
    private Label searchMenuLabel;

    @FXML
    private Accordion diplayLib;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button viewAccountButton;

    @FXML
    private Button goBtn;

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

    //need to decide on how many genres, we have fiction and nonfiction right now - I can add more inside the gui when necessary
    // other display like series info - listed in other files not sure if I need to place text for it
    // access quantity within label of panes, the names have been changed accordingly.
    @FXML
    public void goBtnClick(ActionEvent event) {
        String search = searchTextField.getText();
        //if statement to see what the user entered if its title author or genre, then use corresponding for search
        // Add to check out, subtract 1 from available, update label in respective drop down,
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchMenuChoice.setItems(getSearchOptions());
    }

    public ObservableList<String> getSearchOptions(){
        ObservableList<String> searchOptions = FXCollections.observableArrayList();
        searchOptions.addAll("Title", "Author", "Genre");
        return searchOptions;
    }
}