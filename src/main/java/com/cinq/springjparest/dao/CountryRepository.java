package com.cinq.springjparest.dao;

import com.cinq.springjparest.model.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Integer> {

}
