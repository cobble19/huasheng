package com.cobble.huasheng.entity;

public class VideoEntitySearch extends BaseEntitySearch {
	private Long videoId;
	private String name;
	private String url;
	// 第几集， 顺序
	private Integer orderNum;
	// title
	private String title;
	// text
	private String text;
	// target
	private String target;
	private ItemEntity itemEntity;
	private VideoSrcEntity videoSrcEntity;
	public Long getVideoId() {
		return videoId;
	}
	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ItemEntity getItemEntity() {
		return itemEntity;
	}
	public void setItemEntity(ItemEntity itemEntity) {
		this.itemEntity = itemEntity;
	}
	public VideoSrcEntity getVideoSrcEntity() {
		return videoSrcEntity;
	}
	public void setVideoSrcEntity(VideoSrcEntity videoSrcEntity) {
		this.videoSrcEntity = videoSrcEntity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
}
