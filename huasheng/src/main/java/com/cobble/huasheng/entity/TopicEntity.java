package com.cobble.huasheng.entity;

import java.util.Set;

public class TopicEntity extends BaseEntity {
	private Long topicId;
	private String name;
	private Set<CategoryEntity> categoryEntities;
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
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
	
}
