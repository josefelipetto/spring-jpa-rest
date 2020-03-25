package com.cinq.springjparest;

import com.cinq.springjparest.model.Country;
import com.cinq.springjparest.service.CountryService;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryServiceIntegrationTest {

    @Autowired
    private CountryService countryService;

    @Test
    @Order(1)
    public void whenSelectingAllCountries_shouldReturnAllCountries() {
        List<Country> countries = countryService.findAll();
        assertThat(countries, hasItem(
                hasProperty("name", is("Brazil"))
        ));
    }

    @Test
    @Order(2)
    public void whenLoadingCountries_shouldHaveAllCountries() {

        List<Country> countries = List.of(
                new Country(4, "Chile"),
                new Country(5, "Amsterdam")
        );

        countryService.loadCountries(countries);

        List<Country> updatedCountries = countryService.findAll();

        assertThat(updatedCountries, hasItem(
                hasProperty("name", is("Amsterdam"))
        ));


    }
}
