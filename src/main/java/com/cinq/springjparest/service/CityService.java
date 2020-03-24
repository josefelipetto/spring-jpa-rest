package com.cinq.springjparest.service;

import com.cinq.springjparest.dao.CityRepository;
import com.cinq.springjparest.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityDAO;

    @Autowired
    public CityService(CityRepository cityDAO) {
        this.cityDAO = cityDAO;
    }

    public List<City> findByCountryName(String name) {
        return cityDAO.findCitiesByCountry_NameContains(name);
    }

    public List<City> findAll() {
        return (List<City>) cityDAO.findAll();
    }

    public void loadCities(List<City> cities) {
        cities.forEach(cityDAO::save);
    }
}
