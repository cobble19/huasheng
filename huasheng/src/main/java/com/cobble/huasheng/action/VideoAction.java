package com.cobble.huasheng.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.cobble.huasheng.dto.CategoryDTO;
import com.cobble.huasheng.dto.ItemDTO;
import com.cobble.huasheng.dto.TopicDTO;
import com.cobble.huasheng.dto.VideoDTO;
import com.cobble.huasheng.dto.VideoDTOSearch;
import com.cobble.huasheng.dto.VideoSrcDTO;
import com.cobble.huasheng.service.VideoService;

import freemarker.template.utility.StringUtil;


public class VideoAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(VideoAction.class);
	private VideoService videoService;
	private VideoDTOSearch videoDTOSearch = new VideoDTOSearch();
	private VideoDTO videoDTO = new VideoDTO();
	private List<VideoDTO> videoDTOList = new ArrayList<VideoDTO>(0);
	
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
	private ItemDTO itemDTO;
	private VideoSrcDTO videoSrcDTO;
	// for delete, id1,id2,id3. [,]分割
	private String ids;
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		videoDTOList = videoService.finds(videoDTOSearch, this.getStart(), this.getLimit());
		long total = videoService.getCount(videoDTOSearch);
		this.setTotal((int) total);
		return this.SUCCESS;
	}

	public String add() throws Exception {
		videoDTO = new VideoDTO();
		videoDTO.setName(name);
		videoDTO.setUrl(url);
		videoDTO.setOrderNum(orderNum);
		videoDTO.setTitle(title);
		videoDTO.setText(text);
		videoDTO.setTarget(target);
		videoDTO.setItemDTO(itemDTO);
		videoDTO.setVideoSrcDTO(videoSrcDTO);
		videoService.create(videoDTO);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		videoDTO = new VideoDTO();
		videoDTO.setVideoId(videoId);
		videoDTO.setName(name);
		videoDTO.setUrl(url);
		videoDTO.setOrderNum(orderNum);
		videoDTO.setTitle(title);
		videoDTO.setText(text);
		videoDTO.setTarget(target);
		videoDTO.setItemDTO(itemDTO);
		videoDTO.setVideoSrcDTO(videoSrcDTO);
		videoService.update(videoDTO);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if (StringUtils.isNotBlank(ids)) {
			String[] idsSplit = StringUtil.split(ids, ',');
			for (String id : idsSplit) {
				videoDTO = new VideoDTO();
				videoDTO.setVideoId(Long.parseLong(id));
				videoService.delete(videoDTO);
			}
		}
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public VideoDTOSearch getVideoDTOSearch() {
		return videoDTOSearch;
	}

	public void setVideoDTOSearch(VideoDTOSearch videoDTOSearch) {
		this.videoDTOSearch = videoDTOSearch;
	}

	public VideoDTO getVideoDTO() {
		return videoDTO;
	}

	public void setVideoDTO(VideoDTO videoDTO) {
		this.videoDTO = videoDTO;
	}

	public List<VideoDTO> getVideoDTOList() {
		return videoDTOList;
	}

	public void setVideoDTOList(List<VideoDTO> videoDTOList) {
		this.videoDTOList = videoDTOList;
	}

	public void setVideoService(VideoService videoService) {
		this.videoService = videoService;
	}

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

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
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
