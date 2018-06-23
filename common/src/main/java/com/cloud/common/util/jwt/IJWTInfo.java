package com.cloud.common.util.jwt;

/**
 * @author JiaShun
 * @date 2018/3/28 22:59
 */
public interface IJWTInfo {
    //获取用户名(服务名)
    String getUniqueName();
    //获取用户ID(服务ID)
    String getId();
    //获取名称
    String getName();
}
