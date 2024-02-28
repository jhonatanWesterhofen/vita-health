package com.domain.entities.bo;

import java.math.BigDecimal;

import com.domain.entities.enums.EnumProductSize;
import com.domain.entities.vo.UuidVO;

public class ProductBO {

    private UuidVO id;

    private BigDecimal amount;

    private String name;

    private EnumProductSize sizeProduct;

    public ProductBO(UuidVO id, BigDecimal amount, String name, EnumProductSize sizeProduct) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.sizeProduct = sizeProduct;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public EnumProductSize getSizeProduct() {
        return sizeProduct;
    }

    public UuidVO getId() {
        return id;
    }
}