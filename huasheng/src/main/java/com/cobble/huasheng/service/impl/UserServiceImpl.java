package com.cobble.huasheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.dao.UserDAO;
import com.cobble.huasheng.dto.UserDTO;
import com.cobble.huasheng.dto.UserDTOSearch;
import com.cobble.huasheng.entity.UserEntity;
import com.cobble.huasheng.entity.UserEntitySearch;
import com.cobble.huasheng.service.UserService;
import com.cobble.huasheng.util.BeanUtil;
import com.cobble.huasheng.util.ListUtil;

public class UserServiceImpl implements UserService {
	private final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	private UserDAO userDAO;

	public void create(UserDTO userDTO) throws Exception {
		UserEntity userEntity = new UserEntity();
		try {
			BeanUtil.copyProperties(userEntity, userDTO);
			userDAO.create(userEntity);
		} catch (Exception e) {
			logger.fatal("add excep", e);
			throw e;
		}
	}

	public void update(UserDTO userDTO) throws Exception {
		try {
			UserEntity userEntity = userDAO.findById(userDTO.getUserId());
			BeanUtil.copyProperties(userEntity, userDAO);
			userDAO.update(userEntity);
		} catch (Exception e) {
			logger.fatal("update excep", e);
			throw e;
		}
	}

	public List<UserDTO> finds(UserDTOSearch userDTOSearch) throws Exception {
		List<UserDTO> ret = new ArrayList<UserDTO>(0);
		try {
			UserEntitySearch userEntitySearch = new UserEntitySearch();
			if (userDTOSearch != null) {
				BeanUtil.copyProperties(userEntitySearch, userDTOSearch);
			}
			List<UserEntity> userEntityList = userDAO.finds(userEntitySearch);
			if (ListUtil.isNotEmpty(userEntityList)) {
				for (UserEntity userEntity : userEntityList) {
					UserDTO userDTO = new UserDTO();
					BeanUtil.copyProperties(userDTO, userEntity);
					ret.add(userDTO);
				}
			}
			
		} catch (Exception e) {
			logger.fatal("update excep", e);
			throw e;
		}
		return ret;
	}

	public UserDTO findById(Long userId) throws Exception {
		UserDTO ret = new UserDTO();
		try {
			UserEntity userEntity = userDAO.findById(userId);
			BeanUtil.copyProperties(ret, userEntity);
		} catch (Exception e) {
			logger.fatal("find by id excep", e);
			throw e;
		}
		return ret;
	}

	public long getCount(UserDTOSearch userDTOSearch) throws Exception {
		long ret = 0;
		try {
			UserEntitySearch userEntitySearch = new UserEntitySearch();
			BeanUtil.copyProperties(userEntitySearch, userDTOSearch);
			ret = userDAO.getCount(userEntitySearch);
		} catch (Exception e) {
			logger.fatal("getCount excep", e);
			throw e;
		}
		return ret;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


}
