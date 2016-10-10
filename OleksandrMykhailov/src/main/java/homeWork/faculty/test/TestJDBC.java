package homeWork.faculty.test;

import java.sql.*;

/**
 * Created by mi on 08.10.2016.
 */
public class TestJDBC {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement stmt = null;
        PreparedStatement prstmt =null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FACULTY?useSSL=false", "root", "root");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ERROR");
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM students");
        }
    }
}
