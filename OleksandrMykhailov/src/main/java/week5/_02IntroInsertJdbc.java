package week5;

import java.sql.*;

/**
 * Created by mi on 04.10.2016.
 */
public class _02IntroInsertJdbc {

    private static final String UR = "jdbc:mysql://localhost:3306/ACP14USER";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    public static final String ALL_USER_QUERY = "SELECT id, name, birth, phone, amount, FROM users";

    public static void main(String[] args) throws ClassNotFoundException {
        //load driver
        Class.forName("com.mysql.jdbc.Driver");
        User user = new User(-1, "new user", new java.util.Date(), "+380666666", 3000);


        try (Connection connection = DriverManager.getConnection(UR, USER, PASSWORD);
          //  ResultSet resultSet = null;
                Statement statement = connection.createStatement();) {
            connection.setAutoCommit(false);
       //     statement.executeUpdate("INSERT INTO users(name,birth,phone,amount)" + "VALUES (Alex, , +380666666, 3000)");
            statement.executeUpdate(
                    String.format("INSERT INTO users(name,birth,phone,amount) VALUES ('%1$s', '%2$ty-%2$tm-%2$td', '%3$s', '%.2f')",
                       //     user.getId(),
                            user.getName(),
                            user.getDate(),
                            user.getPhone(),
                            user.getAmount()));
                    connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


