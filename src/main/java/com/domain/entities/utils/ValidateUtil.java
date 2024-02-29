package com.domain.entities.utils;

import com.domain.entities.enums.EnumErrorCode;

/**
 * 
 * @author Edevaldo
 */
public class ValidateUtil {

    public static void validateCPF(String document) {

        var cpf = extractDigits(document);

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1+")) {
            throw new ClassException(EnumErrorCode.CPF_INVALIDO);
        }

        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(cpf.charAt(i));
            sum += digit * (10 - i);
        }

        int firstVerifier = validateVerifier(sum);

        sum = 0;

        for (int i = 0; i < 10; i++) {
            int digit = Character.getNumericValue(cpf.charAt(i));
            sum += digit * (11 - i);
        }

        int secondVerifier = validateVerifier(sum);

        if (firstVerifier != Character.getNumericValue(cpf.charAt(9)) ||
                secondVerifier != Character.getNumericValue(cpf.charAt(10))) {
            throw new ClassException(EnumErrorCode.CPF_INVALIDO);
        }
    }

    private static String extractDigits(String document) {
        return document.replaceAll("\\D", "");
    }

    private static int validateVerifier(int sum) {
        int remainder = 11 - (sum % 11);
        return (remainder == 10 || remainder == 11) ? 0 : remainder;
    }
}
