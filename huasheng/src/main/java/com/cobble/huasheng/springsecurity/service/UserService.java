package com.cobble.huasheng.springsecurity.service;

import java.util.List;

import com.cobble.huasheng.service.CommonService;
import com.cobble.huasheng.springsecurity.entity.RoleEntity;
import com.cobble.huasheng.springsecurity.entity.UserEntity;
import com.cobble.huasheng.springsecurity.entity.UserEntitySearch;

public interface UserService extends CommonService<UserEntity, UserEntitySearch> {
	List<RoleEntity> findRolesByUserName(String userName) throws Exception;
	UserEntity findByUserName(String userName) throws Exception;
	void changePwd(UserEntity userEntity) throws Exception;
}
