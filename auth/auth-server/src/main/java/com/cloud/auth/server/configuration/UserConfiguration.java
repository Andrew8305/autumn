package com.cloud.auth.server.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author JiaShun
 * @date 2018/3/29 15:17
 */
@Configuration
@Data
public class UserConfiguration {
    @Value("${jwt.token-header}")
    private String userTokenHeader;
}
