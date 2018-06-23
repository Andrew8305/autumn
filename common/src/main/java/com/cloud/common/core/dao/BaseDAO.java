package com.cloud.common.core.dao;

/**
 * @author JiaShun
 * @date 2018/3/25 11:11
 */

public interface BaseDAO<T> {
    int deleteByPrimaryKey(Integer id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);
}
