package com.cobble.huasheng.springsecurity.entity;

import java.util.List;

import com.cobble.huasheng.entity.BaseEntity;

public class UserEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private Long userId; 
	private String userName;
	private String password;
	private Boolean enabled;
	private List<RoleEntity> roleEntities;
	
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
	public List<RoleEntity> getRoleEntities() {
		return roleEntities;
	}
	public void setRoleEntities(List<RoleEntity> roleEntities) {
		this.roleEntities = roleEntities;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
