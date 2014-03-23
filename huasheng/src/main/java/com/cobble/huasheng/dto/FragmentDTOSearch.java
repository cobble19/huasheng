package com.cobble.huasheng.dto;


public class FragmentDTOSearch extends BaseDTOSearch {
	private String content;
	// url
	private String url;
	// a's tag link
	private String atag;
	private ItemDTO itemDTO;
	private VideoSrcDTO videoSrcDTO;
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAtag() {
		return atag;
	}

	public void setAtag(String atag) {
		this.atag = atag;
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
