package com.qfedu.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;

public class BaseDao {
    /*
     * 完成统一的update方法（增删改）
     * 方法的分析：
     *   方法名字：update
     *   方法的参数：
     *          1.sql语句
     *          2.是sql语句中占位符的Object [] 数组集合
     *   方法的返回值：
     *       int 返回当前数据库操作所影响的行数
     *
     *
     * public
     *
     *
     * */

    public int update (String sql, Object[] parameters) throws SQLException {
        if (sql == null) {
            throw new SQLException("SQL is null");
        }
        //1.获取数据库=连接
        Connection connection = JdbcUtil.getConnection();
//        //2.使用sql语句获取对应的preparestatement 这个对象
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        //3.处理数据与处理的几个参数
//        ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
//        int parameterCount = parameterMetaData.getParameterCount();
//        if (parameters != null &&  parameters.length == parameterCount) {
//            for (int i = 1; i <= parameterCount ; i++) {
//                preparedStatement.setObject(i, parameters[i - 1]);
//            }
//        }
//        //4.执行sql语句
//        int i = preparedStatement.executeUpdate();
//        //5.关闭资源
//        JdbcUtil.close(connection, preparedStatement);
        //2获取DBUtils中核心类对象 queryRunner
        QueryRunner queryRunner = JdbcUtil.getQueryRunner();
        int i = queryRunner.update(connection, sql, parameters);
        //6.返回 受影响的行数
        return i;


    }

    /*
    * 完成一个统一的查询方法
    *   1.查询一个数据
    * 2.查询多个数据
    * 3.查询任意类对象的数据
    *
    * 方法：
    *   方法名字：query
    *   方法参数：
    *           sql, 需要执行的sql语句
    *           Object[] {} 对应sql语句的参数
    *           Class<T> cls  泛型
    *               1.需要带有泛型的，约束当前使用的泛型
    *               2.这个参数还一个重要的功能，就是指定查询数据 class对象，需要借助于反射
    *
    *
    *List<Work>
    *@Test
    public void selectOne () throws SQLException {
        String sql = "select * from work where id = ?";
        List<Work> query = super.query(sql, new Object[]{7}, Work.class);
        if (query != null) {
            System.out.println(query);
            System.out.println(query.get(0));
        }
    }
    * */

    public <T> List<T> query (String sql, Object[] parameters, Class<T> cls) throws SQLException {
        if (sql == null || cls == null) {
            throw new NullPointerException();
        }
        //1.获取数据库连接对象
        Connection connection = JdbcUtil.getConnection();
        //2.获取queryrunner类对象
        QueryRunner queryRunner = JdbcUtil.getQueryRunner();

        //3.直接执行查询语句
        List<T> query = queryRunner.query(connection, sql, new BeanListHandler<T>(cls), parameters);
        return query.size() >0 ?query:null;



    }
}
