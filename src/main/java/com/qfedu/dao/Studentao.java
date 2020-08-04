package com.qfedu.dao;

import com.qfedu.entity.Student;

import java.util.List;

public interface Studentao {
    int countStudent();
    List<Student> fuzzyStudent();
}
