package com.cloud.auth.server.interceptor;

import com.cloud.common.util.jwt.IJWTInfo;
import com.cloud.auth.server.configuration.UserConfiguration;
import com.cloud.auth.server.util.user.UserTokenUtil;
import com.cloud.common.context.BaseContextHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author JiaShun
 * @date 2018/3/29 15:12
 */
public class UserAuthInterceptor extends HandlerInterceptorAdapter{
    @Autowired
    private UserConfiguration userConfiguration;
    @Autowired
    private UserTokenUtil userTokenUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(userConfiguration.getUserTokenHeader());
        IJWTInfo info = userTokenUtil.getInfoFromToken(token);
        BaseContextHandler.setUserId(info.getId());
        BaseContextHandler.setUsername(info.getUniqueName());
        BaseContextHandler.setName(info.getName());
        return super.preHandle(request, response, handler);
    }
}
