package com.cobble.huasheng.springsecurity.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.cobble.huasheng.action.BaseAction;
import com.cobble.huasheng.springsecurity.entity.RoleEntity;
import com.cobble.huasheng.springsecurity.entity.UserEntity;
import com.cobble.huasheng.springsecurity.entity.UserEntitySearch;
import com.cobble.huasheng.springsecurity.service.UserService;

import freemarker.template.utility.StringUtil;


public class UserAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(UserAction.class);
	private UserService userService;
	private UserEntitySearch userEntitySearch = new UserEntitySearch();
	private UserEntity userEntity = new UserEntity();
	private List<UserEntity> userEntityList = new ArrayList<UserEntity>(0);
	// condition
	private Long userId; 
	private String userName;
	private String password;
	private Boolean enabled;
	// for delete, {id1,id2,id3...}. [,]分割
	private String ids;
	private Long[] roleIds;
	
	private void fillEntity() {
		if (userEntity == null) {
			userEntity = new UserEntity();
		}
		userEntity.setUserId(userId);
		userEntity.setUserName(userName);
		userEntity.setPassword(password);
		userEntity.setEnabled(enabled);
		// user - role
		List<RoleEntity> roleEntities = new ArrayList<RoleEntity>();
		if (roleIds != null) {
			for (Long roleId : roleIds) {
				RoleEntity roleEntity = new RoleEntity();
				roleEntity.setRoleId(roleId);
				roleEntities.add(roleEntity);
			}
		}
		userEntity.setRoleEntities(roleEntities);
	}
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		userEntityList = userService.finds(userEntitySearch, this.getStart(), this.getLimit());
		long total = userService.getCount(userEntitySearch);
		this.setTotal((int) total);
		return this.SUCCESS;
	}

	public String add() throws Exception {
		this.fillEntity();
		userService.create(userEntity);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		this.fillEntity();
		userService.update(userEntity);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if (StringUtils.isNotBlank(ids)) {
			String[] idsSplit = StringUtil.split(ids, ',');
			for (String id : idsSplit) {
				userService.deleteById(Long.parseLong(id));
			}
		}
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public UserEntitySearch getUserEntitySearch() {
		return userEntitySearch;
	}

	public void setUserEntitySearch(UserEntitySearch userEntitySearch) {
		this.userEntitySearch = userEntitySearch;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public List<UserEntity> getUserEntityList() {
		return userEntityList;
	}

	public void setUserEntityList(List<UserEntity> userEntityList) {
		this.userEntityList = userEntityList;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

}
