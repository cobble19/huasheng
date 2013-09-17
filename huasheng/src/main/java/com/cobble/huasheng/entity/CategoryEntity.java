package com.cobble.huasheng.entity;

import java.util.List;

public class CategoryEntity extends BaseEntity {
	private Long categoryId;
	private String name;
	private TopicEntity topicEntity;
	private List<ItemEntity> itemEntityList;
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TopicEntity getTopicEntity() {
		return topicEntity;
	}
	public void setTopicEntity(TopicEntity topicEntity) {
		this.topicEntity = topicEntity;
	}
	public List<ItemEntity> getItemEntityList() {
		return itemEntityList;
	}
	public void setItemEntityList(List<ItemEntity> itemEntityList) {
		this.itemEntityList = itemEntityList;
	}
	
	
}
