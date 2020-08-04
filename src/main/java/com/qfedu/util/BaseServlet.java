package com.qfedu.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");  // 处理post请求乱码问题
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8"); // 处理响应乱码问题:字节流需getBytes("UTF-8")


        //1.获取请求中method参数的名字
        String methodName = req.getParameter("method");
        /*
         * 2.获取class的类对象，获取的是当前的servlet的类对象
         *
         *
         * 获取的是class类对象，并且是有泛型的约束的，要求必须是BaseServlet或者BaseServlet子类
         * */

        Class<? extends BaseServlet> aClass = this.getClass();//Action1Servlet
        /*
         * 3.根据methodName和类对象获取对应的方法,
         * add(HttpServletRequest request, HttpServletResponse response)
         * 业务逻辑代码都是需要HttpServletRequest， HttpServletResponse
         * */
        try {
            Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            /*
             * 4.z执行对应方法，第一个参数是当前类的对象，是BaseServlet或者是BaseServlete的子类
             *
             *
             * */

            method.invoke(this, req, resp);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
