package com.example.project_2_331;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable{
    @FXML
    private Button browseButton;
    @FXML
    private Button searchButton;

    @FXML
    private ChoiceBox<String> searchMenuChoice;

    @FXML
    private Label searchMenuLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    public String getSearchTextField(){
        return searchTextField.getText();
    }
    @FXML
    private Button accountViewButton;

    @FXML
    public void searchButtonPress(ActionEvent event) throws Exception{
        try {
            // Create a new FXML object instance
            FXMLLoader loader = new FXMLLoader(getClass().getResource("searchResults.fxml"));
            // Load FXML into root
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Search Results");
            stage.setScene(scene);
            // Returns root controller (searchResultsController)
            searchResultsController controller = loader.getController();
            // Calls the getList method from searchResultsController after passing
            // the observable list of matching books from the search to it.
            controller.getList(compareParam());
            stage.show();
        } catch (IOException e) {
        e.printStackTrace();
    }
    }
    @FXML
    public void accountButtonPress(ActionEvent event) throws Exception {
        // Loads the account info page from a button press called in the mainPage.fxml
        try {
            // Create a new FXML object instance
            FXMLLoader loader = new FXMLLoader(getClass().getResource("accountInfo.fxml"));
            // Load FXML into root
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            AccountInfoController controller = loader.getController();
            controller.setStage(stage);
            stage.setTitle("Account Information");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        searchMenuChoice.setValue("Title");  // Set default value of choicebox for search
        searchMenuChoice.setItems(getSearchOptions());  // List of search options
    }

    public ObservableList<String> getSearchOptions(){
        // Search options list as an observable list to be displayed in the choicebox
        ObservableList<String> searchOptions = FXCollections.observableArrayList();
        searchOptions.addAll("Title", "Author", "Genre");
        return searchOptions;
    }

    public String getSearchParameter(){
        // Get the search option from the choicebox
        return searchMenuChoice.getValue();
    }

    public ObservableList<Book> compareParam(){
        String searchParameter = getSearchParameter();  // Search by option
        String userSearch = getSearchTextField().toLowerCase();  // Entered tex

        // Test list of books for populating the library
        Book[] bookList = new Book[4];
        bookList[0] = new Book("The Hobbit", "J.R.R Tolkien", "Fiction", 5);
        bookList[1] = new Book("Where the Sidewalk Ends", "Shel Silverstein", "Fiction", 2);
        bookList[2] = new Book("Twilight", "Stephenie Meyer", "Fiction", 66);
        bookList[3] = new Book("The Immortal Life of Henrietta Lacks", "Rebecca Skloot", "Non-Fiction", 0);

        // Search results as an observable list
        ObservableList<Book> searchResults = FXCollections.observableArrayList();
        for(int i = 0; i<= bookList.length-1; i++) {
            // Matching search by parameters to book object attributes and adding to the list of results
            switch (searchParameter) {
                case "Title":
                    if (bookList[i].getBookName().equalsIgnoreCase(userSearch) | bookList[i].getBookName().toLowerCase().contains(userSearch)){
                    searchResults.add(bookList[i]);
                    }
                    break;
                case "Author":
                    if (bookList[i].getAuthorName().equalsIgnoreCase(userSearch) | bookList[i].getAuthorName().toLowerCase().contains(userSearch)){
                        searchResults.add(bookList[i]);
                    }
                    break;
                case "Genre":
                    if (bookList[i].getGenre().equalsIgnoreCase(userSearch) | bookList[i].getGenre().toLowerCase().contains(userSearch)){
                        searchResults.add(bookList[i]);
                    }
                    break;
            }
        }
        return searchResults;
    }
}
