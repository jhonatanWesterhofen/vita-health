package com.infra.database.panache.mappers;

import com.domain.entities.bo.UserBO;
import com.domain.entities.vo.UuidVO;
import com.infra.database.panache.models.PanacheUser;

public class PanacheUserMapper {

    public static PanacheUser toEntity(UserBO bo) {

        if (bo == null) {
            return null;
        }

        var panacheUser = new PanacheUser();
        panacheUser.setDocument(bo.getDocument());
        panacheUser.setId(bo.getId().getValue());
        panacheUser.setName(bo.getName());
        panacheUser.setCreatedAt(bo.getCreatedAt());
        panacheUser.setEmail(bo.getEmail());
        panacheUser.setPhoneNumber(bo.getPhoneNumber());
        panacheUser.setUserAddress(PanacheUserAddressMapper.toEntity(bo.getAddress()));
        panacheUser.setPassword(bo.getPassword());

        return panacheUser;
    }

    public static UserBO toDomain(PanacheUser panacheUser) {

        if (panacheUser == null) {
            return null;
        }

        return new UserBO(
                new UuidVO(panacheUser.getId().toString()),
                panacheUser.getName(),
                panacheUser.getDocument(),
                panacheUser.getCreatedAt(),
                panacheUser.getEmail(),
                panacheUser.getPhoneNumber(),
                PanacheUserAddressMapper.toDomain(panacheUser.getUserAddress()),
                panacheUser.getPassword());
    }
}