package com.cobble.huasheng.springsecurity.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.cobble.huasheng.action.BaseAction;
import com.cobble.huasheng.springsecurity.entity.PrivilegeEntity;
import com.cobble.huasheng.springsecurity.entity.RoleEntity;
import com.cobble.huasheng.springsecurity.entity.RoleEntitySearch;
import com.cobble.huasheng.springsecurity.service.RoleService;

import freemarker.template.utility.StringUtil;


public class RoleAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(RoleAction.class);
	private RoleService roleService;
	private RoleEntitySearch roleEntitySearch = new RoleEntitySearch();
	private RoleEntity roleEntity = new RoleEntity();
	private List<RoleEntity> roleEntityList = new ArrayList<RoleEntity>(0);
	// condition
	private Long roleId;
	private String roleName;
	// for delete, {id1,id2,id3...}. [,]分割
	private String ids;
	// privilege(s)
	private Long[] privilegeIds = new Long[0];
	
	private void fillEntity() {
		if (roleEntity == null) {
			roleEntity = new RoleEntity();
		}
		roleEntity.setRoleId(roleId);
		roleEntity.setRoleName(roleName);
		// Role - Privilege
		List<PrivilegeEntity> privilegeEntities = new ArrayList<PrivilegeEntity>();
		if (null != privilegeIds) {
			for (int i = 0; i < privilegeIds.length; i++) {
				PrivilegeEntity privilegeEntity = new PrivilegeEntity();
				privilegeEntity.setPrivilegeId(privilegeIds[i]);
				privilegeEntities.add(privilegeEntity);
			}
		}
		roleEntity.setPrivilegeEntities(privilegeEntities);
	}
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		roleEntityList = roleService.finds(roleEntitySearch, this.getStart(), this.getLimit());
		long total = roleService.getCount(roleEntitySearch);
		this.setTotal((int) total);
		return this.SUCCESS;
	}

	public String add() throws Exception {
		this.fillEntity();
		roleService.create(roleEntity);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		this.fillEntity();
		roleService.update(roleEntity);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if (StringUtils.isNotBlank(ids)) {
			String[] idsSplit = StringUtil.split(ids, ',');
			for (String id : idsSplit) {
				roleService.deleteById(Long.parseLong(id));
			}
		}
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public RoleEntitySearch getRoleEntitySearch() {
		return roleEntitySearch;
	}

	public void setRoleEntitySearch(RoleEntitySearch roleEntitySearch) {
		this.roleEntitySearch = roleEntitySearch;
	}

	public RoleEntity getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

	public List<RoleEntity> getRoleEntityList() {
		return roleEntityList;
	}

	public void setRoleEntityList(List<RoleEntity> roleEntityList) {
		this.roleEntityList = roleEntityList;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

}
