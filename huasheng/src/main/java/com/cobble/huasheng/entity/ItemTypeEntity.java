package com.cobble.huasheng.entity;

import java.util.List;

public class ItemTypeEntity extends BaseEntity {
	private Long itemTypeId;
	private String name;
	private List<ItemBaseInfoEntity> itemBaseInfoEntityList;
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
	public List<ItemBaseInfoEntity> getItemBaseInfoEntityList() {
		return itemBaseInfoEntityList;
	}
	public void setItemBaseInfoEntityList(
			List<ItemBaseInfoEntity> itemBaseInfoEntityList) {
		this.itemBaseInfoEntityList = itemBaseInfoEntityList;
	}
}
