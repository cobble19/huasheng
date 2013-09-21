package com.cobble.huasheng.entity;

import java.util.List;

public class TopicEntitySearch extends BaseEntitySearch {
	private Long topicId;
	private String name;
	private List<CategoryEntity> categoryEntityList;
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
	public List<CategoryEntity> getCategoryEntityList() {
		return categoryEntityList;
	}
	public void setCategoryEntityList(List<CategoryEntity> categoryEntityList) {
		this.categoryEntityList = categoryEntityList;
	}
}
