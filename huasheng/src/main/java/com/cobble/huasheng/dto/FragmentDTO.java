package com.cobble.huasheng.dto;


public class FragmentDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private String content;
	// url
	private String url;
	// a's tag link
	private String atag;
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
}
