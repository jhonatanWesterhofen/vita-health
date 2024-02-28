package com.services;

import com.infra.database.panache.repositories.PanacheCartRepository;
import com.infra.database.panache.repositories.PanacheUserRepository;

import jakarta.inject.Inject;

public abstract class AbstractService {

    @Inject
    PanacheUserRepository userRepository;

    @Inject
    PanacheCartRepository cartRepository;
}