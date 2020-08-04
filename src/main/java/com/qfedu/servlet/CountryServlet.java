package com.qfedu.servlet;

import com.john.entity.Country;
import com.john.service.CountryService;
import com.john.service.impl.CountryServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CountryServlet")
public class CountryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        CountryService countryService = new CountryServiceImpl();
        List<Country> countryList = countryService.showCountry();
        JSONArray jsonArray = JSONArray.fromObject(countryList);
        response.getWriter().print(jsonArray);
    }
}
