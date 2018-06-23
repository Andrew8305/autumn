package com.cloud.common.util.jwt;

import com.cloud.common.constant.CommonConstants;
import com.cloud.common.util.StringHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author JiaShun
 * @date 2018/3/28 15:43
 */
@Component
public class JWTHelper {

    private static RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();

    /**
     * 私钥加密token
     * @param info
     * @param priKey
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(IJWTInfo info, byte[] priKey, int expire) throws Exception{
        String compactJws = Jwts.builder()
                .setSubject(info.getUniqueName())
                .claim(CommonConstants.JWT_KEY_USER_ID,info.getId())
                .claim(CommonConstants.JWT_KEY_USER_NAME,info.getName())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256,rsaKeyHelper.getPriKey(priKey))
                .compact();
        return compactJws;
    }

    /**
     * 公钥解析token
     * @param token
     * @param pubKey
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token,byte[] pubKey)throws Exception{
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPubKey(pubKey)).parseClaimsJws(token);
        return claimsJws;
    }

    /**
     * 获取token中的用户信息
     * @param token
     * @param pubKey
     * @return
     * @throws Exception
     */
    public static IJWTInfo getInfoFromToken(String token,byte[] pubKey) throws Exception{
        Jws<Claims> claimsJws = parserToken(token,pubKey);
        Claims body = claimsJws.getBody();
        return new JWTInfo(body.getSubject(),
                StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_USER_ID)),
                StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_USER_NAME)));
    }
}
