package com.cobble.huasheng.springsecurity.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.springsecurity.dao.RoleDAO;
import com.cobble.huasheng.springsecurity.entity.RoleEntity;
import com.cobble.huasheng.springsecurity.entity.RoleEntitySearch;
import com.cobble.huasheng.springsecurity.entity.UserEntity;
import com.cobble.huasheng.springsecurity.service.RoleService;

public class RoleServiceImpl implements RoleService {
	private static final Logger logger = Logger.getLogger(RoleServiceImpl.class);
	private RoleDAO roleDAO;

	@Override
	public void create(RoleEntity roleEntity) throws Exception {
		roleDAO.create(roleEntity);
	}

	@Override
	public void update(RoleEntity roleEntity) throws Exception {
		roleDAO.update(roleEntity);
	}

	@Override
	public List<RoleEntity> finds(RoleEntitySearch roleEntitySearch) throws Exception {
		return roleDAO.finds(roleEntitySearch, true, -1, -1);
	}

	@Override
	public List<RoleEntity> finds(RoleEntitySearch roleEntitySearch, int start, int limit)
			throws Exception {
		return roleDAO.finds(roleEntitySearch, false, start, limit);
	}

	@Override
	public RoleEntity findById(Long id) throws Exception {
		return roleDAO.findById(id);
	}

	@Override
	public long getCount(RoleEntitySearch roleEntitySearch) throws Exception {
		return roleDAO.getCount(roleEntitySearch);
	}

	@Override
	public void delete(RoleEntity roleEntity) throws Exception {
		roleDAO.delete(roleEntity);
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		try {
			RoleEntity roleEntity = roleDAO.findById(id);
			List<UserEntity> userEntities = roleEntity.getUserEntities();
			if (null != userEntities) {
				for (UserEntity userEntity : userEntities) {
					userEntity.getRoleEntities().remove(roleEntity);
				}
			}
			roleDAO.delete(roleEntity);
		} catch (Exception e) {
			logger.fatal("Delete exception.", e);
			throw e;
		}
	}

}
