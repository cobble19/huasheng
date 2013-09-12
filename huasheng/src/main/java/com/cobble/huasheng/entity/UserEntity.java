package com.cobble.huasheng.entity;

public class UserEntity extends BaseEntity {
	/**ID*/
	private Long userId;
	/**login code / accountNo*/
	private String accountNo;
	/**password*/
	private String password;
	/**NAME*/
	private String name;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
