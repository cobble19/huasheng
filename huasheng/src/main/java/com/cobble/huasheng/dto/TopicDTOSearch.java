package com.cobble.huasheng.dto;

import java.util.List;

public class TopicDTOSearch extends BaseDTOSearch {
	private Long topicId;
	private String name;
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
}
