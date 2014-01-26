package com.cobble.huasheng.entity;

import java.util.List;
import java.util.List;

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
	// 排序
	private Integer orderNo;
	// 所属主题
	private TopicEntity topicEntity;
	// 拥有的个体，如一部电视剧
	private List<ItemEntity> itemEntities;
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
	public List<ItemEntity> getItemEntities() {
		return itemEntities;
	}
	public void setItemEntities(List<ItemEntity> itemEntities) {
		this.itemEntities = itemEntities;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	
}
