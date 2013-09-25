package com.cobble.huasheng.entity;

public class VideoEntitySearch extends BaseEntitySearch {
	private Long videoId;
	private String url;
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
}
