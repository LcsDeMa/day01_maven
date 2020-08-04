package com.qfedu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet" ,urlPatterns = "/base")
public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = request.getParameter("methodName");
        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            if (null != method) {
                String returnValue = (String) method.invoke(this, request, response);
                if (null != returnValue) {
                    //资源跳转
                    int index = returnValue.lastIndexOf(":");
                    if (-1 == index) {
                        //没有":"，就直接请求转发
                        request.getRequestDispatcher(returnValue).forward(request,response);
                    } else {
                        //有“:”
                        String path = returnValue.substring(index+1);
                        if (returnValue.startsWith("redirect")) {
                            //重定向
                            response.sendRedirect(request.getContextPath()+path);
                        } else if (returnValue.startsWith("forward")){
                            //请求转发
                            request.getRequestDispatcher(path).forward(request,response);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
