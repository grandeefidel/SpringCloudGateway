package com.cgGateway.helper;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class EncryptDecryptHelper {

    private static final String SECRET_KEY = "Thisisatestkeyfortesting";


    private static SecretKeySpec secretKey;
    private static byte[] key;

    public static String encrypt(String strToEncrypt){
        return encrypt(strToEncrypt, SECRET_KEY);
    }

    public static String decrypt(String strToDecrypt){
        return decrypt(strToDecrypt, SECRET_KEY);
    }

    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    public static String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }



    public static String decrypt(String strToDecrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public static void main(String[] args) {

        String key = "Thisisatestkeyfortesting";

        //language=JSON
//        String data = "{\n"
//                + "  \"email\": \"fidel@gmail.com\",\n"
//                + "  \"password\": \"Test\"\n"
//                + "}";

        String data = "{\n"
                + "\"firstName\":\"Ikebobo\",\n"
                + "\"lastName\":\"Caro\",\n"
                + "\"email\":\"mugabe@gmail.com\",\n"
                + "\"password\":\"Test\"\n"
        + "}";

        System.out.println("Original String: " + data);

        String encryptedString = EncryptDecryptHelper.encrypt(data, key);

        System.out.println("Encrypted String: " + encryptedString);

        String decryptedString = EncryptDecryptHelper.decrypt(encryptedString, key);
        String decryptString = EncryptDecryptHelper.decrypt("GKk0s9RjjUytNWjmZFRtda2L73J4hZFRybQtnXKk8Cyp/wxvqJQiEBAtXpHCvigw6tO4eS7bV2DwxT4bVtiA1KI0Y2WrBmCY7CrRbDNIcil1lYZ1nvPjeVpZE39fEeOMSOtVanqhcvWHtTj1sfVSdA3PH0tlKxOcaL1fUVXYL6jvu6HdUoobe/phhOXk0bYAoYcYMC/Su2myNtOnRUiabmo3BK0EZ+8pEhlqnLSQAXYNpC1uSq1qAHkVc3StwX1vUl9EJYkCf0m/fMPPKyR/tcSUU7u2V+cXfO+X4mpufCgGRvvUxeSUt/PQswoo8+G3wqiFjKGNnO7ZI4ydJ5ZXP1SlGMeH9VhUVkF13RW250D5r8UmRt6EbL3zVxSDPiQO0jrvl4GQXSgePz7DIwJanw==", key);

        System.out.println("Decrypted String: " + decryptedString);
        System.out.println("Decrypt String: " + decryptString);

    }
}