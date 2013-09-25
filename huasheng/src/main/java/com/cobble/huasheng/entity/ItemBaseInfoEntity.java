package com.cobble.huasheng.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class ItemBaseInfoEntity extends BaseEntity {
	private Long itemBaseInfoId;
	private String areaName;
	private Date showDate;
	private Double score;
	private String description;
	private ItemEntity itemEntity;
	private Set<ActorEntity> actorEntities;
	private Set<ItemTypeEntity> itemTypeEntities;
	public Long getItemBaseInfoId() {
		return itemBaseInfoId;
	}
	public void setItemBaseInfoId(Long itemBaseInfoId) {
		this.itemBaseInfoId = itemBaseInfoId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Date getShowDate() {
		return showDate;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ItemEntity getItemEntity() {
		return itemEntity;
	}
	public void setItemEntity(ItemEntity itemEntity) {
		this.itemEntity = itemEntity;
	}
	public Set<ActorEntity> getActorEntities() {
		return actorEntities;
	}
	public void setActorEntities(Set<ActorEntity> actorEntities) {
		this.actorEntities = actorEntities;
	}
	public Set<ItemTypeEntity> getItemTypeEntities() {
		return itemTypeEntities;
	}
	public void setItemTypeEntities(Set<ItemTypeEntity> itemTypeEntities) {
		this.itemTypeEntities = itemTypeEntities;
	}
}
