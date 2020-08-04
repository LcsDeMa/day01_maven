package com.qfedu.dao;



import com.qfedu.entity.User;

import java.util.List;

public interface UserDao {

    /**
     * 查询总记录数
     * @return
     * @throws Exception
     */
    Integer selectTotalSize() throws Exception;

    List<User> selectUserListByPage(Integer begin, Integer pageSize) throws Exception;

}
