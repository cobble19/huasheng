package com.cobble.huasheng.entity;

/**
 * 视频信息
 * @author publiclzhc@sina.com
 *
 */
public class VideoEntity extends BaseEntity {
	// 唯一标识
	private Long videoId;
	// 视频地址
	private String url;
	// 第几集， 顺序
	private Integer orederNum;
	// 所属的个体
	private ItemEntity itemEntity;
	// 所属的厂家
	private VideoSrcEntity videoSrcEntity;
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
	public ItemEntity getItemEntity() {
		return itemEntity;
	}
	public void setItemEntity(ItemEntity itemEntity) {
		this.itemEntity = itemEntity;
	}
	public VideoSrcEntity getVideoSrcEntity() {
		return videoSrcEntity;
	}
	public void setVideoSrcEntity(VideoSrcEntity videoSrcEntity) {
		this.videoSrcEntity = videoSrcEntity;
	}
	public Integer getOrederNum() {
		return orederNum;
	}
	public void setOrederNum(Integer orederNum) {
		this.orederNum = orederNum;
	}
}
