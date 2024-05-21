package com.jotasantos.springbootcrud.springbootcrud.enums;

public enum EnumStatusUsuario {
    ATIVO("Ativo"),
    INATIVO("Inativo"),
    SUSPENSO("Suspenso");

    private final String descricao;

    EnumStatusUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
