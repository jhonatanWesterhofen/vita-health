package com.services;

import com.domain.entities.dto.UserDTO;
import com.domain.entities.enums.EnumErrorCode;
import com.domain.entities.vo.QueryFieldInfoVO;
import com.domain.usecases.CreateUser;
import com.domain.usecases.FindUserUseCase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@ApplicationScoped
public class UserService extends AbstractService {

    @Transactional
    public Response createUser(UserDTO dto, String factoryTeste) {

        var newUser = new CreateUser(userRepository);
        var user = newUser.execute(dto); //teste git 

        return Response.status(Status.OK).entity(user).build();
    }

    @Transactional
    public Response findUser(String document) {

        var findUser = new FindUserUseCase(userRepository);
        var user = findUser.execute(new QueryFieldInfoVO("document", document));

        if (user == null) {
            return Response.status(Status.BAD_REQUEST).entity(EnumErrorCode.PESSOA_NAO_ENCONTRADA).build();
        }

        return Response.status(Status.OK).entity(user).build();
    }

    @Transactional
    public Response makeLogin(String email, String password) {

        var findUser = new FindUserUseCase(userRepository);
        var user = findUser.execute(new QueryFieldInfoVO("email", email));

        if (user == null) {
            return Response.status(Status.BAD_REQUEST).entity(EnumErrorCode.EMAIL_INVALIDO).build();
        }

        if (!user.getPassword().equals(password)) {
            return Response.status(Status.BAD_REQUEST).entity(EnumErrorCode.SENHA_INVALIDA).build();
        }

        return Response.status(Status.OK).entity(user).build();
    }
}