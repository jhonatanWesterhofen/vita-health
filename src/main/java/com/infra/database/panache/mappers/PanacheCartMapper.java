package com.infra.database.panache.mappers;

import java.util.stream.Collectors;

import com.domain.entities.bo.CartBO;
import com.domain.entities.dto.CartDTO;
import com.domain.entities.mapper.ProductMapper;
import com.domain.entities.utils.ObjectUtil;
import com.domain.entities.vo.UuidVO;

public class PanacheCartMapper {

    public static CartBO toEntity(CartDTO dto) {

        if (ObjectUtil.isNull(dto)) {
            return null;
        }

        var products = dto.getProducts()
                .stream()
                .map(ProductMapper::toBO)
                .collect(Collectors.toList());

        return new CartBO(
                new UuidVO(dto.getId()),
                products);
    }

    public static CartDTO toEntity(CartBO dto) {

        if (ObjectUtil.isNull(dto)) {
            return null;
        }

        var products = dto.getProducts()
                .stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());

        var cart = new CartDTO();

        cart.setId(dto.getId().getValue().toString());
        cart.setProducts(products);

        return cart;
    }
}