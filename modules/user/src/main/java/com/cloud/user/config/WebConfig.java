package com.cloud.user.config;

import com.cloud.common.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author JiaShun
 * @date 2018/3/27 20:58
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    GlobalExceptionHandler getGlobalExceptionHandler(){return new GlobalExceptionHandler();}
}
