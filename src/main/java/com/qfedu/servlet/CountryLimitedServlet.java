package com.qfedu.servlet;


import com.qfedu.entity.Country;
import com.qfedu.service.CountryService;
import com.qfedu.service.impl.CountryServiceImpl;
import com.qfedu.test.PageUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CountryLimitedServlet")
public class CountryLimitedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        CountryService countryService = new CountryServiceImpl();
        //获取前端传来的pageCount
        String pageNoTemp = request.getParameter("data");
        System.out.println(pageNoTemp);//1
        //转为int类型
        int pageNo = Integer.parseInt(pageNoTemp);
        //设置PageUtil对象的属性
        PageUtil pageUtil = new PageUtil();
        //这里同样写死——3
        //写多少都一样，3的话是每页3条，4的话是每页4条
        int pageSize = 3;
        int dataCount = countryService.getDataCount();
        pageUtil.setPageSize(pageSize);
        pageUtil.setPageNo(pageNo);
        pageUtil.setDataCount(dataCount);
        pageUtil.setPageCount(pageUtil.getPageCount());
        List<Country> countryList = countryService.showCountryLimited(pageNo, pageSize);
        JSONArray jsonArray = JSONArray.fromObject(countryList);
        response.getWriter().print(jsonArray);
    }
}
