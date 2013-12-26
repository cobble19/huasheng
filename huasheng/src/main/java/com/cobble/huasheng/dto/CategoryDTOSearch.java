package com.cobble.huasheng.dto;

import java.util.List;

public class CategoryDTOSearch extends BaseDTOSearch {
	private Long categoryId;
	private String name;
	private TopicDTO topicDTO;
	private List<ItemDTO> itemDTOs;
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
	public TopicDTO getTopicDTO() {
		return topicDTO;
	}
	public void setTopicDTO(TopicDTO topicDTO) {
		this.topicDTO = topicDTO;
	}
	public List<ItemDTO> getItemDTOs() {
		return itemDTOs;
	}
	public void setItemDTOs(List<ItemDTO> itemDTOs) {
		this.itemDTOs = itemDTOs;
	}
	
}
