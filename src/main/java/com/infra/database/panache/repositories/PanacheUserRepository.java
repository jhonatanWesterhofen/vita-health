package com.infra.database.panache.repositories;

import com.domain.entities.bo.UserBO;
import com.domain.entities.vo.QueryFieldInfoVO;
import com.domain.repositories.IUserRepository;
import com.infra.database.panache.mappers.PanacheUserMapper;
import com.infra.database.panache.models.PanacheUser;

import jakarta.enterprise.context.ApplicationScoped;

/**
 * 
 * @author Edevaldo
 */
@ApplicationScoped
public class PanacheUserRepository implements IUserRepository {

    @Override
    public UserBO create(UserBO bo) {
        var panacheUser = PanacheUserMapper.toEntity(bo);

        panacheUser.persistAndFlush();

        return PanacheUserMapper.toDomain(panacheUser);
    }

    @Override
    public UserBO findBy(QueryFieldInfoVO field) {
        return PanacheUser.find(field.getFieldName(), field.getFieldValue())
                .firstResultOptional()
                .map(entity -> PanacheUserMapper.toDomain((PanacheUser) entity))
                .orElse(null);
    }

    @Override
    public UserBO merge(UserBO bo) {
        var panacheUser = PanacheUserMapper.toEntity(bo);

        PanacheUser.getEntityManager().merge(panacheUser);

        return PanacheUserMapper.toDomain(panacheUser);
    }
}