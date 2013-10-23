package com.cobble.huasheng.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 个体元素的基本信息。
 * 认为过度设计， 先转到ItemEntity @2013/10/23
 * @author publiclzhc@sina.com
 *
 */
public class ItemBaseInfoEntity extends BaseEntity {
	// 唯一标识
	private Long itemBaseInfoId;
	// 区域名称
	private String areaName;
	// 上映日期
	private Date showDate;
	// 总评分
	private Double score;
	// 描述
	private String description;
	// 所属个体
	private ItemEntity itemEntity;
	// 参与的演员
	private Set<ActorEntity> actorEntities;
	// 个体种类
	private Set<ItemTypeEntity> itemTypeEntities;
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
	public ItemEntity getItemEntity() {
		return itemEntity;
	}
	public void setItemEntity(ItemEntity itemEntity) {
		this.itemEntity = itemEntity;
	}
	public Set<ActorEntity> getActorEntities() {
		return actorEntities;
	}
	public void setActorEntities(Set<ActorEntity> actorEntities) {
		this.actorEntities = actorEntities;
	}
	public Set<ItemTypeEntity> getItemTypeEntities() {
		return itemTypeEntities;
	}
	public void setItemTypeEntities(Set<ItemTypeEntity> itemTypeEntities) {
		this.itemTypeEntities = itemTypeEntities;
	}
}
