package com.cloud.auth.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author JiaShun
 * @date 2018/3/29 23:32
 */
@Configuration
public class UserAuthConfig {
    @Value("${auth.user.token-header}")
    private String tokenHeader;
    private byte[] pubKeyByte;

    public String getTokenHeader() {
        return tokenHeader;
    }

    public void setTokenHeader(String tokenHeader) {
        this.tokenHeader = tokenHeader;
    }

    public byte[] getPubKeyByte() {
        return pubKeyByte;
    }

    public void setPubKeyByte(byte[] pubKeyByte) {
        this.pubKeyByte = pubKeyByte;
    }
}
