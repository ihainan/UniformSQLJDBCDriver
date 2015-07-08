package cn.edu.bit.linc.uniformsql.jdbc.driver;

import java.sql.Connection;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Uniform SQL JDBC Driver
 *
 * @Author ihainan
 */
public class UniformSQLJDBCDriver implements java.sql.Driver {
    public static final int MAJOR_VERSION = 1;
    public static final int MINOR_VERSION = 0;

    // TODO: 注册驱动
    static {
        try {
            java.sql.DriverManager.registerDriver(new UniformSQLJDBCDriver());
        } catch (SQLException e) {
            // TODO: 异常处理
            e.printStackTrace();
        }
    }

    // DriverManager.getConnection 方法调用 connect(String url, Properties info)，返回 Connection 对象
    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        return new UniformSQLJDBCConnection(url, info);
    }

    /**
     * 检测 URL 是否合法
     *
     * @param url 需要检测的 URL
     * @return URL 如果驱动合法，返回 <code>true</code>，否则返回 <code>false</code>
     * @throws SQLException 发生数据库访问错误
     */
    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return url.startsWith("jdbc:zql:");
    }

    // TODO: 实现
    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    /**
     * 获取当前驱动的主要版本号
     *
     * @return 当前驱动的主要版本号
     */
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    /**
     * 获取当前驱动的较小（？）版本号
     *
     * @return 当前驱动的较小版本号
     */
    @Override
    public int getMinorVersion() {
        return MINOR_VERSION;
    }

    // TODO: 理解 + 实现
    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    // TODO: 理解 + 实现
    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
