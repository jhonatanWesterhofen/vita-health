package com.domain.entities.mapper;

import java.util.stream.Collectors;

import com.domain.entities.bo.CartBO;
import com.domain.entities.dto.CartDTO;
import com.domain.entities.utils.ObjectUtil;
import com.domain.entities.vo.UuidVO;

public class CartMapper {

    public static CartDTO toDTO(CartBO bo) {

        if (ObjectUtil.isNull(bo)) {
            return null;
        }

        var products = bo.getProducts()
                .stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());

        var dto = new CartDTO();

        dto.setId(bo.getId().getValue().toString());
        dto.setProducts(products);

        return dto;
    }

    public static CartBO toBO(CartDTO dto) {

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
}