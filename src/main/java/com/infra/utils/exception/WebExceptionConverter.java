package com.infra.utils.exception;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.jboss.resteasy.client.exception.WebApplicationExceptionWrapper;

import com.domain.entities.utils.ClassException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import jakarta.ws.rs.WebApplicationException;

@SuppressWarnings("all")
public class WebExceptionConverter {

    public static <T> T convertExceptionToObject(WebApplicationException exception, Class<T> targetClass) {
        return convertExceptionToObject(exception, targetClass, false);
    }

    public static <T> T convertExceptionToObject(WebApplicationException exception, Class<T> targetClass,
            boolean isCollectionTypeReturn) {
        WebApplicationExceptionWrapper wre = null;
        WebApplicationException wae = null;

        try {
            wre = (WebApplicationExceptionWrapper) exception;
        } catch (Exception e) {
            wae = exception;
        }

        if (wre != null) {
            wae = wre.unwrap();
        }

        if (wae != null
                && wae.getResponse() != null) {

            final Object response = wae.getResponse().getEntity();

            if (response != null
                    && response instanceof ByteArrayInputStream) {

                try {
                    String completeError = wae.getResponse().readEntity(String.class);

                    if (!completeError.isEmpty()) {

                        if (targetClass.isAssignableFrom(String.class)) {
                            return (T) completeError;
                        }

                        final Gson gson = new Gson();

                        if (isCollectionTypeReturn) {
                            final Type listType = TypeToken.getParameterized(List.class, targetClass).getType();

                            final List<T> list = gson.fromJson(completeError, listType);

                            if (!list.isEmpty()) {
                                return (T) list.get(0);
                            }
                            throw new ClassException("Erro na comunicação com o provedor de serviço.", "-999");
                        } else {
                            if (completeError.contains("[")) {
                                if (completeError.contains(",{")) {
                                    completeError = completeError.replaceAll("(\\[|(\\,\\{.*]))", "");
                                } else {
                                    completeError = completeError.replaceAll("(\\[|])", "");
                                }
                            }

                            return gson.fromJson(completeError, targetClass);
                        }
                    }
                } catch (Exception e) {
                    throw new ClassException("Erro na comunicação com o provedor de serviço.", "-999");
                }
            }
        }

        return null;
    }

}
