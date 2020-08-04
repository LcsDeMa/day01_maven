package test;

import com.qfedu.entity.PageBean;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void init(){
        userService = new UserServiceImpl();
    }

    @Test
    public void selectUserListByPage() throws Exception {
        PageBean<User> pageBean = userService.selectUserListByPage(2);
        System.out.println(pageBean);
    }



}
