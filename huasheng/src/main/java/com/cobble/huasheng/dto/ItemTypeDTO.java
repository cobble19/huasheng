package com.cobble.huasheng.dto;

import java.util.Set;

public class ItemTypeDTO extends BaseDTO {
	private Long itemTypeId;
	private String name;
	private Set<ItemBaseInfoDTO> itemBaseInfoDTOs;
	public Long getItemTypeId() {
		return itemTypeId;
	}
	public void setItemTypeId(Long itemTypeId) {
		this.itemTypeId = itemTypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<ItemBaseInfoDTO> getItemBaseInfoDTOs() {
		return itemBaseInfoDTOs;
	}
	public void setItemBaseInfoDTOs(Set<ItemBaseInfoDTO> itemBaseInfoDTOs) {
		this.itemBaseInfoDTOs = itemBaseInfoDTOs;
	}
}
