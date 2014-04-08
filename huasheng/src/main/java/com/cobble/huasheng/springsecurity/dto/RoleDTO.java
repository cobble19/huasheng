package com.cobble.huasheng.springsecurity.dto;

import java.util.List;

import com.cobble.huasheng.dto.BaseDTO;

public class RoleDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private Long roleId;
	private String roleName;
	private List<UserDTO> userEntities;
	private List<PrivilegeDTO> privilegeEntities;
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
	public List<UserDTO> getUserEntities() {
		return userEntities;
	}
	public void setUserEntities(List<UserDTO> userEntities) {
		this.userEntities = userEntities;
	}
	public List<PrivilegeDTO> getPrivilegeEntities() {
		return privilegeEntities;
	}
	public void setPrivilegeEntities(List<PrivilegeDTO> privilegeEntities) {
		this.privilegeEntities = privilegeEntities;
	}
}
