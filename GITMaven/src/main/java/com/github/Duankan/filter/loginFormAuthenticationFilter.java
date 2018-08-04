package com.github.Duankan.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class loginFormAuthenticationFilter extends FormAuthenticationFilter {
    // 制定session跳转url
    private final String successUrl = "/success.jsp";

    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response)
            throws Exception {
        WebUtils.getAndClearSavedRequest(request);
//        WebUtils.redirectToSavedRequest(request,response,successUrl);
        WebUtils.issueRedirect(request, response,successUrl, null, true);
    }
}
