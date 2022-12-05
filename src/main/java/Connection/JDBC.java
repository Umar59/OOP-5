package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC 
{
    public static Connection connection = null;

    public static void setConnection() throws SQLException {

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection("jdbc:mysql://localhost/books?useUnicode=true&serverTimezone=UTC", "root", "rootpassword");

        if (connection == null)
        {
            throw new SQLException();
        }
        else
        {
            System.out.println("Successfully connected");
        }
    }

    public static void closeConnection() {
        try
        {
            if (connection != null)
            {
                connection.close();
                System.out.println("Closing connection");
            }
        }
        catch (SQLException e)
        {
            System.out.println("Failed to close connection");
        }
    }
}
