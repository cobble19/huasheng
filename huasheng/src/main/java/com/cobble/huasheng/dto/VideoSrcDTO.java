package com.cobble.huasheng.dto;

import java.util.List;

public class VideoSrcDTO extends BaseDTO {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((videoSrcId == null) ? 0 : videoSrcId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VideoSrcDTO other = (VideoSrcDTO) obj;
		if (videoSrcId == null) {
			if (other.videoSrcId != null)
				return false;
		} else if (!videoSrcId.equals(other.videoSrcId))
			return false;
		return true;
	}
}
