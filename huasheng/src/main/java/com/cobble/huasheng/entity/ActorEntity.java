package com.cobble.huasheng.entity;

import java.util.Set;
/**
 * 演员
 * @author publiclzhc@sina.com
 *
 */
public class ActorEntity extends BaseEntity {
	// 唯一标识
	private Long actorId;
	// 演员名称
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
