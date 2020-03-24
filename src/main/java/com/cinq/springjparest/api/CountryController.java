package com.cinq.springjparest.api;

import com.cinq.springjparest.model.Country;
import com.cinq.springjparest.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("rest/countries")
@RestController
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAllCountries()
    {
        return countryService.findAll();
    }

    @PostMapping
    public void loadCountries(@Valid @NonNull @RequestBody List<Country> countries) {
        this.countryService.loadCountries(countries);
    }


}
