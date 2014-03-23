package com.cobble.huasheng.entity;

/**
 * 视频信息
 * @author publiclzhc@sina.com
 *
 */
public class VideoEntity extends BaseEntity {
	// 唯一标识
	private Long videoId;
	// 名称
	private String name;
	// 视频地址
	private String url;
	// 第几集， 顺序
	private Integer orderNum;
	// title
	private String title;
	// text
	private String text;
	// target
	private String target;
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
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
