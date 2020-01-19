package com.smallking.common;

import com.alibaba.druid.util.StringUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandle{

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandle.class);
    private String appNo = "000-";

    public GlobalExceptionHandle() {
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BizException.class})
    public ErrorMessage handleBusinessException(BizException ex) throws IOException {
        logger.error(ex.getMessage(), ex);
        int errorCode = HttpStatus.BAD_REQUEST.value();
        return new ErrorMessage(errorCode, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    public ErrorMessage handleBusinessException(Exception ex) throws IOException {
        logger.error(ex.getMessage(), ex);
        int errorCode = HttpStatus.BAD_REQUEST.value();
        return new ErrorMessage(errorCode, "系统错误");
    }
}
