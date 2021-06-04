package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Permission;
import com.algaworks.algafood.domain.repository.PermissionRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class PermissionRepositoryImpl implements PermissionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Permission save(final Permission permission) {
        return entityManager.merge(permission);
    }

    @Override
    public Permission find(final Long id) {
        return entityManager.find(Permission.class, id);
    }

    @Override
    public List<Permission> all() {
        return entityManager.createQuery("from Permission", Permission.class).getResultList();
    }

    @Transactional
    @Override
    public void remove(final Permission permission) {
        entityManager.remove(find(permission.getId()));
    }

}
