package week5;

import java.sql.*;

/**
 * Created by mi on 04.10.2016.
 */
public class _03IntroPrepareStatement {

    private static final String UR = "jdbc:mysql://localhost:3306/ACP14USER";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
//    public static final String ALL_USER_QUERY = "SELECT id, name, birth, phone, amount, FROM users";

    public static void main(String[] args) throws ClassNotFoundException {
        //load driver
        Class.forName("com.mysql.jdbc.Driver");
        User user = new User(-1, "new user", new java.util.Date(), "+380666666", 3000);


        try (Connection connection = DriverManager.getConnection(UR, USER, PASSWORD);
             PreparedStatement pst = connection.prepareStatement("INSERT INTO users(name,birth,phone,amount)   VALUES (?,?,?,?)");) {

 //         pst.setInt(1, user.getId());
            pst.setString(1, user.getName());
            pst.setDate(2, new Date(user.getDate().getTime()));
            pst.setString(3, user.getPhone());
            pst.setDouble(4, user.getAmount());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




