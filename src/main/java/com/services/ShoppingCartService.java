package com.services;

import com.domain.entities.dto.CartDTO;
import com.domain.usecases.CreateCartAndAddNewProduct;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@ApplicationScoped
public class ShoppingCartService extends AbstractService {

    @Transactional
    public Response createShoppingCart(CartDTO dto) {

        var createCart = new CreateCartAndAddNewProduct(cartRepository);
        var cartDTO = createCart.execute(dto);

        return Response.status(Status.OK).entity(cartDTO).build();
    }
}