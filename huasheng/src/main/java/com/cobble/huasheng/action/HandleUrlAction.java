package com.cobble.huasheng.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.dto.VideoDTO;
import com.cobble.huasheng.service.HandleUrlService;


public class HandleUrlAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(HandleUrlAction.class);
	private HandleUrlService handleUrlService;
	private String url = null;
	private List<VideoDTO> videoDTOs = new ArrayList<VideoDTO>(0);
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		videoDTOs = handleUrlService.getVideoByUrl(url);
		this.setSuccess(true);
		return this.SUCCESS;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<VideoDTO> getVideoDTOs() {
		return videoDTOs;
	}

	public void setVideoDTOs(List<VideoDTO> videoDTOs) {
		this.videoDTOs = videoDTOs;
	}

	public void setHandleUrlService(HandleUrlService handleUrlService) {
		this.handleUrlService = handleUrlService;
	}

}
