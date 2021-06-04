package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Kitchen;
import com.algaworks.algafood.domain.repository.KitchenRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class KitchenRepositoryImpl implements KitchenRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Kitchen save(final Kitchen kitchen) {
        return entityManager.merge(kitchen);
    }

    @Override
    public Kitchen find(final Long id) {
        return entityManager.find(Kitchen.class, id);
    }

    @Override
    public List<Kitchen> all() {
        return entityManager.createQuery("from Kitchen", Kitchen.class).getResultList();
    }

    @Transactional
    @Override
    public void remove(final Kitchen kitchen) {
        entityManager.remove(find(kitchen.getId()));
    }

}
