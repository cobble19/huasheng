package com.cobble.huasheng.entity;

import java.util.Set;

/**
 * 视频厂家
 * @author publiclzhc@sina.com
 *
 */
public class VideoSrcEntity extends BaseEntity {
	// 唯一标识
	private Long videoSrcId;
	// 厂家名称
	private String name;
	// 拥有的视频
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
