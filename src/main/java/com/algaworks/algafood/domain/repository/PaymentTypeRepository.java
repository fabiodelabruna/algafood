package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.PaymentType;

import java.util.List;

public interface PaymentTypeRepository {

    PaymentType save(PaymentType paymentType);

    PaymentType find(Long id);

    List<PaymentType> all();

    void remove(PaymentType paymentType);

}
