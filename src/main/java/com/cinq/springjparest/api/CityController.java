package com.cinq.springjparest.api;

import com.cinq.springjparest.model.City;
import com.cinq.springjparest.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("rest/cities")
@RestController
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getByCountryName(@RequestParam Optional<String> country) {
        return country.isEmpty() ? cityService.findAll() : cityService.findByCountryName(country.get());
    }

    @PostMapping
    public void loadsCities(@RequestBody List<City> cities) {
        cityService.loadCities(cities);
    }
}
