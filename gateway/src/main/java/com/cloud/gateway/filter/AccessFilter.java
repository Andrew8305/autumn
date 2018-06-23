package com.cloud.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.cloud.auth.client.config.UserAuthConfig;
import com.cloud.auth.client.util.UserAuthUtil;
import com.cloud.common.context.BaseContextHandler;
import com.cloud.common.exception.auth.TokenErrorResponse;
import com.cloud.common.util.jwt.IJWTInfo;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;


/**
 * @author JiaShun
 * @date 2018/3/30 11:22
 */
@Component
@Slf4j
public class AccessFilter extends ZuulFilter{
    @Value("${gate.ignore.startWith}")
    private String startWith;
    @Value("${zuul.prefix}")
    private String zuulPrefix;
    @Autowired
    private UserAuthConfig userAuthConfig;
    @Autowired
    private UserAuthUtil userAuthUtil;
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        final String requestUri = request.getRequestURI().substring(zuulPrefix.length());
        final String method = request.getMethod();
        BaseContextHandler.setToken(null);
        //不进行拦截的地址
        if(isStartWith(requestUri)){
            return null;
        }
        IJWTInfo user = null;
        try{
            user = getJWTUser(request,ctx);
        }catch (Exception e){
            setFailedRequest(JSON.toJSONString(new TokenErrorResponse(e.getMessage())),200);
            return null;
        }
        return user;
    }

    /**
     * uri是否以自己定义的路径打头
     * @param requestUri
     * @return
     */
    private boolean isStartWith(String requestUri){
        boolean flag = false;
        for(String s: startWith.split(",")){
            if(requestUri.startsWith(s)){
                return true;
            }
        }
        return flag;
    }
    /**
     * 网关抛异常
     *
     * @param body
     * @param code
     */
    private void setFailedRequest(String body, int code) {
        log.debug("Reporting error ({}): {}", code, body);
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseStatusCode(code);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody(body);
            ctx.setSendZuulResponse(false);
        }
    }

    /**
     * 返回session中的信息
     * @param request
     * @param ctx
     * @return
     * @throws Exception
     */
    private IJWTInfo getJWTUser(HttpServletRequest request, RequestContext ctx)throws Exception{
        String authToken = request.getHeader(userAuthConfig.getTokenHeader());
        if(StringUtils.isEmpty(authToken)){
            authToken = request.getParameter("token");
        }
        ctx.addZuulRequestHeader(userAuthConfig.getTokenHeader(),authToken);
        BaseContextHandler.setToken(authToken);
        return userAuthUtil.getInfoFromToken(authToken);
    }
}
