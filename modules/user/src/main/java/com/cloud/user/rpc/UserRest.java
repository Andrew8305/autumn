package com.cloud.user.rpc;

import com.cloud.common.vo.user.UserInfo;
import com.cloud.user.rpc.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author JiaShun
 * @date 2018/3/29 10:24
 */
@RestController
@RequestMapping("api")
public class UserRest {
    @Resource
    private PermissionService permissionService;
    @RequestMapping(value = "/user/validate",method = RequestMethod.POST)
    @ResponseBody
    public UserInfo validate(@RequestBody Map<String,String> body){
        return permissionService.validate(body.get("username"),body.get("password"));
    }
}
