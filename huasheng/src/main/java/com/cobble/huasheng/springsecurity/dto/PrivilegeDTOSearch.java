package com.cobble.huasheng.springsecurity.dto;

import java.util.List;

import com.cobble.huasheng.dto.BaseDTOSearch;

public class PrivilegeDTOSearch extends BaseDTOSearch {
	private static final long serialVersionUID = 1L;
	private Long privilegeId;
	private String resource;
	private String resourceType;
	private List<RoleDTO> roleEntities;
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
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public List<RoleDTO> getRoleEntities() {
		return roleEntities;
	}
	public void setRoleEntities(List<RoleDTO> roleEntities) {
		this.roleEntities = roleEntities;
	}
}
