package com.cobble.huasheng.dto;

import java.util.Set;

public class VideoSrcDTOSearch extends BaseDTOSearch {
	private Long videoSrcId;
	private String name;
	private Set<VideoDTO> videoDTOs;
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
	public Set<VideoDTO> getVideoDTOs() {
		return videoDTOs;
	}
	public void setVideoDTOs(Set<VideoDTO> videoDTOs) {
		this.videoDTOs = videoDTOs;
	}
}
