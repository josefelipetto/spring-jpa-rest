package com.cinq.springjparest;

import com.cinq.springjparest.model.City;
import com.cinq.springjparest.model.Country;
import com.cinq.springjparest.service.CityService;
import com.cinq.springjparest.service.CountryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceIntegrationTest {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @Test
    public void whenSelectionAllCities_shouldReturnAllCities() {
        List<City> all = cityService.findAll();

        assertNotNull(all);
        assertTrue(all.size() > 0);
    }

    @Test
    public void whenSelectingAllCities_shouldHaveCuritibaAtSomeElement() {
        List<City> all = cityService.findAll();

        assertThat(all, hasItem(
                hasProperty("name", is("Curitiba"))
        ));
    }

    @Test
    public void whenPassingCountryParam_shouldReturnCitiesFromThatCountry() {
        List<City> cities = cityService.findByCountryName("Braz");

        assertThat(cities, hasItem(
                hasProperty("name", is("Curitiba"))
        ));

        assertThat(cities, not(
                hasItem(
                        hasProperty("name", is("New York")))
                )
        );
    }

    @Test
    public void whenInsertingNewCity_shouldHaveThatCityOnTheCollection() {

        Optional<Country> mockCountry = countryService.findById(1);


        List<City> citiesList = List.of(
                new City(4,"Paranagua", mockCountry.isEmpty() ? null : mockCountry.get()),
                new City(5,"Londrina", mockCountry.isEmpty() ? null : mockCountry.get())
        );

        cityService.loadCities(citiesList);

        Optional<City> paranagua = cityService.findById(4);
        assertTrue(paranagua.isPresent());

        Optional<City> londrina = cityService.findById(5);
        assertTrue(londrina.isPresent());
    }



}
