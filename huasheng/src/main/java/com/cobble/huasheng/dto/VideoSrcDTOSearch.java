package com.cobble.huasheng.dto;

import java.util.List;

public class VideoSrcDTOSearch extends BaseDTOSearch {
	private Long videoSrcId;
	private String name;
	private List<VideoDTO> videoDTOs;
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
	public List<VideoDTO> getVideoDTOs() {
		return videoDTOs;
	}
	public void setVideoDTOs(List<VideoDTO> videoDTOs) {
		this.videoDTOs = videoDTOs;
	}
}
