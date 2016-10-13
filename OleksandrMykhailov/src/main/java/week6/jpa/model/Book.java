package week6.jpa.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mi on 12.10.2016.
 */
@Entity
@Table(name="books")
public class Book extends IdEntity{


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookType type;

    @Column(length = 20)
    private String city;

    @Column(name = "publish_date")
    private Date publishDate;

    @Column
    private double price;


    public  enum BookType{
        IT, NOVEL, PSYCHOLOGY;
 //      0   1        2
    }

    public Book() {
    }

    public Book(String name, BookType type, String city, Date publishDate, double price) {
        this.name = name;
        this.type = type;
        this.city = city;
        this.publishDate = publishDate;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", city='" + city + '\'' +
                ", publishDate=" + publishDate +
                ", price=" + price +
                '}';
    }

}
