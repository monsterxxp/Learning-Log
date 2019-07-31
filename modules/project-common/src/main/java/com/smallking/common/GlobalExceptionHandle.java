package com.smallking.common;

import org.apache.shiro.authz.AuthorizationException;
import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandle{

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandle.class);

    @ExceptionHandler(value = AuthorizationException.class)
    public String handleAuthorizationException() {
        return "403";
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map errorHandler(Exception e) {
        if (e instanceof BizException) {
            BizException bizException = (BizException)e;
            bizException.printStackTrace();
            logger.error(bizException.getMessage());
            Map map = new HashMap();
            map.put("code", 1);
            map.put("msg", bizException.getMessage());
            return map;
        }  else {
            e.printStackTrace();
            logger.error("系统错误：" + e.getMessage());
            Map map = new HashMap();
            map.put("code", 1);
            map.put("msg", "系统错误");
            return map;
        }
    }
}