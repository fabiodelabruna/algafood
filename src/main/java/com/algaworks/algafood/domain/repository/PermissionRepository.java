package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Permission;

import java.util.List;

public interface PermissionRepository {

    Permission save(Permission permission);

    Permission find(Long id);

    List<Permission> all();

    void remove(Permission permission);

}
