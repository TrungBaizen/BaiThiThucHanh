package config;

import java.sql.*;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/qlsp";
    private static final String USER = "root";
    private static final String PASSWORD = "Trungthuy@247";

    public static Connection connection(){
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
