package com.cobble.huasheng.entity;

import java.util.Set;

public class ActorEntitySearch extends BaseEntitySearch {
	private Long actorId;
	private String name;
	private Set<ItemBaseInfoEntity> itemBaseInfoEntities;
	
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
	public Set<ItemBaseInfoEntity> getItemBaseInfoEntities() {
		return itemBaseInfoEntities;
	}
	public void setItemBaseInfoEntities(Set<ItemBaseInfoEntity> itemBaseInfoEntities) {
		this.itemBaseInfoEntities = itemBaseInfoEntities;
	}
}
