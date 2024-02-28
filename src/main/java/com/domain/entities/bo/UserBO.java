package com.domain.entities.bo;

import java.time.LocalDateTime;

import com.domain.entities.enums.EnumErrorCode;
import com.domain.entities.utils.ClassException;
import com.domain.entities.utils.StringUtil;
import com.domain.entities.vo.UuidVO;

public class UserBO {

    private UuidVO id;

    private String name;

    private String document;

    private LocalDateTime createdAt;

    private String email;

    private String phoneNumber;

    private String password;

    private UserAddressBO address;

    public UserBO(UuidVO id, String name, String document, LocalDateTime createdAt, String email, String phoneNumber,
            UserAddressBO address, String password) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.createdAt = createdAt;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;

        validate();
    }

    public String getPassword() {
        return password;
    }

    public UuidVO getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserAddressBO getAddress() {
        return address;
    }

    public void validate() {

        if (StringUtil.isNullOrEmpty(this.name)) {
            throw new ClassException(EnumErrorCode.CAMPO_OBRIGATORIO, "Nome");
        }

        if (StringUtil.isNullOrEmpty(this.document)) {
            throw new ClassException(EnumErrorCode.CAMPO_OBRIGATORIO, "Documento");
        }

        if (!this.email.contains("@")) {
            throw new ClassException(EnumErrorCode.CAMPO_INVALIDO, "Email");
        }
    }
}