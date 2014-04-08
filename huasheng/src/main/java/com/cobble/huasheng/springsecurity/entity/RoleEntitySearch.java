package com.cobble.huasheng.springsecurity.entity;

import java.util.List;

import com.cobble.huasheng.entity.BaseEntity;

public class RoleEntitySearch extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private Long roleId;
	private String roleName;
	private List<UserEntity> userEntities;
	private List<PrivilegeEntity> privilegeEntities;
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
	public List<UserEntity> getUserEntities() {
		return userEntities;
	}
	public void setUserEntities(List<UserEntity> userEntities) {
		this.userEntities = userEntities;
	}
	public List<PrivilegeEntity> getPrivilegeEntities() {
		return privilegeEntities;
	}
	public void setPrivilegeEntities(List<PrivilegeEntity> privilegeEntities) {
		this.privilegeEntities = privilegeEntities;
	}
}
