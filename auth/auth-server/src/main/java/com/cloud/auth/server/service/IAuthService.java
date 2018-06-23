package com.cloud.auth.server.service;

import com.cloud.auth.server.util.user.UserAuthRequest;

/**
 * @author JiaShun
 * @date 2018/3/29 09:59
 */
public interface IAuthService {
    String login(UserAuthRequest userAuthRequest)throws Exception;
}
