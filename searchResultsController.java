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

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.scene.control.*;

/**
    *controller for search results and search function
    *lets you check out books
*/
public class searchResultsController implements Initializable {
    Member m;

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
    public void setMember(Member m){
        this.m = m;
    }
    @FXML
    public void checkOutButton() throws Exception {
        Book b = searchResultsTable.getSelectionModel().getSelectedItem();
//exception for if selected book quantity is zero
        //creates new stage called error window to display message
        if (b.bookQty == 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("errorWindow.fxml"));
            Parent root2 = loader.load();
            Stage stage = new Stage();
            stage.setTitle("error");
            stage.setScene(new Scene(root2,400,250));
            errorWindowController controller = loader.getController();
            controller.setStage(stage);
            stage.show();
        }else{
            b.checkOut();
            b.getCheckOutDate();
            try {
                // Create a new FXML object instance
                FXMLLoader loader = new FXMLLoader(getClass().getResource("accountInfo.fxml"));
                // Load FXML into root
                Parent root = loader.load();
                // Returns root controller (searchResultsController)
                AccountInfoController controller = loader.getController();
                // Calls the getList method from searchResultsController after passing
                // the observable list of matching books from the search to it.
                controller.getBook().add(b);
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setTitle("Search Results");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
