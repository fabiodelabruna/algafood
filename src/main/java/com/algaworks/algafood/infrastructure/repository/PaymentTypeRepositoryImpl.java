package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.PaymentType;
import com.algaworks.algafood.domain.repository.PaymentTypeRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class PaymentTypeRepositoryImpl implements PaymentTypeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public PaymentType save(final PaymentType paymentType) {
        return entityManager.merge(paymentType);
    }

    @Override
    public PaymentType find(final Long id) {
        return entityManager.find(PaymentType.class, id);
    }

    @Override
    public List<PaymentType> all() {
        return entityManager.createQuery("from PaymentType", PaymentType.class).getResultList();
    }

    @Transactional
    @Override
    public void remove(final PaymentType paymentType) {
        entityManager.remove(find(paymentType.getId()));
    }

}
