package com.cobble.huasheng.entity;

import java.util.Date;
import java.util.List;

public class ItemBaseInfoEntity extends BaseEntity {
	private Long itemBaseInfoId;
	private String areaName;
	private Date showDate;
	private Double score;
	private String description;
	private ItemEntity itemEntity;
	private List<ActorEntity> actorEntityList;
	private List<ItemTypeEntity> itemTypeEntityList;
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
	public List<ActorEntity> getActorEntityList() {
		return actorEntityList;
	}
	public void setActorEntityList(List<ActorEntity> actorEntityList) {
		this.actorEntityList = actorEntityList;
	}
	public List<ItemTypeEntity> getItemTypeEntityList() {
		return itemTypeEntityList;
	}
	public void setItemTypeEntityList(List<ItemTypeEntity> itemTypeEntityList) {
		this.itemTypeEntityList = itemTypeEntityList;
	}
}
