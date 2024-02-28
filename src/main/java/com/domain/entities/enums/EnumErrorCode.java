package com.domain.entities.enums;

public enum EnumErrorCode implements IEnum {

    CAMPO_OBRIGATORIO("001", "Campo {0} é obrigatorio!", 400),
    CAMPO_INVALIDO("001", "Campo {0} é inválido!", 400),
    PESSOA_NAO_ENCONTRADA("001", "Pessoa não encontrada!", 400),
    EMAIL_INVALIDO("001", "O email informado esta incorreto!", 400),
    SENHA_INVALIDA("001", "A senha informado esta incorreta!", 400),
    USUARIO_JA_EXISTE("002", "Usuario já existente!", 400);

    private final String error;
    private final int httpStatus;

    private EnumErrorCode(String key, String error, int httpStatus) {
        this.error = error;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getKey() {
        throw new UnsupportedOperationException("Unimplemented method 'getKey'");
    }

    @Override
    public boolean containsInEnum(String key) {
        throw new UnsupportedOperationException("Unimplemented method 'containsInEnum'");
    }

    public String getError() {
        return error;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}