package com.cobble.huasheng.springsecurity.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.springsecurity.dao.PrivilegeDAO;
import com.cobble.huasheng.springsecurity.entity.PrivilegeEntity;
import com.cobble.huasheng.springsecurity.entity.PrivilegeEntitySearch;
import com.cobble.huasheng.springsecurity.entity.RoleEntity;
import com.cobble.huasheng.springsecurity.service.PrivilegeService;

public class PrivilegeServiceImpl implements PrivilegeService {
	private static final Logger logger = Logger.getLogger(PrivilegeServiceImpl.class);
	private PrivilegeDAO privilegeDAO;
	
	@Override
	public void create(PrivilegeEntity privilegeEntity) throws Exception {
		privilegeDAO.create(privilegeEntity);
	}

	@Override
	public void update(PrivilegeEntity privilegeEntity) throws Exception {
		privilegeDAO.update(privilegeEntity);
	}

	@Override
	public List<PrivilegeEntity> finds(PrivilegeEntitySearch privilegeEntitySearch)
			throws Exception {
		return privilegeDAO.finds(privilegeEntitySearch, true, -1, -1);
	}

	@Override
	public List<PrivilegeEntity> finds(PrivilegeEntitySearch privilegeEntitySearch, int start,
			int limit) throws Exception {
		return privilegeDAO.finds(privilegeEntitySearch, false, start, limit);
	}

	@Override
	public PrivilegeEntity findById(Long id) throws Exception {
		return privilegeDAO.findById(id);
	}

	@Override
	public long getCount(PrivilegeEntitySearch privilegeEntitySearch) throws Exception {
		return privilegeDAO.getCount(privilegeEntitySearch);
	}

	@Override
	public void delete(PrivilegeEntity privilegeEntity) throws Exception {
		privilegeDAO.delete(privilegeEntity);
	}

	@Override
	public List<String> getResourcesByRoleName(String roleName) throws Exception {
		return privilegeDAO.getResourcesByRoleName(roleName);
	}

	public void setPrivilegeDAO(PrivilegeDAO privilegeDAO) {
		this.privilegeDAO = privilegeDAO;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		try {
			PrivilegeEntity privilegeEntity = privilegeDAO.findById(id);
			List<RoleEntity> roleEntities = privilegeEntity.getRoleEntities();
			if (null != roleEntities) {
				for (RoleEntity roleEntity : roleEntities) {
					roleEntity.getPrivilegeEntities().remove(privilegeEntity);
				}
			}
			privilegeDAO.delete(privilegeEntity);
		} catch (Exception e) {
			logger.fatal("Delete exception.", e);
			throw e;
		}
	}

}
