package com.cobble.huasheng.action;

import org.apache.log4j.Logger;

import com.cobble.huasheng.dto.UserDTOSearch;



public class LoginAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(LoginAction.class);
	private UserDTOSearch userDTOSearch = new UserDTOSearch();

	public String login() throws Exception {
		logger.debug("进入login");
		return this.LOGIN;
	}
	public String execute() {
		logger.debug("进入login execute");
		return this.SUCCESS;
	}
	public UserDTOSearch getUserDTOSearch() {
		return userDTOSearch;
	}
	public void setUserDTOSearch(UserDTOSearch userDtoSearch) {
		this.userDTOSearch = userDtoSearch;
	}

}
