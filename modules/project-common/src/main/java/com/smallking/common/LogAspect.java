package com.smallking.common;

import com.smallking.annotation.Log;
import com.smallking.utils.HttpContextUtils;
import com.smallking.utils.IpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.jboss.logging.Logger;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LogAspect {

    private final static Logger logger = Logger.getLogger(LogAspect.class);

    private long startTime;

    @Pointcut("@annotation(log)")
    public void pointcut(Log log) {}

    @Before("pointcut(log)")
    public void doBefore(JoinPoint joinPoint, Log log) {
        startTime = System.currentTimeMillis();

        // 接收到请求，记录请求内容
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        // 类名
        String className = joinPoint.getTarget().getClass().getName();
        // 方法名
        String methodName = signature.getName();

        // 记录下请求内容
        logger.info("请求URL : " + request.getRequestURL().toString());
        logger.info("请求方式 : " + request.getMethod());
        String ip = IpUtils.getIpAddr(request);
        logger.info("请求IP : " + ip);
        String executeMethod = className + "." + methodName + "()";
        logger.info("请求方法 : " + executeMethod);
        String methodDesc = log.value();
        logger.info("执行操作 : " + methodDesc);
        // 参数
        Object[] args = joinPoint.getArgs();

        LocalVariableTableParameterNameDiscoverer params = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = params.getParameterNames(method);
        Map<String, String> paramsMap = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            paramsMap.put(parameterNames[i],args[i].toString()) ;
        }
        logger.info("请求参数 : " + paramsMap);
    }

    @AfterReturning(returning = "ret", pointcut = "pointcut(log)")
    public void doAfterReturning(Object ret, Log log) throws Throwable {
        long time = System.currentTimeMillis() - startTime;
        // 处理完请求，返回内容
        logger.info("返回结果 : " + ret);
        logger.info("执行时长 : " + time);

    }
}

