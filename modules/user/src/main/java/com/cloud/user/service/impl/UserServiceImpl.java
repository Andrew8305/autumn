package com.cloud.user.service.impl;

import com.cloud.common.core.service.BaseServiceImpl;
import com.cloud.user.dao.UserDAO;
import com.cloud.user.service.IUserService;
import com.cloud.user.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author JiaShun
 * @date 2018/3/26 16:44
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public List<User> list(Map<String, Object> map) {
        return userDAO.list(map);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }
}
