package com.infra.database.panache.mappers;

import com.domain.entities.bo.AddressBO;
import com.domain.entities.vo.UuidVO;
import com.infra.database.panache.models.PanacheAddress;
import com.infra.utils.Utils;

/**
 * 
 * @author Edevaldo
 */
public class PanacheAddressMapper {

    public static PanacheAddress toEntity(AddressBO bo) {

        if (Utils.isNull(bo)) {
            return null;
        }

        var panacheUser = new PanacheAddress();
        panacheUser.setId(bo.getId().getValue());
        panacheUser.setAddressCity(bo.getAddressCity());
        panacheUser.setAddressComplement(bo.getAddressComplement());
        panacheUser.setAddressHouseNumber(bo.getAddressHouseNumber());
        panacheUser.setAddressNeighborhood(bo.getAddressNeighborhood());
        panacheUser.setAddressStreet(bo.getAddressStreet());

        return panacheUser;
    }

    public static AddressBO toDomain(PanacheAddress panache) {

        if (Utils.isNull(panache)) {
            return null;
        }

        return new AddressBO(
                new UuidVO(panache.getId().toString()),
                panache.getAddressCity(),
                panache.getAddressNeighborhood(),
                panache.getAddressStreet(),
                panache.getAddressComplement(),
                panache.getAddressHouseNumber());
    }
}