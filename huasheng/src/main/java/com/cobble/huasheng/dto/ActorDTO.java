package com.cobble.huasheng.dto;

import java.util.Set;

public class ActorDTO extends BaseDTO {
	private Long actorId;
	private String name;
	private Set<ItemBaseInfoDTO> itemBaseInfoDTOs;
	
	public Long getActorId() {
		return actorId;
	}
	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<ItemBaseInfoDTO> getItemBaseInfoDTOs() {
		return itemBaseInfoDTOs;
	}
	public void setItemBaseInfoDTOs(Set<ItemBaseInfoDTO> itemBaseInfoDTOs) {
		this.itemBaseInfoDTOs = itemBaseInfoDTOs;
	}
}
