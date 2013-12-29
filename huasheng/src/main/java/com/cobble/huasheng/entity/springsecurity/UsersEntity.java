package com.cobble.huasheng.entity.springsecurity;

import com.cobble.huasheng.entity.BaseEntity;

public class UsersEntity extends BaseEntity {
	
	private String username;
	private String password;
	private Boolean enabled;

	public UsersEntity() {
	}

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

}
