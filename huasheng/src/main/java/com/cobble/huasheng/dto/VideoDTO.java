package com.cobble.huasheng.dto;

public class VideoDTO extends BaseDTO {
	private Long videoId;
	private String url;
	private ItemDTO itemDTO;
	private VideoSrcDTO videoSrcDTO;
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
	public ItemDTO getItemDTO() {
		return itemDTO;
	}
	public void setItemDTO(ItemDTO itemDTO) {
		this.itemDTO = itemDTO;
	}
	public VideoSrcDTO getVideoSrcDTO() {
		return videoSrcDTO;
	}
	public void setVideoSrcDTO(VideoSrcDTO videoSrcDTO) {
		this.videoSrcDTO = videoSrcDTO;
	}
}
