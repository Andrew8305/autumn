package com.cloud.common.exception;

import com.cloud.common.constant.CommonConstants;

/**
 * @author JiaShun
 * @date 2018/3/27 15:18
 */
public class BaseException extends RuntimeException {
    private int status =CommonConstants.EX_BASE_STATUS;

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BaseException(int status,String message) {
        super(message);
        this.status = status;
    }

    public BaseException(String message) {
        super(message);
    }
}
