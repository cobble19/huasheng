package com.cobble.huasheng.entity.springsecurity;

import com.cobble.huasheng.entity.BaseEntity;

public class AuthoritiesEntity extends BaseEntity {
	
	private String username;
	private String authority;

	public AuthoritiesEntity() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
