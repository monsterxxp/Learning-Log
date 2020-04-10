package com.smallking.common;

import cn.hutool.json.JSONUtil;
import org.apache.catalina.filters.ExpiresFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {

    /**
     *@Author: wsx
     *@Description: sessuin过期时返回JSON错误信息
     *@Date: 03:01 2018/10/14
     *@param: ServletRequest, ServletResponse
     *@return: boolean
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (this.isLoginRequest(request, response)) {
            if (this.isLoginSubmission(request, response)) {
                return this.executeLogin(request,response);
            } else {
                return true;
            }
        } else {
//            String requestType = ((HttpServletRequest)request).getHeader("X-Requested-With");
            HttpServletResponse httpServletResponse = (HttpServletResponse)response;
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("text/json; charset=UTF-8");
            httpServletResponse.setStatus(302);
            PrintWriter out = httpServletResponse.getWriter();
            out.print(JSONUtil.parseObj(Return.error(302, "会话过期，请重新登陆！")));
            out.flush();
            out.close();
            return false;
        }
    }
}
