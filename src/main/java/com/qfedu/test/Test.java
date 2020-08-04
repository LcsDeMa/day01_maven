package com.qfedu.test;

import com.qfedu.entity.User;
import com.qfedu.util.BaseDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: Lcs
 * @Date: 2020/7/4 17:31
 * @Description:
 */
public class Test {
    @org.junit.Test
    public void testDb(){
        String sql = "select * from user where id = ?";
        Object[] obj = {1};
        try {
            List<User> users = new BaseDao().query(sql, obj, User.class);
            System.out.println(users.get(0).toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
