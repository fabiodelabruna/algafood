package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Kitchen;

import java.util.List;

public interface KitchenRepository {

    Kitchen save(Kitchen kitchen);

    Kitchen find(Long id);

    List<Kitchen> all();

    void remove(Kitchen kitchen);

}
