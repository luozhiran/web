package services.userDao;

import services.utils.SqlConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnectionImpl implements SqlConnection {

    private Connection mConn;


    public SqlConnectionImpl() {
        try {
            Class.forName(SqlConfig.DB_DRIVER);
            mConn = DriverManager.getConnection(SqlConfig.DB_TEST_ADDRESS, SqlConfig.ROOT, SqlConfig.PASSWARD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("数据库驱动加载失败");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println("无法和数据库建立连接");
        }
    }

    @Override
    public Connection getConnection() {
        return mConn;
    }

    @Override
    public void close() {
        if (mConn != null) {
            try {
                mConn.close();
                mConn = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.err.println("关闭数据库失败:" + throwables.getMessage());
            }
        }
    }
}
