package com.cobble.huasheng.springsecurity;

import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class LoginAccessDecisionManagerImpl implements AccessDecisionManager {
	private static final Logger logger = Logger.getLogger(LoginAccessDecisionManagerImpl.class);

	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (null == configAttributes || configAttributes.size() < 1) {  
			logger.debug("configAttributes is null.");
			throw new AccessDeniedException("Access Denied. Please assign Role.");
            //return;  
        }
		Iterator<ConfigAttribute> it = configAttributes.iterator();
		while(it.hasNext()){  
            ConfigAttribute ca = it.next();  
            String needRole = ((SecurityConfig) ca).getAttribute();  
            //GrantedAuthority 为用户所被赋予的权限，needRole为访问相应的资源应具有的权限  
            for (GrantedAuthority gra : authentication.getAuthorities()) {  
                if (needRole.trim().equals(gra.getAuthority().trim())) {
                	logger.debug("Role is right.Role=" + needRole);
                    return;  
                }  
            }  
        }  
        throw new AccessDeniedException("Access Denied");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
