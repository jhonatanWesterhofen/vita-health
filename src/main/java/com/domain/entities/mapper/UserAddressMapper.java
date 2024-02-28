package com.domain.entities.mapper;

import com.domain.entities.bo.UserAddressBO;
import com.domain.entities.dto.UserAddressDTO;
import com.domain.entities.vo.UuidVO;

public class UserAddressMapper {

    public static UserAddressDTO toDTO(UserAddressBO bo) {

        if (bo == null) {
            return null;
        }

        var dto = new UserAddressDTO();

        dto.setId(bo.getId().getValue().toString());
        dto.setAddressCity(bo.getAddressCity());
        dto.setAddressComplement(bo.getAddressComplement());
        dto.setAddressHouseNumber(bo.getAddressHouseNumber());
        dto.setAddressNeighborhood(bo.getAddressNeighborhood());
        dto.setAddressStreet(bo.getAddressStreet());

        return dto;
    }

    public static UserAddressBO toBO(UserAddressDTO dto) {

        if (dto == null) {
            return null;
        }

        return new UserAddressBO(
                new UuidVO(dto.getId()),
                dto.getAddressCity(),
                dto.getAddressNeighborhood(),
                dto.getAddressStreet(),
                dto.getAddressComplement(),
                dto.getAddressHouseNumber());
    }
}