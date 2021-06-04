package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.model.KitchenXmlWrapper;
import com.algaworks.algafood.domain.model.Kitchen;
import com.algaworks.algafood.domain.repository.KitchenRepository;
import com.algaworks.algafood.domain.service.SaveKitchenService;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    private final KitchenRepository kitchenRepository;

    private final SaveKitchenService saveKitchenService;

    @Autowired
    public KitchenController(final KitchenRepository kitchenRepository, final SaveKitchenService saveKitchenService) {
        this.kitchenRepository = kitchenRepository;
        this.saveKitchenService = saveKitchenService;
    }

    @GetMapping
    public List<Kitchen> list() {
        return kitchenRepository.all();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public KitchenXmlWrapper listXml() {
        return new KitchenXmlWrapper(kitchenRepository.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kitchen> find(@PathVariable final Long id) {
        final Kitchen kitchen = kitchenRepository.find(id);

        if (kitchen != null) {
            return ResponseEntity.ok(kitchen);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Kitchen> save (@RequestBody final Kitchen kitchen) {
        final Kitchen storedKitchen = saveKitchenService.save(kitchen);
        return ResponseEntity.status(HttpStatus.CREATED).body(storedKitchen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kitchen> update(@PathVariable final Long id, @RequestBody final Kitchen kitchen) {
        final Kitchen actualKitchen = kitchenRepository.find(id);

        if (actualKitchen == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(kitchen, actualKitchen, "id");
        kitchenRepository.save(actualKitchen);
        return ResponseEntity.ok(actualKitchen);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Kitchen> remove(@PathVariable final Long id) {
        final Kitchen kitchen = kitchenRepository.find(id);

        if (kitchen == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            kitchenRepository.remove(kitchen);
            return ResponseEntity.noContent().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
