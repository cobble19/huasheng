package com.cobble.huasheng.dto;

import java.util.Date;
import java.util.Set;

public class ItemDTO extends BaseDTO {
	private Long itemId;
	private String name;
	private Long hits;
	
	// 区域名称
	private String areaName;
	// 上映日期
	private Date showDate;
	// 总评分
	private Double score;
	// 描述
	private String description;
	// 参与的演员，[,]分割
	private String actorName;
	// 个体种类, 如剧情，动作，[,]分割
	private String itemType;
	
	private Set<CategoryDTO> categoryDTOs;
	/*private ItemBaseInfoDTO itemBaseInfoDTO;*/
	private Set<VideoDTO> videoDTOs;
	// addition added
	private Set<VideoSrcDTO> videoSrcDTOs;
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
	/*public ItemBaseInfoDTO getItemBaseInfoDTO() {
		return itemBaseInfoDTO;
	}
	public void setItemBaseInfoDTO(ItemBaseInfoDTO itemBaseInfoDTO) {
		this.itemBaseInfoDTO = itemBaseInfoDTO;
	}*/
	public Set<VideoDTO> getVideoDTOs() {
		return videoDTOs;
	}
	public void setVideoDTOs(Set<VideoDTO> videoDTOs) {
		this.videoDTOs = videoDTOs;
	}
	public Long getHits() {
		return hits;
	}
	public void setHits(Long hits) {
		this.hits = hits;
	}
	public Set<VideoSrcDTO> getVideoSrcDTOs() {
		return videoSrcDTOs;
	}
	public void setVideoSrcDTOs(Set<VideoSrcDTO> videoSrcDTOs) {
		this.videoSrcDTOs = videoSrcDTOs;
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
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
}
