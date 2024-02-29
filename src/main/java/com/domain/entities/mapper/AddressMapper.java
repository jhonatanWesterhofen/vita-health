package com.domain.entities.mapper;

import com.domain.entities.bo.AddressBO;
import com.domain.entities.dto.AddressDTO;
import com.domain.entities.vo.UuidVO;

/**
 * 
 * @author Edevaldo
 */
public class AddressMapper {

    public static AddressDTO toDTO(AddressBO bo) {

        if (bo == null) {
            return null;
        }

        var dto = new AddressDTO();

        dto.setId(bo.getId().getValue().toString());
        dto.setAddressCity(bo.getAddressCity());
        dto.setAddressComplement(bo.getAddressComplement());
        dto.setAddressHouseNumber(bo.getAddressHouseNumber());
        dto.setAddressNeighborhood(bo.getAddressNeighborhood());
        dto.setAddressStreet(bo.getAddressStreet());

        return dto;
    }

    public static AddressBO toBO(AddressDTO dto) {

        if (dto == null) {
            return null;
        }

        return new AddressBO(
                new UuidVO(dto.getId()),
                dto.getAddressCity(),
                dto.getAddressNeighborhood(),
                dto.getAddressStreet(),
                dto.getAddressComplement(),
                dto.getAddressHouseNumber());
    }
}