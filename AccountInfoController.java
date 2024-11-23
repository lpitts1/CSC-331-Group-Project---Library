package com.example.library;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;



public class AccountInfoController implements Initializable {
    Member m;
    Book book;
    ObservableList<Book> books = FXCollections.observableArrayList();
    @FXML private TableView<Book> checkoutTable;
    @FXML private TableColumn<Book, String> titleColumn;
    @FXML private TableColumn<Book, String> authorColumn;
    @FXML private TableColumn<Book, String> genreColumn;
    @FXML private TableColumn<Book, LocalDate> checkoutDateColumn;
    @FXML private TextField accountTextField;
    @FXML private TextField creationTextField;
    @FXML private TextField memNameTextField;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initializes columns of the table for each book attribute
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("bookName"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("authorName"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));
        checkoutDateColumn.setCellValueFactory(new PropertyValueFactory<Book, LocalDate>("checkOutDate"));
        // Sets the values
        checkoutTable.setItems(getBook());
        Member m = new Member("12345", "John Doe");
        IDCard mID = new IDCard("John Doe", "12345","11/23/2024");
        accountTextField.setText(mID.actNumber);
        creationTextField.setText(mID.getDateCreated());
        memNameTextField.setText(mID.memberName);
    }
    public void setBook(Book b){
        this.book = b;
    }
    public ObservableList<Book> getBook(){
        // Observable list for usage with the TableView object

        // Placeholder book objects for testing
        books.add(this.book);
        books.add(new Book("The Hobbit", "J.R.R Tolkien", "Fiction", LocalDate.of(2017, 1, 13)));
        // Returns the observable list
        return books;
    }


}
