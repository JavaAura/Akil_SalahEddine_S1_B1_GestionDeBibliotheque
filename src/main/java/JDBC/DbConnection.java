package JDBC;


import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public static Connection connection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Akil","root","");
            System.out.println(connection);
            return connection;
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
    public static void main(String[] args) {
     System.out.println(DbConnection.connection());
    }
}
