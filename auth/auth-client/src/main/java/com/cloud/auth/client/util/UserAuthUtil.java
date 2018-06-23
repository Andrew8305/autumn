package com.cloud.auth.client.util;

import com.cloud.common.util.jwt.IJWTInfo;
import com.cloud.auth.client.config.UserAuthConfig;
import com.cloud.common.exception.UserTokenException;
import com.cloud.common.util.jwt.JWTHelper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author JiaShun
 * @date 2018/3/29 23:32
 */
@Configuration
public class UserAuthUtil {
    @Autowired
    private UserAuthConfig userAuthConfig;
    public IJWTInfo getInfoFromToken(String token) throws Exception {
        try {
            return JWTHelper.getInfoFromToken(token, userAuthConfig.getPubKeyByte());
        }catch (ExpiredJwtException ex){
            throw new UserTokenException("===== User token expired =====");
        }catch (SignatureException ex){
            throw new UserTokenException("===== User token signature error =====");
        }catch (IllegalArgumentException ex){
            throw new UserTokenException("===== User token is null or empty =====");
        }
    }
}
