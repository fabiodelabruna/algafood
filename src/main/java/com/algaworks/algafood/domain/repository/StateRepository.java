package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.State;

import java.util.List;

public interface StateRepository {

    State save(State state);

    State find(Long id);

    List<State> all();

    void remove(State state);

}
