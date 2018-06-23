package com.cloud.auth.server.controller;

import com.cloud.auth.server.service.IAuthService;
import com.cloud.auth.server.util.user.UserAuthRequest;
import com.cloud.auth.server.util.user.UserAuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JiaShun
 * @date 2018/3/29 09:35
 */
@RestController
@RequestMapping("jwt")
@Slf4j
public class AuthController {
    @Value("${jwt.token-header}")
    private String tokenHeader;

    @Autowired
    private IAuthService authService;

    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public ResponseEntity<?> createAuthToken( UserAuthRequest userAuthRequest) throws Exception{
        log.info(userAuthRequest.getUsername() + "====== require logging ======");
        final String token = authService.login(userAuthRequest);
        return ResponseEntity.ok(new UserAuthResponse(token));
    }
}
