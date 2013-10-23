package com.cobble.huasheng.entity;

import java.util.List;
import java.util.Set;

/**
 * 类别， 如动作片， 剧情片
 * @author publiclzhc@sina.com
 *
 */
public class CategoryEntity extends BaseEntity {
	// 唯一标识
	private Long categoryId;
	// 类别名称
	private String name;
	// 所属主题
	private TopicEntity topicEntity;
	// 拥有的个体，如一部电视剧
	private Set<ItemEntity> itemEntities;
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
	public TopicEntity getTopicEntity() {
		return topicEntity;
	}
	public void setTopicEntity(TopicEntity topicEntity) {
		this.topicEntity = topicEntity;
	}
	public Set<ItemEntity> getItemEntities() {
		return itemEntities;
	}
	public void setItemEntities(Set<ItemEntity> itemEntities) {
		this.itemEntities = itemEntities;
	}
	
}
