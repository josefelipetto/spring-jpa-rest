package com.cinq.springjparest.dao;

import com.cinq.springjparest.model.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Integer> {
    List<City> findCitiesByCountry_NameContains(String name);
}
