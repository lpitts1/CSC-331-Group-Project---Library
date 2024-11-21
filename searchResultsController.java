package com.example.project_2_331;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class searchResultsController implements Initializable {

    @FXML
    private Label searchResultsLabel;

    @FXML private TableView<BookTesting> searchResultsTable;
    @FXML private TableColumn<BookTesting, String> titleColumn;
    @FXML private TableColumn<BookTesting, String> authorColumn;
    @FXML private TableColumn<BookTesting, String> genreColumn;
    @FXML private TableColumn<BookTesting, Integer> qtyColumn;
    @FXML
    public void getList(ObservableList<BookTesting> searchList){
        // Initializes columns of the table for each book attribute
        titleColumn.setCellValueFactory(new PropertyValueFactory<BookTesting, String>("bookName"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<BookTesting, String>("authorName"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<BookTesting, String>("genre"));
        qtyColumn.setCellValueFactory(new PropertyValueFactory<BookTesting, Integer>("bookQty"));
        // Sets the values
        searchResultsTable.setItems(searchList);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
