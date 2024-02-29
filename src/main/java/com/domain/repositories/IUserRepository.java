package com.domain.repositories;

import com.domain.entities.bo.UserBO;
import com.domain.entities.vo.QueryFieldInfoVO;

/**
 * 
 * @author Edevaldo
 */
public interface IUserRepository {

    UserBO create(UserBO bo);

    UserBO findBy(QueryFieldInfoVO field);

    UserBO merge(UserBO bo);
}