package com.domain.entities.dto;

import java.math.BigDecimal;

import com.domain.entities.enums.EnumProductSize;

public class ProductDTO {

    private String id;

    private BigDecimal amount;

    private String name;

    private EnumProductSize sizeProduct;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumProductSize getSizeProduct() {
        return sizeProduct;
    }

    public void setSizeProduct(EnumProductSize sizeProduct) {
        this.sizeProduct = sizeProduct;
    }
}