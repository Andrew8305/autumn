package com.cloud.common.core.service;

import com.cloud.common.core.dao.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author JiaShun
 * @date 2018/3/25 11:20
 */

public abstract class BaseServiceImpl<T> implements BaseService<T>{
    @Autowired
    private BaseDAO<T> dao;

    @Override
    public int save(T t) {
        return dao.insert(t);
    }

    @Override
    public int saveSelective(T t) {
        return dao.insertSelective(t);
    }

    @Override
    public int deleteById(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public T findById(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int update(T t) {
        return dao.updateByPrimaryKey(t);
    }

    @Override
    public int updateSelective(T t) {
        return dao.updateByPrimaryKeySelective(t);
    }
}
