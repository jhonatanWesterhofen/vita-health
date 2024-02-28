package com.domain.entities.mapper;

import com.domain.entities.bo.UserBO;
import com.domain.entities.dto.UserDTO;
import com.domain.entities.vo.UuidVO;

public class UserMapper {

    public static UserDTO toDTO(UserBO bo) {

        if (bo == null) {
            return null;
        }

        var dto = new UserDTO();

        dto.setDocument(bo.getDocument());
        dto.setId(bo.getId().getValue().toString());
        dto.setName(bo.getName());
        dto.setCreatedAt(bo.getCreatedAt());
        dto.setEmail(bo.getEmail());
        dto.setPhoneNumber(bo.getPhoneNumber());
        dto.setAddress(UserAddressMapper.toDTO(bo.getAddress()));
        dto.setPassword(bo.getPassword());

        return dto;
    }

    public static UserBO toBO(UserDTO dto) {

        if (dto == null) {
            return null;
        }

        return new UserBO(
                new UuidVO(dto.getId()),
                dto.getName(),
                dto.getDocument(),
                dto.getCreatedAt(),
                dto.getEmail(),
                dto.getPhoneNumber(),
                UserAddressMapper.toBO(dto.getAddress()),
                dto.getPassword());
    }
}