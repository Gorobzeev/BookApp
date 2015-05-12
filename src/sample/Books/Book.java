package sample.Books;


public class Book {
    int id;
    String author;
    String title;
    String jenre;

    public Book(int id, String author, String title,   String jenre) {
        this.title = title;
        this.id = id;
        this.author = author;
        this.jenre = jenre;
    }

    public Book(){

    }

    public String getJenre() {
        return jenre;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setJenre(String jenre) {
        this.jenre = jenre;
    }
}

