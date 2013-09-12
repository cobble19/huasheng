package com.cobble.huasheng.dao;

import java.util.List;

import com.cobble.huasheng.entity.UserEntity;
import com.cobble.huasheng.entity.UserEntitySearch;

public interface UserDAO {
	public void add(UserEntity userEntity) throws Exception;
	public void update(UserEntity userEntity) throws Exception;
	public List<UserEntity> finds(UserEntitySearch userEntitySearch) throws Exception;
	public UserEntity findById(Long userId) throws Exception;
	public long getCount(UserEntitySearch userEntitySearch) throws Exception;
}
