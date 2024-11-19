package weeek3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/lab3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "rootpassword";

    private Connection connection = null;

    //constructor
    public DbConnect(){
        try{
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    //getter for connection
    public Connection getConnection() {
        return connection;
    }
}
