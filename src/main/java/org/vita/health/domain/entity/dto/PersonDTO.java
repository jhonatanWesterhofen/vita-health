package org.vita.health.domain.entity.dto;

import java.time.LocalDateTime;

public class PersonDTO {

    private String name;

    private String firstName;

    private String document;

    private LocalDateTime birthday;

    private boolean isPacient;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public boolean isPacient() {
        return isPacient;
    }

    public void setPacient(boolean isPacient) {
        this.isPacient = isPacient;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}