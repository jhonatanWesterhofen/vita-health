package com.domain.usecases;

import java.time.LocalDateTime;

import com.domain.entities.dto.UserDTO;
import com.domain.entities.enums.EnumErrorCode;
import com.domain.entities.mapper.UserMapper;
import com.domain.entities.utils.ClassException;
import com.domain.entities.vo.QueryFieldInfoVO;
import com.infra.database.panache.repositories.PanacheUserRepository;

public class CreateUser {

    PanacheUserRepository panacheUserRepository;

    public CreateUser(PanacheUserRepository panacheUserRepository) {
        this.panacheUserRepository = panacheUserRepository;
    }

    public UserDTO execute(UserDTO dto) {

        var userBO = panacheUserRepository.findBy(new QueryFieldInfoVO("document", dto.getDocument()));

        if (userBO != null) {
            throw new ClassException(EnumErrorCode.USUARIO_JA_EXISTE);
        }

        dto.setCreatedAt(LocalDateTime.now());

        var newUserBO = UserMapper.toBO(dto);

        panacheUserRepository.create(newUserBO);

        return UserMapper.toDTO(newUserBO);
    }
}