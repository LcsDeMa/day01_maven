package com.qfedu.dao;


import com.qfedu.entity.Country;

import java.util.List;

public interface CountryDao {
    public List<Country> showCountry();
    public List<Country> showCountryLimited(int pageNo, int pageSize);
    public int getDataCount();
}
