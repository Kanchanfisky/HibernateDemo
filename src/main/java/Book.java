import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private int bookID;

    @Column(nullable=false)
    private String bookName;

    @Column(nullable=false)
    private String bookWriter;

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", bookWriter='" + bookWriter + '\'' +
                ", price=" + price +
                '}';
    }
}
