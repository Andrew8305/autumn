package com.cloud.auth.server.util.user;

import com.cloud.common.util.jwt.IJWTInfo;
import com.cloud.auth.server.configuration.KeyConfiguration;
import com.cloud.common.util.jwt.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author JiaShun
 * @date 2018/3/29 09:53
 */
@Component
public class UserTokenUtil {
    @Value("${jwt.expire}")
    private int expire;
    @Autowired
    private KeyConfiguration keyConfiguration;

    public String generateToken(IJWTInfo info) throws Exception{
        return JWTHelper.generateToken(info,keyConfiguration.getUserPriKey(),expire);
    }
    public IJWTInfo getInfoFromToken(String token) throws Exception{
        return JWTHelper.getInfoFromToken(token,keyConfiguration.getUserPubKey());
    }
}
