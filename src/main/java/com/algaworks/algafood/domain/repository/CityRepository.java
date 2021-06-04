package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.City;

import java.util.List;

public interface CityRepository {

    City save(City city);

    City find(Long id);

    List<City> all();

    void remove(City city);

}
