package week5;


import java.util.Date;

/**
 * Created by mi on 04.10.2016.
 */
public class User {

    private int id;
    private String name;
    private Date date;
    private String phone;
    private double amount;

    public User(int id, String name, Date date, String phone, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", phone='" + phone + '\'' +
                ", amount=" + amount +
                '}';
    }
}
