package com.qfedu.dao.impl;

import com.qfedu.dao.Studentao;
import com.qfedu.entity.Student;
import com.qfedu.util.BaseDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: Lcs
 * @Date: 2020/7/4 17:49
 * @Description:
 */
public class StudentaoImpl extends BaseDao implements Studentao {
    @Override
    public int countStudent() {
        String sql = "select * from student";
        Object[] obj = {};
        int i= 0;
        try {
            List<Student> studentList = this.query(sql, obj, Student.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Student> fuzzyStudent() {
        return null;
    }
}
