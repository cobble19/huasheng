package com.cobble.huasheng.springsecurity;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class LoginFilterSecurityInterceptorImpl extends AbstractSecurityInterceptor implements Filter {
	private static final Logger logger = Logger.getLogger(LoginFilterSecurityInterceptorImpl.class);
	
	private FilterInvocationSecurityMetadataSource securityMetadataSource;
	/*private AccessDecisionManager accessDecisionManager;
	private AuthenticationManager authenticationManager;*/
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		FilterInvocation fi = new FilterInvocation(request, response, chain);  
		InterceptorStatusToken token = super.beforeInvocation(fi);  
        try {  
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());  
        } catch (Exception e) {
        	logger.fatal("LoginFilterSecurityInterceptorImpl Fata!!", e);
        } finally {  
            super.afterInvocation(token, null);  
        } 
	}

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}

	public void setSecurityMetadataSource(
			FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}

	/*public void setAccessDecisionManager(AccessDecisionManager accessDecisionManager) {
		this.accessDecisionManager = accessDecisionManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}*/

}
