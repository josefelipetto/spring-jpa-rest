package com.cinq.springjparest.service;

import com.cinq.springjparest.dao.CityRepository;
import com.cinq.springjparest.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findByCountryName(String name) {
        return cityRepository.findCitiesByCountry_NameContains(name);
    }

    public List<City> findAll() {
        return (List<City>) cityRepository.findAll();
    }

    public void loadCities(List<City> cities) {
        cities.forEach(cityRepository::save);
    }

    public Optional<City> findById(int id) { return cityRepository.findById(id); }
}
