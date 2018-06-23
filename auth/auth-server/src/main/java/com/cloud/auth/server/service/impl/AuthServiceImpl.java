package com.cloud.auth.server.service.impl;

import com.cloud.common.util.jwt.JWTInfo;
import com.cloud.common.vo.user.UserInfo;
import com.cloud.auth.server.feign.IUserService;
import com.cloud.auth.server.service.IAuthService;
import com.cloud.auth.server.util.user.UserAuthRequest;
import com.cloud.auth.server.util.user.UserTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author JiaShun
 * @date 2018/3/29 10:00
 */
@Service
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private UserTokenUtil userTokenUtil;
    @Autowired
    private IUserService userService;
    @Override
    public String login(UserAuthRequest userAuthRequest) throws Exception {
        UserInfo info = userService.validate(userAuthRequest);
        String token = "";
        if(!StringUtils.isEmpty(info.getId())){
            token = userTokenUtil.generateToken(new JWTInfo(info.getUsername(),info.getId()+"",info.getName()));
        }
        return token;
    }
}
