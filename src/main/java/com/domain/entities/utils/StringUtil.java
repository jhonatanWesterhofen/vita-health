package com.domain.entities.utils;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.text.ParseException;
import java.util.stream.Collectors;

import javax.swing.text.MaskFormatter;

import com.infra.utils.Utils;

public class StringUtil {

    public static String stringPatternFormat(String pattern, Object... arguments) {
        return MessageFormat.format(pattern, arguments);
    }

    public static String toString(Object obj) {
        return obj != null ? obj.toString() : null;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty() || str.equalsIgnoreCase("null");
    }

    public static boolean isNotNullOrEmpty(String str) {
        return !isNullOrEmpty(str);
    }

    public static String numbers(String str) {
        final String n = Utils.nvl(str, "");
        return n.replaceAll("[^0-9]", "");
    }

    public static String onlyNumbers(String str) {
        String response = "";

        if (str != null) {
            response = numbers(str);
        }

        return response;
    }

    public static String addBlankLeftPad(String field, int fieldLength) {
        if (field == null) {
            return lpad(field, " ", fieldLength);
        }
        if (field.length() > fieldLength) {
            field = field.substring(0, fieldLength);
        }
        return lpad(field, " ", fieldLength);
    }

    public static String lpad(String valueToPad, String filler, int size) {

        if (valueToPad == null) {
            valueToPad = "";
        }
        if (valueToPad.length() >= size) {
            valueToPad = valueToPad.substring(0, size);
        }

        while (valueToPad.length() < size) {
            valueToPad = filler + valueToPad;
        }
        return valueToPad;
    }

    public static String basicToken(String token) {
        return "Basic " + token;
    }

    public static String basicToken(String username, String password) {
        var basic = username.concat(":").concat(password);
        var base64encoder = Base64.getEncoder();

        return "Basic ".concat(base64encoder.encodeToString(basic.getBytes()));
    }

    public static String capitalizeOnlyFirst(String str) {
        if (str == null || str.length() <= 1)
            return str;

        List<String> splits = Arrays.asList(str.split(" "));

        if (splits.size() > 1) {
            var response = splits.stream()
                    .map(i -> {
                        var cap = capitalizeOnlyFirst(i);
                        return cap.substring(0, 1).toUpperCase()
                                + cap.substring(1).toLowerCase();
                    })
                    .collect(Collectors.joining(" "));

            return response;
        } else {
            return splits.get(0);
        }
    }

    public static String capitalizeAll(String str) {
        if (str == null || str.length() < 1)
            return str;

        return str.toUpperCase();
    }

    public static String maskDocument(String str) {

        var newStr = onlyNumbers(str);
        var length = str.length();

        newStr = newStr.substring(0, 1)
                + str.substring(1, length - 3).replaceAll("\\d", "*")
                + str.substring(length - 3, length);

        try {
            switch (length) {
                case 11:
                    newStr = formatter(newStr, "***.***.***-**");
                    break;
                case 14:
                    newStr = formatter(newStr, "**.***.***/****-**");
                    break;
                default:
                    break;
            }
        } catch (ParseException e) {
        }

        return newStr;
    }

    public static String formatter(String value, String mask) throws ParseException {
        MaskFormatter maskFormatter = new MaskFormatter(mask);
        maskFormatter.setValueContainsLiteralCharacters(false);

        return maskFormatter.valueToString(value);
    }

    public static String substringCaseLargeText(String text, int size) {
        if (text.length() > size) {
            return text.substring(0, size).concat("...");
        }

        return text;
    }
}