package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.*;
import javafx.util.StringConverter;
import sample.Books.Book;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;



public  class BookEditController{

    @FXML
    private TextField id;

    @FXML
    private TextField title;

    @FXML
    private TextField author;

    @FXML
    private TextField jenre;

    @FXML
    private void initialize(){

    }

    public void handleSaveAction(ActionEvent actionEvent) {
        closeCurrentWindow();
    }

    private void closeCurrentWindow() {
        javafx.stage.Window window = jenre.getScene().getWindow();
        window.hide();
    }

    public void setBook(Book book) {
        title.textProperty().bindBidirectional(book.titleProperty());
        author.textProperty().bindBidirectional(book.authorProperty());
        jenre.textProperty().bindBidirectional(book.jenreProperty());
        id.textProperty().bindBidirectional(book.idProperty(), new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return String.valueOf(object);
            }

            @Override
            public Number fromString(String string) {
                return Integer.parseInt(string);
            }
        });
    }
}
