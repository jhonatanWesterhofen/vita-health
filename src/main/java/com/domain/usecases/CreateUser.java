package com.domain.usecases;

import com.domain.entities.dto.UserDTO;
import com.domain.entities.enums.EnumErrorCode;
import com.domain.entities.mapper.UserMapper;
import com.domain.entities.utils.ClassException;
import com.domain.entities.vo.QueryFieldInfoVO;
import com.domain.repositories.IUserRepository;
import com.infra.utils.Utils;

/**
 * 
 * @author Edevaldo
 */
public class CreateUser {

    IUserRepository userRepository;

    public CreateUser(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO execute(UserDTO dto) {

        var userBO = userRepository.findBy(new QueryFieldInfoVO("document", dto.getDocument()));

        if (Utils.isNotNull(userBO)) {
            throw new ClassException(EnumErrorCode.USUARIO_JA_EXISTE);
        }

        return UserMapper.toDTO(userRepository.create(UserMapper.toBO(dto)));

    }

}
