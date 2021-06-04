package com.algaworks.algafood.api.model;

import com.algaworks.algafood.domain.model.Kitchen;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

import lombok.Data;
import lombok.NonNull;

@Data
@JacksonXmlRootElement(localName = "kitchens")
public class KitchenXmlWrapper {

    @NonNull
    @JacksonXmlProperty(localName = "kitchen")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Kitchen> kitchens;

}
