package com.cobble.huasheng.entity;

import java.util.List;

public class ItemEntity extends BaseEntity {
	private Long itemId;
	private String name;
	private List<CategoryEntity> categoryEntityList;
	private ItemBaseInfoEntity itemBaseInfoEntity;
	private List<VideoEntity> videoEntityList;
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CategoryEntity> getCategoryEntityList() {
		return categoryEntityList;
	}
	public void setCategoryEntityList(List<CategoryEntity> categoryEntityList) {
		this.categoryEntityList = categoryEntityList;
	}
	public ItemBaseInfoEntity getItemBaseInfoEntity() {
		return itemBaseInfoEntity;
	}
	public void setItemBaseInfoEntity(ItemBaseInfoEntity itemBaseInfoEntity) {
		this.itemBaseInfoEntity = itemBaseInfoEntity;
	}
	public List<VideoEntity> getVideoEntityList() {
		return videoEntityList;
	}
	public void setVideoEntityList(List<VideoEntity> videoEntityList) {
		this.videoEntityList = videoEntityList;
	}
	
}
