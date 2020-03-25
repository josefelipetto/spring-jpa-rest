package com.cinq.springjparest.service;

import com.cinq.springjparest.dao.CountryRepository;
import com.cinq.springjparest.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findAll()
    {
        return (List<Country>) countryRepository.findAll();
    }

    public void loadCountries(List<Country> countries) {
        countries.forEach(countryRepository::save);
    }

    public Optional<Country> findById(int id) { return countryRepository.findById(id); }
}
