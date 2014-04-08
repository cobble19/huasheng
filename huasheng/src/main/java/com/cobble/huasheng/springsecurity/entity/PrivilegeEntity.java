package com.cobble.huasheng.springsecurity.entity;

import java.util.List;

import com.cobble.huasheng.entity.BaseEntity;

public class PrivilegeEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private Long privilegeId;
	private String name;
	private String resource;
	private List<RoleEntity> roleEntities;
	public Long getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public List<RoleEntity> getRoleEntities() {
		return roleEntities;
	}
	public void setRoleEntities(List<RoleEntity> roleEntities) {
		this.roleEntities = roleEntities;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
