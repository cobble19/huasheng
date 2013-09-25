package com.cobble.huasheng.entity;

import java.util.List;

public class VideoSrcEntity extends BaseEntity {
	private Long videoSrcId;
	private String name;
	private List<VideoEntity> videoEntities;
	public Long getVideoSrcId() {
		return videoSrcId;
	}
	public void setVideoSrcId(Long videoSrcId) {
		this.videoSrcId = videoSrcId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<VideoEntity> getVideoEntities() {
		return videoEntities;
	}
	public void setVideoEntities(List<VideoEntity> videoEntities) {
		this.videoEntities = videoEntities;
	}
}
