package com.cloud.user.dao;

import com.cloud.common.core.dao.BaseDAO;
import com.cloud.user.vo.User;

import java.util.List;
import java.util.Map;

public interface UserDAO extends BaseDAO<User> {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> list(Map<String,Object> map);

    User getUserByUsername(String username);
}