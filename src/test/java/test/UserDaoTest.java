package test;

import com.qfedu.dao.UserDao;
import com.qfedu.dao.impl.UserDaoImpl;
import com.qfedu.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    private UserDao userDao;

    @Before
    public void init(){
        userDao = new UserDaoImpl();
    }

    @Test
    public void selectUserListByPage() throws Exception {
        Integer currentPage = 3;
        Integer pageSize = 3;
        Integer begin = (currentPage - 1) * pageSize;
        List<User> userList = userDao.selectUserListByPage(begin, pageSize);
        System.out.println(userList);
    }



}
