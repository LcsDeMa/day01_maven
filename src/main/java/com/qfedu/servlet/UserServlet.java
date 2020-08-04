package com.qfedu.servlet;

import com.qfedu.entity.PageBean;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServlet" ,urlPatterns = {"/user","*.user"})
public class UserServlet extends BaseServlet {
    
    private UserService userService = new UserServiceImpl();

    /**
     * 获取当前页数
     * @param currentPageStr
     * @return
     */
    public Integer getCurrentPage(String currentPageStr){
        if (null == currentPageStr) {
            //如果没有传递当前页数，默认就是第一页
            currentPageStr = "1";
        }
        Integer currentPage = Integer.parseInt(currentPageStr);
        return currentPage;
    }


    /**
     * 分页查询
     * @param request
     * @param response
     */
    public String selectUserListByPage(HttpServletRequest request, HttpServletResponse response){
        String currentPageStr = request.getParameter("currentPage");
        Integer currentPage = getCurrentPage(currentPageStr);
        //调用UserService，传递currentPage
        try {
            PageBean<User> pageBean = userService.selectUserListByPage(currentPage);
            System.out.println(pageBean);
            request.setAttribute("pageBean",pageBean);
            //转发到用户列表页面
            return "/userList.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/index.jsp";

    }

}
