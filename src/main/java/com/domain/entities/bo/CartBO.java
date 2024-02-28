package com.domain.entities.bo;

import java.util.List;

import com.domain.entities.vo.UuidVO;

public class CartBO {

    private UuidVO id;

    private List<ProductBO> products;

    public CartBO(UuidVO id, List<ProductBO> products) {
        this.id = id;
        this.products = products;
    }

    public UuidVO getId() {
        return id;
    }

    public List<ProductBO> getProducts() {
        return products;
    }
}