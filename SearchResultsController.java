package com.example.library;

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

import java.io.IOException;
import java.net.URL;

import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.scene.control.*;

/**
    *controller for search results and search function
    *lets you check out books
*/
public class SearchResultsController implements Initializable {

    @FXML
    private Label searchResultsLabel;
    @FXML
    private Button checkOutSearchButton;
    @FXML
    private TextField accountNumberTextField;

    @FXML private TableView<Book> searchResultsTable;
    @FXML private TableColumn<Book, String> titleColumn;
    @FXML private TableColumn<Book, String> authorColumn;
    @FXML private TableColumn<Book, String> genreColumn;
    @FXML private TableColumn<Book, Integer> qtyColumn;
    @FXML
    /**
     * puts search results in the table
    */
    public void getList(ObservableList<Book> searchList){
        // Initializes columns of the table for each book attribute
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("bookName"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("authorName"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));
        qtyColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("bookQty"));
        // Sets the values
        searchResultsTable.setItems(searchList);
        checkOutSearchButton.setDefaultButton(true);
        checkOutSearchButton.setOnAction(actionEvent -> {
            try {
                checkOutButton(); 
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    @FXML
    public void checkOutButton() throws Exception {
        Book b = searchResultsTable.getSelectionModel().getSelectedItem();
        //exception for if selected book quantity is zero
        //creates new stage called error window to display message
        if (b.bookQty == 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ErrorWindow.fxml"));
            Parent root2 = loader.load();
            Stage stage = new Stage();
            stage.setTitle("error");
            stage.setScene(new Scene(root2,400,250));
            ErrorWindowController controller = loader.getController();
            controller.setStage(stage);
            stage.show();
        }else{
            b.checkOut();
            b.getCheckOutDate();
            try {
                // Create a new FXML object instance
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountInfo.fxml"));
                // Load FXML into root
                Parent root = loader.load();
                // Returns root controller (searchResultsController)
                AccountInfoController controller = loader.getController();
                // Calls the getList method from searchResultsController after passing
                // the observable list of matching books from the search to it.
                b = new Book(b.getBookName(), b.getAuthorName(), b.getGenre(), b.getCheckOutDate());
                controller.getBook().add(b);
                Member m = controller.getMember();
                m.borrowedBooks[m.borrowedBooks.length - 1] = b;
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                AccountInfoController controller2 = loader.getController();
                controller2.setStage(stage);
                stage.setTitle("Search Results");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
