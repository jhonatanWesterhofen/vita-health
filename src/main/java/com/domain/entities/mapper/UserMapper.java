package com.domain.entities.mapper;

import com.domain.entities.bo.UserBO;
import com.domain.entities.dto.UserDTO;
import com.domain.entities.vo.DateVO;
import com.domain.entities.vo.UuidVO;
import com.infra.utils.Utils;

/**
 * 
 * @author Edevaldo
 */
public class UserMapper {

    public static UserDTO toDTO(UserBO bo) {

        if (Utils.isNull(bo)) {
            return null;
        }

        var dto = new UserDTO();

        dto.setDocument(bo.getDocument());
        dto.setId(bo.getId().getValue().toString());
        dto.setName(bo.getName());
        dto.setCreatedAt(bo.getCreatedAt().getValue());
        dto.setEmail(bo.getEmail());
        dto.setPhoneNumber(bo.getPhoneNumber());
        dto.setAddress(AddressMapper.toDTO(bo.getAddress()));
        dto.setPassword(bo.getPassword());

        return dto;
    }

    public static UserBO toBO(UserDTO dto) {

        if (Utils.isNull(dto)) {
            return null;
        }

        return new UserBO(
                new UuidVO(dto.getId()),
                dto.getName(),
                dto.getDocument(),
                new DateVO(dto.getCreatedAt()),
                dto.getEmail(),
                dto.getPhoneNumber(),
                AddressMapper.toBO(dto.getAddress()),
                dto.getPassword());
    }
}