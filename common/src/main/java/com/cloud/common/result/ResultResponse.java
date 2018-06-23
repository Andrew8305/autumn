package com.cloud.common.result;

/**
 * 响应结果生成工具
 */
public class ResultResponse {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result SuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result SuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result FailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
}
