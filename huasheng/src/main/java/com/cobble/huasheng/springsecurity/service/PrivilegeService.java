package com.cobble.huasheng.springsecurity.service;

import java.util.List;

import com.cobble.huasheng.service.CommonService;
import com.cobble.huasheng.springsecurity.entity.PrivilegeEntity;
import com.cobble.huasheng.springsecurity.entity.PrivilegeEntitySearch;

public interface PrivilegeService extends CommonService<PrivilegeEntity, PrivilegeEntitySearch> {

	List<String> getResourcesByRoleName(String roleName) throws Exception ;

}
