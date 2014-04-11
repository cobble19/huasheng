package com.cobble.huasheng.springsecurity.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.cobble.huasheng.springsecurity.dao.UserDAO;
import com.cobble.huasheng.springsecurity.entity.RoleEntity;
import com.cobble.huasheng.springsecurity.entity.UserEntity;
import com.cobble.huasheng.springsecurity.entity.UserEntitySearch;
import com.cobble.huasheng.springsecurity.service.UserService;

public class UserServiceImpl implements UserService {
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	private UserDAO userDAO;

	@Override
	public void create(UserEntity userEntity) throws Exception {
		String password = userEntity.getPassword();
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		password = md5PasswordEncoder.encodePassword(password, userEntity.getUserName());
		userEntity.setPassword(password);
		userDAO.create(userEntity);
	}

	@Override
	public void update(UserEntity userEntity) throws Exception {
		String password = userEntity.getPassword();
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		password = md5PasswordEncoder.encodePassword(password, userEntity.getUserName());
		userEntity.setPassword(password);
		userDAO.update(userEntity);
	}

	@Override
	public List<UserEntity> finds(UserEntitySearch userEntitySearch) throws Exception {
		return userDAO.finds(userEntitySearch, true, -1, -1);
	}

	@Override
	public List<UserEntity> finds(UserEntitySearch userEntitySearch, int start, int limit)
			throws Exception {
		return userDAO.finds(userEntitySearch, false, start, limit);
	}

	@Override
	public UserEntity findById(Long id) throws Exception {
		return userDAO.findById(id);
	}

	@Override
	public long getCount(UserEntitySearch userEntitySearch) throws Exception {
		return userDAO.getCount(userEntitySearch);
	}

	@Override
	public void delete(UserEntity userEntity) throws Exception {
		userDAO.delete(userEntity);
	}

	@Override
	public List<RoleEntity> findRolesByUserName(String userName)
			throws Exception {
		return userDAO.findRolesByUserName(userName);
	}

	@Override
	public UserEntity findByUserName(String userName) throws Exception {
		return userDAO.findByUserName(userName);
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		try {
			UserEntity userEntity = userDAO.findById(id);
			userDAO.delete(userEntity);
		} catch (Exception e) {
			logger.fatal("Delete exception.", e);
			throw e;
		}
	}

	@Override
	public void changePwd(UserEntity userEntity) throws Exception {
		String password = userEntity.getPassword();
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		password = md5PasswordEncoder.encodePassword(password, userEntity.getUserName());
		userEntity.setPassword(password);
		userDAO.changePwd(userEntity);
	}

}
