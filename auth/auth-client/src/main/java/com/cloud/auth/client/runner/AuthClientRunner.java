package com.cloud.auth.client.runner;

import com.cloud.auth.client.config.UserAuthConfig;
import com.cloud.auth.client.feign.ServiceAuthFeign;
import com.cloud.common.result.BaseResponse;
import com.cloud.common.result.ObjectRestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author JiaShun
 * @date 2018/3/30 16:43
 */
@Configuration
@Slf4j
public class AuthClientRunner implements CommandLineRunner{
    @Autowired
    private UserAuthConfig userAuthConfig;
    @Autowired
    private ServiceAuthFeign serviceAuthFeign;
    @Override
    public void run(String... args) throws Exception {
        log.info("=== 初始化加载用户pubKey ===");
        try {
            refreshUserPubKey();
        } catch (Exception e){
            log.error("初始化加载用户pubKey失败，1分钟后自动重试");
        }
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void refreshUserPubKey(){
        BaseResponse resp = serviceAuthFeign.getUserPubKey();
        if(resp.getStatus() == HttpStatus.OK.value()){
            ObjectRestResponse<byte[]> userResponse = (ObjectRestResponse<byte[]>) resp;
            this.userAuthConfig.setPubKeyByte(userResponse.getData());
        }
    }
}
