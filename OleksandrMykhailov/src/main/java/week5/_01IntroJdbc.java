package week5;


import java.sql.*;

/**
 * Created by mi on 04.10.2016.
 */
public class _01IntroJdbc {
    private static final String UR = "jdbc:mysql://localhost:3306/ACP14USER";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String ALL_USER_QUERY = "SELECT id, name, amount, birth, phone FROM users";

    public static void main(String[] args) throws ClassNotFoundException {
        //load driver
        Class.forName("com.mysql.jdbc.Driver");

        //     new User(-1,"new user",new java.util.Date(),"+380111111",6000);
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection =
                    DriverManager.getConnection(UR, USER, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ALL_USER_QUERY);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double amount = resultSet.getDouble("amount");
                Date birth = resultSet.getDate("birth");
                String phone = resultSet.getString("phone");

                System.out.println(new User(id, name, birth, phone, amount));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
