package com.cloud.common.handler;

import com.cloud.common.constant.CommonConstants;
import com.cloud.common.exception.BaseException;
import com.cloud.common.exception.UserTokenException;
import com.cloud.common.result.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author JiaShun
 * @date 2018/3/27 15:23
 */
@ControllerAdvice("com.cloud")
@ResponseBody
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(HttpServletResponse response, BaseException ex){
        logger.error(ex.getMessage(),ex);
        response.setStatus(500);
        return new BaseResponse(ex.getStatus(),ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseException otherExceptionHandler(HttpServletResponse response,Exception ex){
        logger.error(ex.getMessage(),ex);
        response.setStatus(500);
        return new BaseException(CommonConstants.EX_OTHER_STATUS,ex.getMessage());
    }

    @ExceptionHandler(UserTokenException.class)
    public BaseResponse userTokenExceptionHandler(HttpServletResponse response, UserTokenException ex) {
        response.setStatus(401);
        logger.error(ex.getMessage(),ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }

}
