package com.cobble.huasheng.dto;

import java.util.List;

public class TopicDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private Long topicId;
	private String name;
	private List<CategoryDTO> categoryDTOs;
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
	public List<CategoryDTO> getCategoryDTOs() {
		return categoryDTOs;
	}
	public void setCategoryDTOs(List<CategoryDTO> categoryDTOs) {
		this.categoryDTOs = categoryDTOs;
	}
}
