package com.infra.database.panache.repositories;

import com.domain.entities.bo.CartBO;
import com.domain.entities.vo.QueryFieldInfoVO;
import com.domain.repositories.ICartRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheCartRepository implements ICartRepository {

    @Override
    public CartBO create(CartBO bo) {
        return null;
    }

    @Override
    public CartBO findBy(QueryFieldInfoVO field) {
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }

    @Override
    public CartBO merge(CartBO bo) {
        throw new UnsupportedOperationException("Unimplemented method 'merge'");
    }
}