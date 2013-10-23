package com.cobble.huasheng.entity;

import java.util.Set;
/**
 * 个体类型， 如剧情， 动作
 * 可能过度设计， 移入ItemEntity
 * @author publiclzhc@sina.com
 *
 */
public class ItemTypeEntity extends BaseEntity {
	// 唯一标识
	private Long itemTypeId;
	// 类型名称
	private String name;
	// 多对多关系
	private Set<ItemBaseInfoEntity> itemBaseInfoEntities;
	public Long getItemTypeId() {
		return itemTypeId;
	}
	public void setItemTypeId(Long itemTypeId) {
		this.itemTypeId = itemTypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<ItemBaseInfoEntity> getItemBaseInfoEntities() {
		return itemBaseInfoEntities;
	}
	public void setItemBaseInfoEntities(Set<ItemBaseInfoEntity> itemBaseInfoEntities) {
		this.itemBaseInfoEntities = itemBaseInfoEntities;
	}
}
