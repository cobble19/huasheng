package com.cobble.huasheng.dto;

public class VideoDTO extends BaseDTO {
	private Long videoId;
	private String url;
	private Integer orderNum;
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
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((videoId == null) ? 0 : videoId.hashCode());
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
		VideoDTO other = (VideoDTO) obj;
		if (videoId == null) {
			if (other.videoId != null)
				return false;
		} else if (!videoId.equals(other.videoId))
			return false;
		return true;
	}
}
