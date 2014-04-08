package com.cobble.huasheng.springsecurity.dao;

import java.util.List;

import com.cobble.huasheng.dao.CommonDAO;
import com.cobble.huasheng.springsecurity.entity.PrivilegeEntity;
import com.cobble.huasheng.springsecurity.entity.PrivilegeEntitySearch;

public interface PrivilegeDAO extends CommonDAO<PrivilegeEntity, PrivilegeEntitySearch> {
	List<String> getResourcesByRoleName(String roleName) throws Exception;
}
