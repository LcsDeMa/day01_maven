package com.qfedu.dao.impl;

import com.qfedu.dao.CountryDao;
import com.qfedu.entity.Country;
import com.qfedu.test.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends BaseDao implements CountryDao {
    @Override
    public List<Country> showCountry() {
        String sql = "select * from country";
        Object[] obj = {};
        List<Country> countryList = new ArrayList();
        try {
            ResultSet rs = this.select(sql, obj);
            while (rs.next()) {
                Country country = new Country();
                country.setName(rs.getString(1));
                country.setFullName(rs.getString(2));
                country.setLocation(rs.getString(3));
                country.setCapital(rs.getString(4));
                country.setLanguage(rs.getString(5));
                countryList.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countryList;  
    }

    @Override
    public List<Country> showCountryLimited(int pageNo, int pageSize) {
        String sql = "select * from country limit ?,?";
        Object[] obj = {(pageNo-1)*pageSize, pageSize};
        List<Country> countryList = new ArrayList<>();
        try {
            ResultSet rs = this.select(sql, obj);
            while (rs.next()) {
                Country country = new Country();
                country.setName(rs.getString(1));
                country.setFullName(rs.getString(2));
                country.setLocation(rs.getString(3));
                country.setCapital(rs.getString(4));
                country.setLanguage(rs.getString(5));
                countryList.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countryList;
    }

    @Override
    public int getDataCount() {
        String sql = "select count(1) from country";
        Object[] obj = {};
        int dataCount = 0;
        try {
            ResultSet rs = this.select(sql, obj);
            while (rs.next()) {
                dataCount = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataCount;
    }
}
