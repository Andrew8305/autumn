package com.cloud.user.service;

import com.cloud.common.core.service.BaseService;
import com.cloud.user.vo.User;

import java.util.List;
import java.util.Map;

/**
 * @author JiaShun
 * @date 2018/3/26 16:44
 */
public interface IUserService extends BaseService<User>{
    List<User> list(Map<String,Object> map);
    User getUserByUsername(String username);
}
