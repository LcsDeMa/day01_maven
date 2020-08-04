package com.qfedu.service;


import com.qfedu.entity.Country;

import java.util.List;

public interface CountryService {
    public List<Country> showCountry();
    public List<Country> showCountryLimited(int pageNo, int pageSize);
    public int getDataCount();
}
