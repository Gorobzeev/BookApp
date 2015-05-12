package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Books.Book;
import javafx.event.ActionEvent;

import javafx.scene.control.TableColumn;

import java.awt.*;
import java.beans.EventHandler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Controller {
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
    private Button delete;

    @FXML
    private Button update;

    @FXML
    private Button add;

    


    @FXML
    private void initialize() {
        initData();
        idColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        jenreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("jenre"));

        tableBooks.setItems(booksData);



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
