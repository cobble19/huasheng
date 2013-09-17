package com.cobble.huasheng.entity;

import java.util.List;

public class ActorEntity extends BaseEntity {
	private Long actorId;
	private String name;
	private List<ItemBaseInfoEntity> itemBaseInfoEntityList;
	
	public Long getActorId() {
		return actorId;
	}
	public void setActorId(Long actorId) {
		this.actorId = actorId;
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
