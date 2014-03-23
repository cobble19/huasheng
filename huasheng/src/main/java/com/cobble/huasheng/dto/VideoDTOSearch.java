package com.cobble.huasheng.dto;

public class VideoDTOSearch extends BaseDTOSearch {
	private Long videoId;
	// 名称
	private String name;
	private String url;
	private Integer orderNum;
	// title
	private String title;
	// text
	private String text;
	// target
	private String target;
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
