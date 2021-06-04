package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.City;
import com.algaworks.algafood.domain.repository.CityRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class CityRepositoryImpl implements CityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public City save(final City city) {
        return entityManager.merge(city);
    }

    @Override
    public City find(final Long id) {
        return entityManager.find(City.class, id);
    }

    @Override
    public List<City> all() {
        return entityManager.createQuery("from City", City.class).getResultList();
    }

    @Transactional
    @Override
    public void remove(final City city) {
        entityManager.remove(find(city.getId()));
    }

}
