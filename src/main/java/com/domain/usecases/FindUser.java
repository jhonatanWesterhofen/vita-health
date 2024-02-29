package com.domain.usecases;

import com.domain.entities.dto.UserDTO;
import com.domain.entities.mapper.UserMapper;
import com.domain.entities.vo.QueryFieldInfoVO;
import com.domain.repositories.IUserRepository;

/**
 * 
 * @author Edevaldo
 */
public class FindUser {

    IUserRepository userRepository;

    public FindUser(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO execute(QueryFieldInfoVO fieldValue) {

        var userBO = userRepository.findBy(fieldValue);

        if (userBO == null) {
            return null;
        }

        return UserMapper.toDTO(userBO);
    }
}