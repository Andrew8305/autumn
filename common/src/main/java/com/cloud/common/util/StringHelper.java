package com.cloud.common.util;

/**
 * @author JiaShun
 * @date 2018/3/28 23:24
 */
public class StringHelper {
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }
}
