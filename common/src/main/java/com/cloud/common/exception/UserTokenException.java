package com.cloud.common.exception;


import com.cloud.common.constant.CommonConstants;

/**
 * Created by ace on 2017/9/8.
 */
public class UserTokenException extends BaseException {
    public UserTokenException(String message) {
        super(CommonConstants.EX_USER_INVALID_CODE,message);
    }
}
