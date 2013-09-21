package com.cobble.huasheng.dto;

import java.util.Set;

public class TopicDTO extends BaseDTO {
	private Long topicId;
	private String name;
	private Set<CategoryDTO> categoryDTOs;
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
	public Set<CategoryDTO> getCategoryDTOs() {
		return categoryDTOs;
	}
	public void setCategoryDTOs(Set<CategoryDTO> categoryDTOs) {
		this.categoryDTOs = categoryDTOs;
	}
}
