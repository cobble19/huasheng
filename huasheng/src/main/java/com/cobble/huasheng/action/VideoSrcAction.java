package com.cobble.huasheng.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.dto.VideoSrcDTO;
import com.cobble.huasheng.dto.VideoSrcDTOSearch;
import com.cobble.huasheng.service.VideoSrcService;


public class VideoSrcAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(VideoSrcAction.class);
	private VideoSrcService videoSrcService;
	private VideoSrcDTOSearch videoSrcDTOSearch = new VideoSrcDTOSearch();
	private VideoSrcDTO videoSrcDTO = new VideoSrcDTO();
	private List<VideoSrcDTO> videoSrcDTOList = new ArrayList<VideoSrcDTO>(0);
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		videoSrcDTOList = videoSrcService.finds(videoSrcDTOSearch);
		return this.SUCCESS;
	}

	public VideoSrcDTOSearch getVideoSrcDTOSearch() {
		return videoSrcDTOSearch;
	}

	public void setVideoSrcDTOSearch(VideoSrcDTOSearch videoSrcDTOSearch) {
		this.videoSrcDTOSearch = videoSrcDTOSearch;
	}

	public VideoSrcDTO getVideoSrcDTO() {
		return videoSrcDTO;
	}

	public void setVideoSrcDTO(VideoSrcDTO videoSrcDTO) {
		this.videoSrcDTO = videoSrcDTO;
	}

	public List<VideoSrcDTO> getVideoSrcDTOList() {
		return videoSrcDTOList;
	}

	public void setVideoSrcDTOList(List<VideoSrcDTO> videoSrcDTOList) {
		this.videoSrcDTOList = videoSrcDTOList;
	}

	public void setVideoSrcService(VideoSrcService videoSrcService) {
		this.videoSrcService = videoSrcService;
	}

}
