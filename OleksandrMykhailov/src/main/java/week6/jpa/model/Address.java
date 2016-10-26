package week6.jpa.model;

import java.util.List;

/**
 * Created by mi on 12.10.2016.
 */
//@Entity
//@Table(name = "addresses", uniqueConstraints = {@UniqueConstraint(columnNames = {"city","street"})})
public class Address extends IdEntity {

//    @Column
    private String city;
 //   @Column
    private String street;
//    @Column
    private String appNum;

    public Address(String city, String street, String appNum) {
        this.city = city;
        this.street = street;
        this.appNum = appNum;
    }

//     mappedBy = fieldName, describe reference
//     between for configure join columns
//    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    private List<Author> authorList;

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAppNum() {
        return appNum;
    }

    public void setAppNum(String appNum) {
        this.appNum = appNum;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", appNum='" + appNum + '\'' +
                '}';
    }
}


