package entities;

import javax.persistence.*;

/**
 * Book entity class
 * It is referenced as a table in the database
 */
@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bookId")
    private Integer bookId;

    @Column(name="bookTitle")
    private String bookTitle;

    @Column(name="bookAuthor")
    private String bookAuthor;


    public Integer getBookId() {
        return bookId;
    }
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTile(String bookTile) {
        this.bookTitle = bookTile;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

}
