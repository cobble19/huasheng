package com.cobble.huasheng.entity;

import java.util.Set;

public class VideoSrcEntity extends BaseEntity {
	private Long videoSrcId;
	private String name;
	private Set<VideoEntity> videoEntities;
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
	public Set<VideoEntity> getVideoEntities() {
		return videoEntities;
	}
	public void setVideoEntities(Set<VideoEntity> videoEntities) {
		this.videoEntities = videoEntities;
	}
}
