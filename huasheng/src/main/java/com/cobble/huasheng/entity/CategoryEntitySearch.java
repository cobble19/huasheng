package com.cobble.huasheng.entity;

import java.util.Set;

public class CategoryEntitySearch extends BaseEntitySearch {
	private Long categoryId;
	private String name;
	private TopicEntity topicEntity;
	private Set<ItemEntity> itemEntities;
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
	public Set<ItemEntity> getItemEntities() {
		return itemEntities;
	}
	public void setItemEntities(Set<ItemEntity> itemEntities) {
		this.itemEntities = itemEntities;
	}
	
}
