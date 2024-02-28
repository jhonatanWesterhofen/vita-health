package com.infra.database.panache.mappers;

import com.domain.entities.bo.UserAddressBO;
import com.domain.entities.vo.UuidVO;
import com.infra.database.panache.models.PanacheUserAddress;

public class PanacheUserAddressMapper {

    public static PanacheUserAddress toEntity(UserAddressBO bo) {

        if (bo == null) {
            return null;
        }

        var panacheUser = new PanacheUserAddress();
        panacheUser.setId(bo.getId().getValue().toString());
        panacheUser.setAddressCity(bo.getAddressCity());
        panacheUser.setAddressComplement(bo.getAddressComplement());
        panacheUser.setAddressHouseNumber(bo.getAddressHouseNumber());
        panacheUser.setAddressNeighborhood(bo.getAddressNeighborhood());
        panacheUser.setAddressStreet(bo.getAddressStreet());

        return panacheUser;
    }

    public static UserAddressBO toDomain(PanacheUserAddress bo) {

        if (bo == null) {
            return null;
        }

        return new UserAddressBO(
                new UuidVO(bo.getId()),
                bo.getAddressCity(),
                bo.getAddressNeighborhood(),
                bo.getAddressStreet(),
                bo.getAddressComplement(),
                bo.getAddressHouseNumber());
    }
}