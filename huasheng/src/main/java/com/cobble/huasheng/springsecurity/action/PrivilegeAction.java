package com.cobble.huasheng.springsecurity.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.cobble.huasheng.action.BaseAction;
import com.cobble.huasheng.springsecurity.entity.PrivilegeEntity;
import com.cobble.huasheng.springsecurity.entity.PrivilegeEntitySearch;
import com.cobble.huasheng.springsecurity.entity.RoleEntity;
import com.cobble.huasheng.springsecurity.service.PrivilegeService;

import freemarker.template.utility.StringUtil;


public class PrivilegeAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(PrivilegeAction.class);
	private PrivilegeService privilegeService;
	private PrivilegeEntitySearch privilegeEntitySearch = new PrivilegeEntitySearch();
	private PrivilegeEntity privilegeEntity = new PrivilegeEntity();
	private List<PrivilegeEntity> privilegeEntityList = new ArrayList<PrivilegeEntity>(0);
	// condition
	private Long privilegeId;
	private String name;
	private String resource;
	// for delete, {id1,id2,id3...}. [,]分割
	private String ids;
	/*private Long[] roleIds;*/
	
	private void fillEntity() {
		if (null == privilegeEntity) {
			privilegeEntity = new PrivilegeEntity();
		}
		privilegeEntity.setPrivilegeId(privilegeId);
		privilegeEntity.setName(name);
		privilegeEntity.setResource(resource);
		// hbm.xml has been set as inverse=true, to role controle it.
		/*List<RoleEntity> roleEntities = new ArrayList<RoleEntity>();
		if (roleIds != null) {
			for (Long roleId : roleIds) {
				RoleEntity roleEntity = new RoleEntity();
				roleEntity.setRoleId(roleId);
				roleEntities.add(roleEntity);
			}
		}
		privilegeEntity.setRoleEntities(roleEntities);*/
	}
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		privilegeEntityList = privilegeService.finds(privilegeEntitySearch, this.getStart(), this.getLimit());
		long total = privilegeService.getCount(privilegeEntitySearch);
		this.setTotal((int) total);
		return this.SUCCESS;
	}

	public String add() throws Exception {
		this.fillEntity();
		privilegeService.create(privilegeEntity);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		this.fillEntity();
		privilegeService.update(privilegeEntity);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if (StringUtils.isNotBlank(ids)) {
			String[] idsSplit = StringUtil.split(ids, ',');
			for (String id : idsSplit) {
				privilegeService.deleteById(Long.parseLong(id));
			}
		}
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public PrivilegeEntitySearch getPrivilegeEntitySearch() {
		return privilegeEntitySearch;
	}

	public void setPrivilegeEntitySearch(PrivilegeEntitySearch privilegeEntitySearch) {
		this.privilegeEntitySearch = privilegeEntitySearch;
	}

	public PrivilegeEntity getPrivilegeEntity() {
		return privilegeEntity;
	}

	public void setPrivilegeEntity(PrivilegeEntity privilegeEntity) {
		this.privilegeEntity = privilegeEntity;
	}

	public List<PrivilegeEntity> getPrivilegeEntityList() {
		return privilegeEntityList;
	}

	public void setPrivilegeEntityList(List<PrivilegeEntity> privilegeEntityList) {
		this.privilegeEntityList = privilegeEntityList;
	}

	public void setPrivilegeService(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}

	/*public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}*/

	public Long getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
