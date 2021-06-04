package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.State;
import com.algaworks.algafood.domain.repository.StateRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class StateRepositoryImpl implements StateRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public State save(final State state) {
        return entityManager.merge(state);
    }

    @Override
    public State find(final Long id) {
        return entityManager.find(State.class, id);
    }

    @Override
    public List<State> all() {
        return entityManager.createQuery("from State", State.class).getResultList();
    }

    @Transactional
    @Override
    public void remove(final State state) {
        entityManager.remove(find(state.getId()));
    }

}
