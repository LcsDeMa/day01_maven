package com.qfedu.dao.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public Integer selectTotalSize() throws Exception {
        return new QueryRunner(JDBCUtils.getDataSource())
                .query("select * from user",
                        new BeanListHandler<User>(User.class))
                .size();
    }

    @Override
    public List<User> selectUserListByPage(Integer begin, Integer pageSize) throws Exception {
        return new QueryRunner(JDBCUtils.getDataSource())
                .query("select * from user limit ? , ?" ,
                        new BeanListHandler<User>(User.class),
                        begin,
                        pageSize);
    }
}
