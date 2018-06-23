package com.cloud.common.exception.auth;

import com.cloud.common.constant.RestCodeConstants;
import com.cloud.common.result.BaseResponse;

/**
 * @author JiaShun
 * @date 2018/3/29 22:23
 */
public class TokenErrorResponse extends BaseResponse {
    public TokenErrorResponse(String message){
        super(RestCodeConstants.TOKEN_ERROR_CODE,message);
    }
}
