package com.cloud.auth.server.feign;

import com.cloud.common.vo.user.UserInfo;
import com.cloud.auth.server.configuration.FeignConfiguration;
import com.cloud.auth.server.util.user.UserAuthRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author JiaShun
 * @date 2018/3/29 10:18
 */
@FeignClient(value = "user",configuration = FeignConfiguration.class)
public interface IUserService {
    @RequestMapping(value = "/api/user/validate" ,method = RequestMethod.POST)
    UserInfo validate(@RequestBody UserAuthRequest userAuthRequest);
}
