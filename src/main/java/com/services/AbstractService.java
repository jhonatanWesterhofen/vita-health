package com.services;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.domain.repositories.IUserRepository;

import jakarta.inject.Inject;

/**
 * 
 * @author Edevaldo
 */
public abstract class AbstractService {

    @Inject
    IUserRepository userRepository;

    @ConfigProperty(name = "encrypt-key")
    String encryptKey;
}