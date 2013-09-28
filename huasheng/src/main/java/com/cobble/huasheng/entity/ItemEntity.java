package com.cobble.huasheng.entity;

import java.util.Set;

public class ItemEntity extends BaseEntity {
	private Long itemId;
	private String name;
	private Long hits;
	private ItemBaseInfoEntity itemBaseInfoEntity;
	private Set<CategoryEntity> categoryEntities;
	private Set<VideoSrcEntity> videoSrcEntities;
	/*private Set<VideoEntity> videoEntities;*/
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
	public Set<CategoryEntity> getCategoryEntities() {
		return categoryEntities;
	}
	public void setCategoryEntities(Set<CategoryEntity> categoryEntities) {
		this.categoryEntities = categoryEntities;
	}
	public ItemBaseInfoEntity getItemBaseInfoEntity() {
		return itemBaseInfoEntity;
	}
	public void setItemBaseInfoEntity(ItemBaseInfoEntity itemBaseInfoEntity) {
		this.itemBaseInfoEntity = itemBaseInfoEntity;
	}
	public Long getHits() {
		return hits;
	}
	public void setHits(Long hits) {
		this.hits = hits;
	}
	public Set<VideoSrcEntity> getVideoSrcEntities() {
		return videoSrcEntities;
	}
	public void setVideoSrcEntities(Set<VideoSrcEntity> videoSrcEntities) {
		this.videoSrcEntities = videoSrcEntities;
	}
	
}
