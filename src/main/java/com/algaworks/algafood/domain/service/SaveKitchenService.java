package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.model.Kitchen;
import com.algaworks.algafood.domain.repository.KitchenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveKitchenService {

    private final KitchenRepository kitchenRepository;

    @Autowired
    public SaveKitchenService(final KitchenRepository kitchenRepository) {
        this.kitchenRepository = kitchenRepository;
    }

    public Kitchen save(final Kitchen kitchen) {
        return kitchenRepository.save(kitchen);
    }

}
