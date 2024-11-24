package com.example.project_2_331;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


/**
 * The AccountInfoController is responsible for managing the account info in the GUI
 *
 * It initializes, uses user interactions, and updates the data in the GUI
 * AccountInfoController is linked with our AccountInfo.FXML to display the appropiate
 * information with respect to Member and Book objects
 *
 * 11/24/2024
 */
public class AccountInfoController implements Initializable {
    Member m = new Member("12345", "John Doe");
    IDCard mID = new IDCard("John Doe", "12345","11/23/2024");
    @FXML public Button backToSearchButton;
    Stage stage;
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
    @FXML private Button checkInActButton;
    /**
     * Initializes controller class and is automatically with the FXML after the FXML has been loaded
     *
     * Sets up the table view columns and binds the data to the GUI parts,
     * this also configures the checkin button
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTable(m, mID);
    }

    public void setTable(Member m, IDCard mID){
        // Initializes columns of the table for each book attribute
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("bookName"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("authorName"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));
        checkoutDateColumn.setCellValueFactory(new PropertyValueFactory<Book, LocalDate>("checkOutDate"));
        // Sets the values
        checkoutTable.setItems(getBook());
        //Member m = new Member("12345", "John Doe");
        //IDCard mID = new IDCard("John Doe", "12345","11/23/2024");
        accountTextField.setText(mID.actNumber);
        creationTextField.setText(mID.getDateCreated());
        memNameTextField.setText(mID.memberName);
        checkInActButton.setDefaultButton(true);
        checkInActButton.setOnAction(actionEvent -> {
            try {
                checkInButton();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * ObservableList retrieces the list of books to display into the table
     *
     * @return books
     */
    public ObservableList<Book> getBook(){
        // Observable list for usage with the TableView object
        // Placeholder book objects for testing
        // Returns the observable list
        return books;
    }
    /**
     * CheckInButton creates and handles the "check in" action
     *
     * The method retrieves the chosen book from the TableView, and checks-in the book
     * the method also removes the book from the list of borrowed books
     *
     * GUI is updated to reflect the change
     * @throws Exception
     */
    @FXML
    public void checkInButton() throws Exception {
        Book b = checkoutTable.getSelectionModel().getSelectedItem();
        b.checkIn();

        try {
            // the observable list of matching books from the search to it.
            ObservableList<Book> newList = getBook();
            newList.remove(b);
            checkoutTable.setItems(newList);
            m.borrowedBooks[m.borrowedBooks.length - 1] = null;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }
    public Member getMember(){
        return m;
    }

    public void backToSearch() throws Exception{
        backToSearchButton.setOnAction(actionEvent -> {
            try {
                stage.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
