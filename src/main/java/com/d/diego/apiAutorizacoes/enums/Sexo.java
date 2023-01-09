package com.d.diego.apiAutorizacoes.enums;

import com.d.diego.apiAutorizacoes.dto.ObjectDTO;
import com.d.diego.apiAutorizacoes.services.interfaces.ImplEnum;

import java.util.ArrayList;
import java.util.List;

public enum Sexo implements ImplEnum {

    M("Masculino"),
    F("Feminino");

    private static final Sexo[] ENUMS = Sexo.values();

    private String descricao;

    private Sexo(final String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public ObjectDTO getObject() {
        return ObjectDTO.builder().value(this.name()).label(this.descricao).build();
    }

    public static List objects() {
        final ArrayList<ObjectDTO> objects = new ArrayList<>();
        final Sexo[] values = values();

        for (final Sexo sexo : values) {
            objects.add(new ObjectDTO(sexo.name(), sexo.descricao));
        }

        return (List) objects;
    }


}
