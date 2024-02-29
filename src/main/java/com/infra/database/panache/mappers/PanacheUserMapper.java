package com.infra.database.panache.mappers;

import com.domain.entities.bo.UserBO;
import com.domain.entities.vo.DateVO;
import com.domain.entities.vo.UuidVO;
import com.infra.database.panache.models.PanacheUser;
import com.infra.utils.Utils;

/**
 * 
 * @author Edevaldo
 */
public class PanacheUserMapper {

    public static PanacheUser toEntity(UserBO bo) {

        if (Utils.isNull(bo)) {
            return null;
        }

        var panacheUser = new PanacheUser();
        panacheUser.setDocument(bo.getDocument());
        panacheUser.setId(bo.getId().getValue());
        panacheUser.setName(bo.getName());
        panacheUser.setCreatedAt(bo.getCreatedAt().getValue());
        panacheUser.setEmail(bo.getEmail());
        panacheUser.setPhoneNumber(bo.getPhoneNumber());
        panacheUser.setUserAddress(PanacheAddressMapper.toEntity(bo.getAddress()));
        panacheUser.setPassword(bo.getPassword());

        return panacheUser;
    }

    public static UserBO toDomain(PanacheUser panacheUser) {

        if (Utils.isNull(panacheUser)) {
            return null;
        }

        return new UserBO(
                new UuidVO(panacheUser.getId().toString()),
                panacheUser.getName(),
                panacheUser.getDocument(),
                new DateVO(panacheUser.getCreatedAt()),
                panacheUser.getEmail(),
                panacheUser.getPhoneNumber(),
                PanacheAddressMapper.toDomain(panacheUser.getUserAddress()),
                panacheUser.getPassword());

    }

}
