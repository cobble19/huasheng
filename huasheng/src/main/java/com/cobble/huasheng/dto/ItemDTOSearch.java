package com.cobble.huasheng.dto;

import java.util.List;

public class ItemDTOSearch extends BaseDTOSearch {
	private Long itemId;
	private String name;
	private List<CategoryDTO> categoryDTOs;
	private List<VideoDTO> videoDTOs;
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
	public List<CategoryDTO> getCategoryDTOs() {
		return categoryDTOs;
	}
	public void setCategoryDTOs(List<CategoryDTO> categoryDTOs) {
		this.categoryDTOs = categoryDTOs;
	}
	public List<VideoDTO> getVideoDTOs() {
		return videoDTOs;
	}
	public void setVideoDTOs(List<VideoDTO> videoDTOs) {
		this.videoDTOs = videoDTOs;
	}
	
}
