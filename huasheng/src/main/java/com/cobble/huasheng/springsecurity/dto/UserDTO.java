package com.cobble.huasheng.springsecurity.dto;

import java.util.List;

import com.cobble.huasheng.dto.BaseDTO;

public class UserDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private Long userId; 
	private String username;
	private String password;
	private Boolean enabled;
	private List<RoleDTO> roleEntities;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<RoleDTO> getRoleEntities() {
		return roleEntities;
	}
	public void setRoleEntities(List<RoleDTO> roleEntities) {
		this.roleEntities = roleEntities;
	}
}
