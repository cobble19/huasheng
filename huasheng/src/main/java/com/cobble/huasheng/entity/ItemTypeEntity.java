package com.cobble.huasheng.entity;

import java.util.Set;

public class ItemTypeEntity extends BaseEntity {
	private Long itemTypeId;
	private String name;
	private Set<ItemBaseInfoEntity> itemBaseInfoEntities;
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
	public Set<ItemBaseInfoEntity> getItemBaseInfoEntities() {
		return itemBaseInfoEntities;
	}
	public void setItemBaseInfoEntities(Set<ItemBaseInfoEntity> itemBaseInfoEntities) {
		this.itemBaseInfoEntities = itemBaseInfoEntities;
	}
}
