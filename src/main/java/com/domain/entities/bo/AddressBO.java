package com.domain.entities.bo;

import com.domain.entities.vo.UuidVO;

/**
 * 
 * @author Edevaldo
 */
public class AddressBO {

    private UuidVO id;

    private String addressCity;

    private String addressNeighborhood;

    private String addressStreet;

    private String addressComplement;

    private String addressHouseNumber;

    public AddressBO(UuidVO id, String addressCity, String addressNeighborhood, String addressStreet,
            String addressComplement, String addressHouseNumber) {
        this.id = id;
        this.addressCity = addressCity;
        this.addressNeighborhood = addressNeighborhood;
        this.addressStreet = addressStreet;
        this.addressComplement = addressComplement;
        this.addressHouseNumber = addressHouseNumber;
    }

    public UuidVO getId() {
        return id;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public String getAddressNeighborhood() {
        return addressNeighborhood;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public String getAddressHouseNumber() {
        return addressHouseNumber;
    }

}