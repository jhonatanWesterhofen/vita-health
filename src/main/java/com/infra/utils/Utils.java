package com.infra.utils;

import io.quarkus.runtime.configuration.ProfileManager;

@SuppressWarnings("all")
public class Utils {

    public static <T> T nvl(Object arg0, T arg1) {
        if (arg0 instanceof String) {
            String a = (String) arg0;
            if (a.trim().isEmpty()) {
                return arg1;
            }
        }
        return (T) ((arg0 == null) ? arg1 : arg0);
    }

    public static <T> boolean isNull(T value) {
        return value == null ? true : false;
    }

    public static <T> boolean isNotNull(T value) {
        return value == null ? false : true;
    }

}