package com.cobble.huasheng.service;

import java.util.List;

import com.cobble.huasheng.dto.UserDTO;
import com.cobble.huasheng.dto.UserDTOSearch;

public interface UserService {
	public void add(UserDTO userDTO) throws Exception;
	public void update(UserDTO userDTO) throws Exception;
	public List<UserDTO> finds(UserDTOSearch userDTOSearch) throws Exception;
	public UserDTO findById(Long userId) throws Exception;
	public long getCount(UserDTOSearch userDTOSearch) throws Exception;
}
