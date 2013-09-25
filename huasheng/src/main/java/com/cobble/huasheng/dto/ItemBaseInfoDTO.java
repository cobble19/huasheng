package com.cobble.huasheng.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class ItemBaseInfoDTO extends BaseDTO {
	private Long itemBaseInfoId;
	private String areaName;
	private Date showDate;
	private Double score;
	private String description;
	private ItemDTO itemDTO;
	private Set<ActorDTO> actorDTOs;
	private Set<ItemTypeDTO> itemTypeDTOs;
	public Long getItemBaseInfoId() {
		return itemBaseInfoId;
	}
	public void setItemBaseInfoId(Long itemBaseInfoId) {
		this.itemBaseInfoId = itemBaseInfoId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Date getShowDate() {
		return showDate;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ItemDTO getItemDTO() {
		return itemDTO;
	}
	public void setItemDTO(ItemDTO itemDTO) {
		this.itemDTO = itemDTO;
	}
	public Set<ActorDTO> getActorDTOs() {
		return actorDTOs;
	}
	public void setActorDTOs(Set<ActorDTO> actorDTOs) {
		this.actorDTOs = actorDTOs;
	}
	public Set<ItemTypeDTO> getItemTypeDTOs() {
		return itemTypeDTOs;
	}
	public void setItemTypeDTOs(Set<ItemTypeDTO> itemTypeDTOs) {
		this.itemTypeDTOs = itemTypeDTOs;
	}
}
