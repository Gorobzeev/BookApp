package sample.Books;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleStringProperty author = new SimpleStringProperty();
    private final SimpleStringProperty title = new SimpleStringProperty();
    private final SimpleStringProperty jenre = new SimpleStringProperty();


    public Book(int id, String author, String title,   String jenre) {
        this.title.set(title);
        this.id.set(id);
        this.author.set(author);
        this.jenre.set(jenre);
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public void setJenre(String jenre) {
        this.jenre.set(jenre);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getAuthor() {
        return author.get();
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public String getJenre() {
        return jenre.get();
    }

    public SimpleStringProperty jenreProperty() {
        return jenre;
    }





}

