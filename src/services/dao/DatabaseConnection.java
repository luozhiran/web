package services.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DatabaseConnection {


    Connection getConnection();
    void close();

}
