package com.smallking.common;

import com.smallking.annotation.Log;
import com.smallking.utils.HttpContextUtils;
import com.smallking.utils.IpUtils;
import org.apache.tomcat.util.net.IPv6Utils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.jboss.logging.Logger;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import sun.net.util.IPAddressUtil;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpContext;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LogAspect {

    private final static Logger logger = Logger.getLogger(LogAspect.class);
    @Pointcut("@annotation(com.smallking.annotation.Log)")
    public void pointcut() {}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {

        Object result = null;
        long startTime = System.currentTimeMillis();

        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long time = System.currentTimeMillis() - startTime;
        

        saveLog(joinPoint, time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        // 注解描述
        Log log = method.getAnnotation(Log.class);
        // 类名
        String className = joinPoint.getTarget().getClass().getName();
        // 方法名
        String methodName = signature.getName();
        // 参数
        Object[] args = joinPoint.getArgs();

        LocalVariableTableParameterNameDiscoverer params = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = params.getParameterNames(method);
        Map<String, String> paramsMap = new HashMap<>();
        for (int i = 0; i < parameterNames.length; i++) {
            paramsMap.put(parameterNames[i],args[i].toString()) ;
        }
        HttpServletRequest httpServletRequest = HttpContextUtils.getHttpServletRequest();
        String ipAddr = IpUtils.getIpAddr(httpServletRequest);

        logger.info("执行方法：" + className  + "." + methodName + "()，方法执行时间：" + time + ",说明：" + log.value() + "，参数：【" + (paramsMap.isEmpty() ? "无参数":paramsMap) + "】，请求IP：" + ipAddr);
    }
}

