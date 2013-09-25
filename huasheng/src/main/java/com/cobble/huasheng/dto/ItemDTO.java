package com.cobble.huasheng.dto;

import java.util.Set;

public class ItemDTO extends BaseDTO {
	private Long itemId;
	private String name;
	private Set<CategoryDTO> categoryDTOs;
	private ItemBaseInfoDTO itemBaseInfoDTO;
	private Set<VideoDTO> videoDTOs;
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
	public Set<CategoryDTO> getCategoryDTOs() {
		return categoryDTOs;
	}
	public void setCategoryDTOs(Set<CategoryDTO> categoryDTOs) {
		this.categoryDTOs = categoryDTOs;
	}
	public ItemBaseInfoDTO getItemBaseInfoDTO() {
		return itemBaseInfoDTO;
	}
	public void setItemBaseInfoDTO(ItemBaseInfoDTO itemBaseInfoDTO) {
		this.itemBaseInfoDTO = itemBaseInfoDTO;
	}
	public Set<VideoDTO> getVideoDTOs() {
		return videoDTOs;
	}
	public void setVideoDTOs(Set<VideoDTO> videoDTOs) {
		this.videoDTOs = videoDTOs;
	}
	
}
