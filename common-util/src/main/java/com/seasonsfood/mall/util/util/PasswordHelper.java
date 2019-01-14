package com.seasonsfood.mall.util.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ron
 */
@Component
public class PasswordHelper {

    public PasswordHelper() {
        this.randomNumberGenerator = new SecureRandomNumberGenerator();
    }

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public Map<String,String> encryptPassword(String password,String credentials) {

        Map<String,String> data = new HashMap<>();

        String salt = randomNumberGenerator.nextBytes().toHex();

        String credentialsSalt = credentials + salt;

        data.put("salt",salt);

        String newPassword = new SimpleHash(
                algorithmName,
                password,
                ByteSource.Util.bytes(credentialsSalt),
                hashIterations).toHex();

        data.put("password",newPassword);
        return data;
    }

    public String decodePassword(String password,String CredentialsSalt) {

        String newPassword = new SimpleHash(
                algorithmName,
                password,
                ByteSource.Util.bytes(CredentialsSalt),
                hashIterations).toHex();

        return newPassword;
    }

}
