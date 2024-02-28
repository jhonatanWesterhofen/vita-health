package com.domain.entities.enums;

public enum EnumProductSize implements IEnum {

    TAMANHO_P("P", "Tamanho P"),
    TAMANHO_M("M", "Tamanho M"),
    TAMANHO_G("G", "Tamanho G");

    private EnumProductSize(String key, String description) {
    }

    @Override
    public String getKey() {
        throw new UnsupportedOperationException("Unimplemented method 'getKey'");
    }

    @Override
    public boolean containsInEnum(String key) {
        throw new UnsupportedOperationException("Unimplemented method 'containsInEnum'");
    }
}