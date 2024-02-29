package com.services;

import com.domain.entities.dto.UserDTO;
import com.domain.entities.enums.EnumErrorCode;
import com.domain.entities.utils.ClassException;
import com.domain.entities.utils.StringUtil;
import com.domain.entities.utils.ValidateUtil;
import com.domain.entities.vo.QueryFieldInfoVO;
import com.domain.usecases.CreateUser;
import com.domain.usecases.FindUser;
import com.infra.utils.EncryptUtil;
import com.infra.utils.Utils;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

/**
 * 
 * @author Edevaldo
 */
@ApplicationScoped
public class UserService extends AbstractService {

    @Transactional
    public Response createUser(UserDTO dto) {

        validateInfo(dto);
        encryptInfo(dto);

        var create = new CreateUser(userRepository);
        var user = create.execute(dto);

        return Response.status(Status.OK).entity(user).build();
    }

    @Transactional
    public Response login(String email, String password) {

        if (StringUtil.isNullOrEmpty(email) || StringUtil.isNullOrEmpty(password)) {
            throw new ClassException(EnumErrorCode.CAMPO_OBRIGATORIO, "email e password");
        }

        var decryptedEmail = EncryptUtil.textEncrypt(email, encryptKey);
        var decryptedPassword = EncryptUtil.textEncrypt(password, encryptKey);

        var find = new FindUser(userRepository);
        var user = find.execute(new QueryFieldInfoVO("email", decryptedEmail));

        if (Utils.isNull(user)) {
            throw new ClassException(EnumErrorCode.EMAIL_INVALIDO);
        }

        if (!user.getPassword().equals(decryptedPassword)) {
            throw new ClassException(EnumErrorCode.SENHA_INVALIDA);
        }

        return Response.status(Status.OK).entity(user).build();
    }

    @Transactional
    public Response recover(String email) {
        return Response.status(Status.OK).entity(email).build();
    }

    public void validateInfo(UserDTO dto) {

        if (StringUtil.isNullOrEmpty(dto.getDocument())) {
            throw new ClassException(EnumErrorCode.CAMPO_OBRIGATORIO);
        }

        ValidateUtil.validateCPF(dto.getDocument());

        if (StringUtil.isNullOrEmpty(dto.getEmail())) {
            throw new ClassException(EnumErrorCode.CAMPO_OBRIGATORIO);
        }

        if (StringUtil.isNullOrEmpty(dto.getName())) {
            throw new ClassException(EnumErrorCode.CAMPO_OBRIGATORIO);
        }

        if (StringUtil.isNullOrEmpty(dto.getPassword())) {
            throw new ClassException(EnumErrorCode.CAMPO_OBRIGATORIO);
        }

    }

    public void encryptInfo(UserDTO dto) {

        dto.setName(EncryptUtil.textEncrypt(dto.getName(), encryptKey));
        dto.setDocument(EncryptUtil.textEncrypt(dto.getDocument(), encryptKey));
        dto.setEmail(EncryptUtil.textEncrypt(dto.getEmail(), encryptKey));
        dto.setPassword(EncryptUtil.textEncrypt(dto.getPassword(), encryptKey));
        dto.setPhoneNumber(EncryptUtil.textEncrypt(dto.getPhoneNumber(), encryptKey));
    }

}
