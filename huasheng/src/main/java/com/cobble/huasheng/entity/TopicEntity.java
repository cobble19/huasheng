package com.cobble.huasheng.entity;

import java.util.Set;

/**
 * 主题， 如电视剧， 动漫
 * @author publiclzhc@sina.com
 *
 */
public class TopicEntity extends BaseEntity {
	// 唯一标识
	private Long topicId;
	// 主题名称
	private String name;
	private Set<CategoryEntity> categoryEntities;
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<CategoryEntity> getCategoryEntities() {
		return categoryEntities;
	}
	public void setCategoryEntities(Set<CategoryEntity> categoryEntities) {
		this.categoryEntities = categoryEntities;
	}
	
}
