package com.infra.utils;

import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncryptUtil {

    public static String textEncrypt(final String plainText, final String key) {
        try {
            var aesKey = new SecretKeySpec(key.getBytes(), "AES");
            var cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.ENCRYPT_MODE, aesKey);

            var encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

            return java.util.Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String textDecrypt(final String cipherText, final String key) {
        try {
            var aesKey = new SecretKeySpec(key.getBytes(), "AES");
            var cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.DECRYPT_MODE, aesKey);

            var decordedValue = java.util.Base64.getDecoder().decode(cipherText);
            var decValue = cipher.doFinal(decordedValue);

            return new String(decValue, StandardCharsets.UTF_8);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] base64Decode(final String strToDecode) {
        return Base64.decodeBase64(strToDecode);
    }

    public static byte[] base64Encode(final String strToEncode) {
        return Base64.encodeBase64(strToEncode.getBytes());
    }

}
