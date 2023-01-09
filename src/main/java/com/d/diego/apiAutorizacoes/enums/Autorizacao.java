package com.d.diego.apiAutorizacoes.enums;

import com.d.diego.apiAutorizacoes.dto.ObjectDTO;
import com.d.diego.apiAutorizacoes.services.interfaces.ImplEnum;

import java.util.ArrayList;
import java.util.List;

public enum Autorizacao implements ImplEnum {

    SIM("Sim"),
    NAO("Não");

    private static final Autorizacao[] ENUMS = Autorizacao.values();

    private String descricao;

    private Autorizacao(final String descricao) {
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
        final ArrayList<ObjectDTO> objects;
        objects = new ArrayList<>();
        final Autorizacao[] values = values();

        for (final Autorizacao autorizacao : values) {
            objects.add(new ObjectDTO(autorizacao.name(), autorizacao.descricao));
        }

        return (List) objects;
    }
}
