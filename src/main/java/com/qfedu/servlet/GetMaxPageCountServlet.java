package com.qfedu.servlet;

import com.john.service.impl.CountryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetMaxPageCountServlet")
public class GetMaxPageCountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
//这里我把每页的记录数量写死了——3
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        CountryServiceImpl countryService = new CountryServiceImpl();
        int dataCount = countryService.getDataCount();
        System.out.println(dataCount);//18
        int pageCount;
        if (dataCount%3 == 0) {
            pageCount = dataCount/3;
        } else {
            pageCount = dataCount/3 + 1;
        }
        System.out.println(pageCount);//6
        response.getWriter().print(pageCount);
    }
}
