package com.cobble.huasheng.springsecurity.dao;

import java.util.List;

import com.cobble.huasheng.dao.CommonDAO;
import com.cobble.huasheng.springsecurity.entity.RoleEntity;
import com.cobble.huasheng.springsecurity.entity.UserEntity;
import com.cobble.huasheng.springsecurity.entity.UserEntitySearch;

public interface UserDAO extends CommonDAO<UserEntity, UserEntitySearch> {
	List<RoleEntity> findRolesByUserName(String userName) throws Exception;
	UserEntity findByUserName(String userName) throws Exception;
	void changePwd(UserEntity userEntity) throws Exception;
}
