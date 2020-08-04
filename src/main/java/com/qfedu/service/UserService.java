package com.qfedu.service;


import com.qfedu.entity.PageBean;
import com.qfedu.entity.User;

public interface UserService {
    PageBean<User> selectUserListByPage(Integer currentPage) throws Exception;
}
