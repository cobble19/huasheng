package com.cobble.huasheng.springsecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.cobble.huasheng.springsecurity.entity.RoleEntity;
import com.cobble.huasheng.springsecurity.service.PrivilegeService;
import com.cobble.huasheng.springsecurity.service.RoleService;

public class LoginFilterInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {
	private static final Logger logger = Logger.getLogger(LoginFilterInvocationSecurityMetadataSource.class);
	private RoleService roleService;
	private PrivilegeService privilegeService;
	
	//private UrlMatcher urlMatcher = new AntUrlPathMatcher(); 
    private AntPathRequestMatcher pathMatcher;  
  
    private HashMap<String, Collection<ConfigAttribute>> resourceMap = null;  
    public LoginFilterInvocationSecurityMetadataSource(RoleService roleService, PrivilegeService privilegeService) {
    	this.roleService = roleService;
    	this.privilegeService = privilegeService;
    	try {
			init();
		} catch (Exception e) {
			logger.fatal("Set SecurityMetadataSource exception.", e);
		}
    }
    public void init() throws Exception {  
        loadResourceDefine();  
    } 
    /** 
     *  
     * TODO(程序启动的时候就加载所有资源信息). 
     * @throws Exception 
     */  
	private void loadResourceDefine() throws Exception {
		// 在Web服务器启动时，提取系统中的所有权限。
		List<RoleEntity> roleEntities = roleService.finds(null);
		/*
		 * 应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。
		 * 一个资源可以由多个权限来访问。 
		 */
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

		for (RoleEntity role : roleEntities) {
			String roleName = role.getRoleName();
			ConfigAttribute ca = new SecurityConfig(roleName);
			List<String> resources = privilegeService.getResourcesByRoleName(roleName);
			for (String resource : resources) {
				//String resource = str;
				/*
				 * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，
				 * 则要通过该url为key提取出权限集合，将权限增加到权限集合中
				 * 
				 */
				if (resourceMap.containsKey(resource)) {
					Collection<ConfigAttribute> value = resourceMap.get(resource);
					value.add(ca);
					resourceMap.put(resource, value);
				} else {
					Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
					atts.add(ca);
					resourceMap.put(resource, atts);
				}
			}
		}
		logger.debug("resourceMap=" + resourceMap);
	}
    
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		Collection<ConfigAttribute> ret = new ArrayList<ConfigAttribute>();
		FilterInvocation fi = (FilterInvocation)object;
		 //object 是一个URL ,为用户请求URL  
        String url = fi.getRequestUrl();  
        logger.debug("Request Url=" + url);
       if("/".equals(url)){  
           return ret;  
       }  
        /*int firstQuestionMarkIndex = url.indexOf(".");  
        //判断请求是否带有参数 如果有参数就去掉后面的后缀和参数(/index.do  --> /index)  
        if(firstQuestionMarkIndex != -1){  
            url = url.substring(0,firstQuestionMarkIndex);  
        }  */
        Iterator<String> ite = resourceMap.keySet().iterator();  
        //取到请求的URL后与上面取出来的资源做比较  
        //HttpServletRequest request = fi.getRequest();
        while (ite.hasNext()) {
            String resURL = ite.next(); 
            try {
            	Pattern p = Pattern.compile(resURL);// regex
            	Matcher m = p.matcher(url);
            	if (m.matches()) {
            		ret.addAll(resourceMap.get(resURL));
            	}
            } catch (Exception e) {
            	e.printStackTrace();
            }
            /*pathMatcher = new AntPathRequestMatcher(resURL);
            if(pathMatcher.matches(request)){  
                return resourceMap.get(resURL);  
            } */ 
        }  
        return ret; 
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	public void setPrivilegeService(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

}
