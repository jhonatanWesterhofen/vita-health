package com.domain.entities.utils;

import com.domain.entities.enums.EnumErrorCode;

public class ClassException extends RuntimeException {

    private String errorCode = "-1";

    public ClassException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ClassException(EnumErrorCode error) {
        super(error.getError());
        this.errorCode = error.getError();
    }

    public ClassException(EnumErrorCode error, Object... args) {
        super(StringUtil.stringPatternFormat(error.getError(), args));
        this.errorCode = error.getError();
    }

    public String getErrorCode() {
        return errorCode;
    }
}