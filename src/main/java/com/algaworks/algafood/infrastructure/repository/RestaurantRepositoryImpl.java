package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Kitchen;
import com.algaworks.algafood.domain.model.Restaurant;
import com.algaworks.algafood.domain.repository.KitchenRepository;
import com.algaworks.algafood.domain.repository.RestaurantRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Restaurant save(final Restaurant restaurant) {
        return entityManager.merge(restaurant);
    }

    @Override
    public Restaurant find(final Long id) {
        return entityManager.find(Restaurant.class, id);
    }

    @Override
    public List<Restaurant> all() {
        return entityManager.createQuery("from Restaurant", Restaurant.class).getResultList();
    }

    @Transactional
    @Override
    public void remove(final Restaurant restaurant) {
        entityManager.remove(find(restaurant.getId()));
    }

}
