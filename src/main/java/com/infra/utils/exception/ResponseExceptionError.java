package com.infra.utils.exception;

import java.time.LocalDateTime;

import org.apache.http.HttpStatus;

import com.domain.entities.enums.EnumErrorCode;
import com.domain.entities.utils.ClassException;
import com.infra.utils.DateUtil;

import jakarta.annotation.Priority;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class ResponseExceptionError implements ExceptionMapper<ClassException> {

    @Override
    public Response toResponse(ClassException ex) {

        int httpStatus;
        var error = EnumErrorCode.parseByKey(ex.getErrorCode());

        var formattedDate = DateUtil.formatDDMMYYYYHHMMSS(LocalDateTime.now());
        var exceptionResponse = new ExceptionReponseDTO();

        exceptionResponse.setError(ex.getMessage());
        exceptionResponse.setErrorDate(formattedDate);

        if (error != null) {
            var errorPhrase = Status.fromStatusCode(error.getHttpStatus()).getReasonPhrase();
            httpStatus = error.getHttpStatus();

            exceptionResponse.setErrorCode(error.getKey());
            exceptionResponse.setHttpCode(errorPhrase);
        } else {
            exceptionResponse.setErrorCode(ex.getErrorCode());
            httpStatus = HttpStatus.SC_BAD_REQUEST;
        }

        return Response.status(httpStatus).entity(exceptionResponse).build();
    }

}
