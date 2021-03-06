package com.cobble.huasheng.entity;

import java.util.Date;
import java.util.List;

/**
 * 个体
 * @author publiclzhc@sina.com
 *
 */
public class ItemEntity extends BaseEntity {
	// 唯一标识
	private Long itemId;
	// 个体名称
	private String name;
	// 点击次数
	private Long hits;
	// 来自itemBaseInfo
	// 区域名称
	private String areaName;
	// 上映日期
	private Date showDate;
	// added @03/21/2014
	private Integer year;
	// 总评分
	private Double score;
	// 描述
	private String description;
	// 参与的演员，[,]分割
	private String actorName;
	// 个体种类, 如剧情，动作，[,]分割
	private String itemType;
	// 导演
	private String director;
	// 图片
	private String imgUrl;
		
	/*private ItemBaseInfoEntity itemBaseInfoEntity;*/
	/*private List<CategoryEntity> categoryEntities;*/
	private CategoryEntity categoryEntity;
	private List<VideoSrcEntity> videoSrcEntities;
	private List<VideoEntity> videoEntities;
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
	public Long getHits() {
		return hits;
	}
	public void setHits(Long hits) {
		this.hits = hits;
	}
	public List<VideoSrcEntity> getVideoSrcEntities() {
		return videoSrcEntities;
	}
	public void setVideoSrcEntities(List<VideoSrcEntity> videoSrcEntities) {
		this.videoSrcEntities = videoSrcEntities;
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
	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}
	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}
	public List<VideoEntity> getVideoEntities() {
		return videoEntities;
	}
	public void setVideoEntities(List<VideoEntity> videoEntities) {
		this.videoEntities = videoEntities;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
}
