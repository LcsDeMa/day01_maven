package com.qfedu.service.impl;


import com.qfedu.dao.UserDao;

import com.qfedu.dao.impl.UserDaoImpl;
import com.qfedu.entity.PageBean;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public PageBean<User> selectUserListByPage(Integer currentPage) throws Exception {
        PageBean<User> pageBean = new PageBean<>();
        //    currentPage;当前页数
        pageBean.setCurrentPage(currentPage);
        //    totalSize;总记录数
        UserDao userDao = new UserDaoImpl();
        Integer totalSize = userDao.selectTotalSize();
        pageBean.setTotalSize(totalSize);
        //    pageSize;每页记录数
        Integer pageSize = 2;
        pageBean.setPageSize(pageSize);
        //    totalPage:总页数  = 总记录数 / 每页记录数
        Integer totalPage = ( totalSize % pageSize == 0 ) ? ( totalSize / pageSize ) : (totalSize / pageSize + 1 ) ;
        pageBean.setTotalPage(totalPage);
        //    list;当前页数据
        //select * from tb_user limit ? , ?
        //第一个? : 开始脚标 = (当前页数 - 1) * 每页记录数
        //第二个? : 查询多少个 (每页记录数) pageSize
        Integer begin = (currentPage - 1) * pageSize;
        List<User> list = userDao.selectUserListByPage(begin, pageSize);
        pageBean.setList(list);
        return pageBean;
    }
}
