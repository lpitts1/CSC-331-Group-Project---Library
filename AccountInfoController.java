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
    @FXML private TableView<BookTesting> checkoutTable;
    @FXML private TableColumn<BookTesting, String> titleColumn;
    @FXML private TableColumn<BookTesting, String> authorColumn;
    @FXML private TableColumn<BookTesting, String> genreColumn;
    @FXML private TableColumn<BookTesting, LocalDate> checkoutDateColumn;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initializes columns of the table for each book attribute
        titleColumn.setCellValueFactory(new PropertyValueFactory<BookTesting, String>("bookName"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<BookTesting, String>("authorName"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<BookTesting, String>("genre"));
        checkoutDateColumn.setCellValueFactory(new PropertyValueFactory<BookTesting, LocalDate>("checkOutDate"));
        // Sets the values
        checkoutTable.setItems(getBook());
    }
    public ObservableList<BookTesting> getBook(){
        // Observable list for usage with the TableView object
        ObservableList<BookTesting> books = FXCollections.observableArrayList();
        // Placeholder book objects for testing
        books.add(new BookTesting("Dictionary", "Miriam-Webster","Non-Fiction", LocalDate.of(2024, Month.NOVEMBER, 18)));
        books.add(new BookTesting("Java How to Program Early Objects", "Deitel","Non fiction", LocalDate.of(2024, Month.NOVEMBER, 18)));
        // Returns the observable list
        return books;
    }
}
