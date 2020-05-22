package services.userDao;

import java.sql.Connection;

/**
 * 管理数据库连接
 */
public interface SqlConnection {
    /**
     * 获取数据库连接
     * @return
     */
    Connection getConnection();

    /**
     * 关闭数据库
     */
    void close();
}
