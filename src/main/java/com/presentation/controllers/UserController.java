package com.presentation.controllers;

import org.jboss.resteasy.annotations.jaxrs.HeaderParam;

import com.domain.entities.dto.UserDTO;
import com.services.UserService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 * 
 * @author Edevaldo
 */
@Path("vitahealth/user")
public class UserController {

    @Inject
    UserService userService;

    @POST
    @Path("/create")
    public Response createUser(UserDTO dto) {
        return userService.createUser(dto);
    }

    @GET
    @Path("/login")
    public Response login(@HeaderParam String email, @HeaderParam String password) {
        return userService.login(email, password);
    }

    @GET
    @Path("/recover")
    public Response recover(@HeaderParam String email) {
        return userService.recover(email);
    }

}
