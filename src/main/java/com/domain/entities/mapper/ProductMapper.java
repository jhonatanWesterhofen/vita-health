package com.domain.entities.mapper;

import com.domain.entities.bo.ProductBO;
import com.domain.entities.dto.ProductDTO;
import com.domain.entities.utils.ObjectUtil;
import com.domain.entities.vo.UuidVO;

public class ProductMapper {

    public static ProductDTO toDTO(ProductBO bo) {

        if (ObjectUtil.isNull(bo)) {
            return null;
        }

        var dto = new ProductDTO();

        dto.setAmount(bo.getAmount());
        dto.setId(bo.getId().getValue().toString());
        dto.setName(bo.getName());
        dto.setSizeProduct(bo.getSizeProduct());

        return dto;
    }

    public static ProductBO toBO(ProductDTO dto) {

        if (ObjectUtil.isNull(dto)) {
            return null;
        }

        return new ProductBO(
                new UuidVO(dto.getId()),
                dto.getAmount(),
                dto.getName(),
                dto.getSizeProduct());
    }
}