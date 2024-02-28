package com.domain.repositories;

import com.domain.entities.bo.CartBO;
import com.domain.entities.vo.QueryFieldInfoVO;

public interface ICartRepository {

    CartBO create(CartBO bo);

    CartBO findBy(QueryFieldInfoVO field);

    CartBO merge(CartBO bo);
}