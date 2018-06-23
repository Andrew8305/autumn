package com.cloud.common.core.service;


/**
 * @author JiaShun
 * @date 2018/3/25 11:15
 */
public interface BaseService<T> {
    int save(T t);
    int saveSelective(T t);
    int deleteById(Integer id);
    T findById(Integer id);
    int update(T t);
    int updateSelective(T t);
}
