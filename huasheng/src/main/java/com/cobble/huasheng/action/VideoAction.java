package com.cobble.huasheng.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.dto.VideoDTO;
import com.cobble.huasheng.dto.VideoDTOSearch;
import com.cobble.huasheng.service.VideoService;


public class VideoAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(VideoAction.class);
	private VideoService videoService;
	private VideoDTOSearch videoDTOSearch = new VideoDTOSearch();
	private VideoDTO videoDTO = new VideoDTO();
	private List<VideoDTO> videoDTOList = new ArrayList<VideoDTO>(0);
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		videoDTOList = videoService.finds(videoDTOSearch);
		return this.SUCCESS;
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

}
