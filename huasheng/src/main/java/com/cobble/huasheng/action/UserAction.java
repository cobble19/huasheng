package com.cobble.huasheng.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.dto.UserDTO;
import com.cobble.huasheng.dto.UserDTOSearch;
import com.cobble.huasheng.service.UserService;


public class UserAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(UserAction.class);
	private UserService userService;
	private UserDTOSearch userDTOSearch = new UserDTOSearch();
	private UserDTO userDTO = new UserDTO();
	private List<UserDTO> userDTOList = new ArrayList<UserDTO>(0);

	@Override
	public String execute() throws Exception {
		userDTOList = userService.finds(userDTOSearch);
		if (userDTOList != null) {
			for (UserDTO userDto : userDTOList) {
				logger.debug(userDto);
			}
		}
		return this.SUCCESS;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserDTOSearch getUserDTOSearch() {
		return userDTOSearch;
	}

	public void setUserDTOSearch(UserDTOSearch userDtoSearch) {
		this.userDTOSearch = userDtoSearch;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDto) {
		this.userDTO = userDto;
	}

	public List<UserDTO> getUserDTOList() {
		return userDTOList;
	}

	public void setUserDTOList(List<UserDTO> userDtoList) {
		this.userDTOList = userDtoList;
	}

}
