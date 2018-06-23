package com.cloud.common.exception.auth;

import com.cloud.common.constant.RestCodeConstants;
import com.cloud.common.result.BaseResponse;

/**
 * @author JiaShun
 * @date 2018/3/29 22:19
 */
public class TokenForbiddenResponse extends BaseResponse {
    public TokenForbiddenResponse(String message){
        super(RestCodeConstants.TOKEN_FORBIDDEN_CODE,message);
    }
}
