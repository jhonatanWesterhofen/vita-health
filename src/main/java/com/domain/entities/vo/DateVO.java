package com.domain.entities.vo;

import java.time.LocalDateTime;

public class DateVO {

    private LocalDateTime value;

    public DateVO(final LocalDateTime date) {
        this.value = date != null ? date : LocalDateTime.now();
    }

    public LocalDateTime getValue() {
        return value;
    }
}