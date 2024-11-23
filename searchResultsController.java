package com.example.project_2_331;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;

import java.util.ResourceBundle;

public class searchResultsController implements Initializable {

    @FXML
    private Label searchResultsLabel;
    @FXML
    private Button checkOutSearchButton;

    @FXML private TableView<Book> searchResultsTable;
    @FXML private TableColumn<Book, String> titleColumn;
    @FXML private TableColumn<Book, String> authorColumn;
    @FXML private TableColumn<Book, String> genreColumn;
    @FXML private TableColumn<Book, Integer> qtyColumn;
    @FXML
    public void getList(ObservableList<Book> searchList){
        // Initializes columns of the table for each book attribute
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("bookName"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("authorName"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));
        qtyColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("bookQty"));
        // Sets the values
        searchResultsTable.setItems(searchList);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
