package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    Restaurant find(Long id);

    List<Restaurant> all();

    void remove(Restaurant restaurant);

}
