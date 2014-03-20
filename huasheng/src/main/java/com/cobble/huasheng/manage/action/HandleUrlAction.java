package com.cobble.huasheng.manage.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.action.BaseAction;
import com.cobble.huasheng.dto.FragmentDTO;
import com.cobble.huasheng.dto.VideoDTO;
import com.cobble.huasheng.service.HandleUrlService;


public class HandleUrlAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(HandleUrlAction.class);
	private HandleUrlService handleUrlService;
	private String url = null;
	private List<VideoDTO> videoDTOList = new ArrayList<VideoDTO>(0);
	private List<FragmentDTO> fragmentDTOList = new ArrayList<FragmentDTO>(0);
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		videoDTOList = handleUrlService.getVideoByUrl(url);
		if (videoDTOList == null) {
			videoDTOList = new ArrayList<VideoDTO>(0);
		}
		this.setSuccess(true);
		return this.SUCCESS;
	}
	
	public String fragment() throws Exception {
		logger.debug("execute() start...");
		fragmentDTOList = handleUrlService.getFragmentByUrl(url);
		if (fragmentDTOList == null) {
			fragmentDTOList = new ArrayList<FragmentDTO>(0);
		}
		this.setSuccess(true);
		return this.SUCCESS;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setHandleUrlService(HandleUrlService handleUrlService) {
		this.handleUrlService = handleUrlService;
	}

	public List<VideoDTO> getVideoDTOList() {
		return videoDTOList;
	}

	public void setVideoDTOList(List<VideoDTO> videoDTOList) {
		this.videoDTOList = videoDTOList;
	}

	public List<FragmentDTO> getFragmentDTOList() {
		return fragmentDTOList;
	}

	public void setFragmentDTOList(List<FragmentDTO> fragmentDTOList) {
		this.fragmentDTOList = fragmentDTOList;
	}

}
