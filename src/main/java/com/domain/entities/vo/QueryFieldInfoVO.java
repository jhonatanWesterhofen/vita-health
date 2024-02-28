package com.domain.entities.vo;

public class QueryFieldInfoVO {

    private String fieldName;

    private Object fieldValue;

    public QueryFieldInfoVO(String fieldName, Object fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}