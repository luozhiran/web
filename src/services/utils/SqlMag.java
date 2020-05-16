package services.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlMag {

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    private static final String LOAD_SQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_ADDRESS = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

//    MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
//    static final String LOAD_SQL_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_ADDRESS = "jdbc:mysql://localhost:3306/test";


    private static final String USER_NAME = "luozhiran";
    private static final String PASSWORD = "luozhiran";

    public static SqlMag create() {
        return new SqlMag();
    }


    public Connection connection = null;
    public Statement stmt = null;

    /**
     * 连接数据库
     */
    public SqlMag connected() {
        try {
            Class.forName(LOAD_SQL_DRIVER);
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("数据库驱动加载失败");
        }

        try {
            connection = DriverManager.getConnection(DB_ADDRESS, USER_NAME, PASSWORD);
            System.out.println("数据库连接成功");
        } catch (SQLException throwables) {
            connection = null;
            throwables.printStackTrace();
            System.err.println("数据库连接失败");
        }
        return this;
    }

    public SqlMag createStatement() {
        try {
            stmt = connection.createStatement();
            System.out.println("实例化Statement对象");
        } catch (SQLException throwables) {
            stmt=null;
            System.err.println("实例化Statement对象失败");
            throwables.printStackTrace();
        }
        return this;
    }


    public SqlMag closeStmt() {
        if (stmt != null) {
            try {
                stmt.close();
                stmt = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.err.println("关闭Statement失败");
            }

        }
        return this;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.err.println("关闭数据库连接失败");
            }
        }
    }

}
