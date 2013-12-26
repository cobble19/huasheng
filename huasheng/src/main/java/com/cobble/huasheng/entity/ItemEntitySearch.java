package com.cobble.huasheng.entity;

import java.util.List;

public class ItemEntitySearch extends BaseEntitySearch {
	private Long itemId;
	private String name;
	private List<CategoryEntity> categoryEntities;
	private List<VideoEntity> videoEntities;
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
	public List<CategoryEntity> getCategoryEntities() {
		return categoryEntities;
	}
	public void setCategoryEntities(List<CategoryEntity> categoryEntities) {
		this.categoryEntities = categoryEntities;
	}
	public List<VideoEntity> getVideoEntities() {
		return videoEntities;
	}
	public void setVideoEntities(List<VideoEntity> videoEntities) {
		this.videoEntities = videoEntities;
	}
	
}
