package com.cloud.auth.server.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author JiaShun
 * @date 2018/3/28 17:25
 */
@Configuration
@Data
public class KeyConfiguration {
    @Value("${jwt.rsa-secret}")
    private String userSecret;
    @Value("${client.rsa-secret}")
    private String serviceSecret;
    private byte[] userPubKey;
    private byte[] userPriKey;
    private byte[] servicePubKey;
    private byte[] servicePriKey;
}
