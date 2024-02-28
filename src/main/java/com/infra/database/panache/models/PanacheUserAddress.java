package com.infra.database.panache.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "API_USER_ADDRESS")
public class PanacheUserAddress extends PanacheEntityBase {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "ADDRESS_CITY")
    private String addressCity;

    @Column(name = "ADDRESS_NEIGHBORHOOD")
    private String addressNeighborhood;

    @Column(name = "ADDRESS_STREET")
    private String addressStreet;

    @Column(name = "ADDRESS_COMPLEMENT")
    private String addressComplement;

    @Column(name = "ADDRESS_HOUSE_NUMBER")
    private String addressHouseNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressNeighborhood() {
        return addressNeighborhood;
    }

    public void setAddressNeighborhood(String addressNeighborhood) {
        this.addressNeighborhood = addressNeighborhood;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }

    public String getAddressHouseNumber() {
        return addressHouseNumber;
    }

    public void setAddressHouseNumber(String addressHouseNumber) {
        this.addressHouseNumber = addressHouseNumber;
    }
}