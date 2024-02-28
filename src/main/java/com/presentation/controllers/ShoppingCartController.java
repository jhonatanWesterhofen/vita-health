package com.presentation.controllers;

import org.jboss.resteasy.annotations.jaxrs.HeaderParam;

import com.domain.entities.dto.CartDTO;
import com.services.ShoppingCartService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/cart")
public class ShoppingCartController {

    @Inject
    ShoppingCartService cartService;

    @POST
    @Path("/add")
    public Response createShoppingCart(CartDTO dto) {

        return cartService.createShoppingCart(dto);
    }

    @GET
    @Path("/find")
    public Response findCart(@HeaderParam String document) {

        return null;
    }
}