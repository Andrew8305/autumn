package com.cloud.user.rpc.service;

import com.cloud.common.vo.user.UserInfo;
import com.cloud.user.service.IUserService;
import com.cloud.user.vo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author JiaShun
 * @date 2018/3/29 10:28
 */
@Service
public class PermissionService {
    @Autowired
    private IUserService userService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public UserInfo validate(String username,String password){
        UserInfo info = new UserInfo();
        User user = userService.getUserByUsername(username);
        if(encoder.matches(password,user.getPassword())){
            BeanUtils.copyProperties(user,info);
            info.setId(user.getId().toString());
        }
        return info;
    }
}
