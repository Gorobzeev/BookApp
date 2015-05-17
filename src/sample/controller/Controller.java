package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Books.Book;
import javafx.event.ActionEvent;

import javafx.scene.control.TableColumn;
import sample.Main;


import java.awt.*;
import java.beans.EventHandler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Controller  {
    private ObservableList<Book> booksData = FXCollections.observableArrayList();


    @FXML
    private TableView<Book> tableBooks;

    @FXML
    private TableColumn<Book, Integer> idColumn;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, String> jenreColumn;




    @FXML
    private void initialize() {
        initData();
        idColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id")); //заполняет данные в таблицу
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        jenreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("jenre"));

        tableBooks.setItems(booksData);


    }

    public void handleDeleteAction (ActionEvent actionEvent){
        Book selectedBook = tableBooks.getSelectionModel().getSelectedItem();
        if (selectedBook != null){
            booksData.remove(selectedBook);
        }
    }

    public void handleUpdateAction (ActionEvent actionEvent){
        Book selectedBook = tableBooks.getSelectionModel().getSelectedItem(); //выбирает выбранную строку
        if (selectedBook != null){

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/bookEdit.fxml"));
                Parent root = fxmlLoader.load();
                BookEditController  controller = fxmlLoader.getController();
                controller.setBook(selectedBook);
                showNewWindow("Update Book", root);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void handleCreateAction (ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/bookEdit.fxml"));
            Parent root = fxmlLoader.load();
            BookEditController  controller = fxmlLoader.getController();
            Book  newBook = new Book(booksData.size()+1,"","","");
            controller.setBook(newBook);
            showNewWindow("Create Book", root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showNewWindow(String s, Parent root) {
        Stage stage = new Stage();
        stage.setTitle(s);
        stage.setScene(new Scene(root));
        stage.show();

    }

    private void initData() {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader bufferedReader;
        try {
            FileReader fileReader = new FileReader("D:/MyProjects/BookApp5/data.txt");
            bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String str = bufferedReader.readLine();
                if (str != null) {
                    list.add(str);
                } else break;
            }
            bufferedReader.close();

        } catch (Exception e) {
        }


        for (int i = 0; i < list.size(); i++) {
            String[] parts = list.get(i).split(";");
            int id = Integer.parseInt(parts[0]);
            Book book = new Book(id, parts[1], parts[2], parts[3]);
            booksData.add(book);

        }
    }


}
