package services.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDatabaseConnection implements DatabaseConnection {

    public static final String DBDREIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static String ROOT = "luozhiran";
    private static String DBPASSWORD = "luozhiran";
    private Connection conn;

    public MySqlDatabaseConnection() {
        try {
            Class.forName(DBDREIVER);
            conn = DriverManager.getConnection(DBURL, ROOT, DBPASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("练级数据库失败");
        }
    }


    @Override
    public Connection getConnection() {
        return conn;
    }

    @Override
    public void close() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("关闭数据库失败");
            }
        }
    }

}
