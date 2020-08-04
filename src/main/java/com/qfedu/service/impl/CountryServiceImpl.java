package com.qfedu.service.impl;



import com.qfedu.dao.CountryDao;
import com.qfedu.dao.impl.CountryDaoImpl;
import com.qfedu.entity.Country;
import com.qfedu.service.CountryService;

import java.util.List;

public class CountryServiceImpl implements CountryService {
    CountryDao countryDao = new CountryDaoImpl();
    @Override
    public List<Country> showCountry() {
        return countryDao.showCountry();
    }

    @Override
    public List<Country> showCountryLimited(int pageNo, int pageSize) {
        return countryDao.showCountryLimited(pageNo, pageSize);
    }

    @Override
    public int getDataCount() {
        return countryDao.getDataCount();
    }
}
