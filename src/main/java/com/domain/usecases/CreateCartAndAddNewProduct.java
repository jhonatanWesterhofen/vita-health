package com.domain.usecases;

import com.domain.entities.dto.CartDTO;
import com.domain.entities.mapper.CartMapper;
import com.domain.repositories.ICartRepository;

public class CreateCartAndAddNewProduct {

    ICartRepository cartRepository;

    public CreateCartAndAddNewProduct(ICartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public CartDTO execute(CartDTO dto) {

        var cartBO = CartMapper.toBO(dto);

        return CartMapper.toDTO(cartRepository.create(cartBO));
    }

}