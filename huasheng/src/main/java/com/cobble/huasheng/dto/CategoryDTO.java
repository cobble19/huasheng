package com.cobble.huasheng.dto;

import java.util.List;
import java.util.Set;

import com.cobble.huasheng.entity.ItemEntity;
import com.cobble.huasheng.entity.TopicEntity;

public class CategoryDTO extends BaseDTO {
	private Long categoryId;
	private String name;
	private TopicDTO topicDTO;
	private Set<ItemDTO> itemDTOs;
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
	public Set<ItemDTO> getItemDTOs() {
		return itemDTOs;
	}
	public void setItemDTOs(Set<ItemDTO> itemDTOs) {
		this.itemDTOs = itemDTOs;
	}
	
}