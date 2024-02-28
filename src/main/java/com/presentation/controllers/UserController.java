package com.presentation.controllers;

import org.jboss.resteasy.annotations.jaxrs.HeaderParam;

import com.domain.entities.dto.UserDTO;
import com.services.UserService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class UserController {

    @Inject
    UserService userService;

    @POST
    @Path("/add")
    public Response createUser(UserDTO dto, @HeaderParam String factoryTeste) {

        return userService.createUser(dto, factoryTeste);
    }

    @GET
    @Path("/find")
    public Response findUser(@HeaderParam String document) {

        return userService.findUser(document);
    }

    @GET
    @Path("/login")
    public Response makeLogin(@HeaderParam String email, @HeaderParam String password) {

        return userService.makeLogin(email, password);
    }
}