package com.cobble.huasheng.springsecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cobble.huasheng.springsecurity.dao.UserDAO;
import com.cobble.huasheng.springsecurity.entity.RoleEntity;
import com.cobble.huasheng.springsecurity.entity.UserEntity;

public class LoginUserDetailsService implements UserDetailsService {
	private static final Logger logger = Logger.getLogger(LoginUserDetailsService.class);
	
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		try {
			UserEntity userEntity = userDAO.findByUserName(userName);
			if (null == userEntity) {  
				logger.error("用户" + userName + "不存在");
	            throw new UsernameNotFoundException("用户" + userName + "不存在");  
	        }
			Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
			List<RoleEntity> roleEntities = userDAO.findRolesByUserName(userName);
	        for (int i = 0; i < roleEntities.size(); i++) {  
	            auths.add(new GrantedAuthorityImpl(roleEntities.get(i).getRoleName()));  
	        }  
	      //因为UserEntity实现了UserDetails，所以也可以直接返回user  
	        User user = new User(userName, userEntity.getPassword(), true, true, true, true, auths);
	        logger.debug("User=" + user);
	        return user; 
			
		} catch (Exception e) {
			logger.fatal("Get user exception.", e);
		}
		return null;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
