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
	// 视频地址
	private String url;
	// 第几集， 顺序
	private Integer orederNum;
	private ItemDTO itemDTO;
	private VideoSrcDTO videoSrcDTO;
	// for delete, id1,id2,id3. [,]分割
	private String ids;
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		videoDTOList = videoService.finds(videoDTOSearch);
		return this.SUCCESS;
	}

	public String add() throws Exception {
		videoDTO = new VideoDTO();
		videoDTO.setUrl(url);
		videoDTO.setOrederNum(orederNum);
		videoDTO.setItemDTO(itemDTO);
		videoDTO.setVideoSrcDTO(videoSrcDTO);
		videoService.create(videoDTO);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		videoDTO = new VideoDTO();
		videoDTO.setVideoId(videoId);
		videoDTO.setUrl(url);
		videoDTO.setOrederNum(orederNum);
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

	public Integer getOrederNum() {
		return orederNum;
	}

	public void setOrederNum(Integer orederNum) {
		this.orederNum = orederNum;
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

}
