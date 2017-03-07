package com.maxcriser.emergencycalls.model;

import java.util.List;

public class CountryEm {

    private final String countryName;
    private final List<Em> mEmList;

    public String getCountryName() {
        return countryName;
    }

    public List<Em> getEmList() {
        return mEmList;
    }

    public CountryEm(final String pCountryName, final List<Em> pEmList) {
        this.countryName = pCountryName;
        this.mEmList = pEmList;
    }
}