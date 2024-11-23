package com.example.project_2_331;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class AccountInfoController implements Initializable {
    @FXML private TableView<Book> checkoutTable;
    @FXML private TableColumn<Book, String> titleColumn;
    @FXML private TableColumn<Book, String> authorColumn;
    @FXML private TableColumn<Book, String> genreColumn;
    @FXML private TableColumn<Book, LocalDate> checkoutDateColumn;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initializes columns of the table for each book attribute
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("bookName"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("authorName"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));
        checkoutDateColumn.setCellValueFactory(new PropertyValueFactory<Book, LocalDate>("checkOutDate"));
        // Sets the values
        checkoutTable.setItems(getBook());
    }
    public ObservableList<Book> getBook(){
        // Observable list for usage with the TableView object
        ObservableList<Book> books = FXCollections.observableArrayList();
        // Placeholder book objects for testing
        books.add(new Book("The Hobbit", "J.R.R Tolkien", "Fiction", LocalDate.of(2017, 1, 13)));
        books.add(new Book ("The Hobbit", "J.R.R Tolkien", "Fiction", LocalDate.of(2017, 1, 13)));
        // Returns the observable list
        return books;
    }
}
