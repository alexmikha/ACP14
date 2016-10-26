package library.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by mi on 12.10.2016.
 */
// POJO class + @Id
@Entity
@Table(name = "authors")
public class Author extends IdEntity { // class - table

    @Column(length = 20, nullable = false)
    private String name;
    @Column
    private double salary;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id",
            referencedColumnName = "id")
    private Address address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "authors_book",
            joinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")})
    private List<Book> bookList;

    @Transient
    private String secret;

    public Author() {
    }

    public Author(String name, double salary, Date birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
