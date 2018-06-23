package com.cloud.gateway.config;

import com.cloud.gateway.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JiaShun
 * @date 2018/3/30 11:42
 */
@Configuration
public class GateConfig {
    @Bean
    public AccessFilter getAccessFilter(){
        return new AccessFilter();
    }
}
