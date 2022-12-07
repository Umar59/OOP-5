package PreparedStatement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static void main(String[] argv){
        getConnection();
    }
    public static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/books?useUnicode=true&characterEncoding=UTF-8", "root", "rootpassword");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e);
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
        return c;
    }
}
