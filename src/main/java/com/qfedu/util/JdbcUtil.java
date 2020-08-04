package com.qfedu.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.*;

public class JdbcUtil {
    //使用静态代码块完成驱动的加载
    private static QueryRunner queryRunner = null;
    private static ComboPooledDataSource pool =new ComboPooledDataSource();

    //queryRunner对象的封装

    public static QueryRunner getQueryRunner () {
        synchronized (JdbcUtil.class){
            if (queryRunner == null) {
                queryRunner = new QueryRunner();
            }
        }
        return queryRunner;
    }
    public  static Connection getConnection () {
        Connection connection = null;
        try {
            connection = pool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }
    /*
     * 关闭数据库连接对象
     *
     * */
    public static void close (Connection connection) {
        close(connection, null, null);

    }
    public static void close (Connection connection, Statement statement) {
        close(connection, statement, null);

    }
    public static void close (Connection connection, Statement statement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
