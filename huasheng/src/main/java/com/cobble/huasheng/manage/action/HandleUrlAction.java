package com.cobble.huasheng.manage.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.action.BaseAction;
import com.cobble.huasheng.dto.FragmentDTO;
import com.cobble.huasheng.dto.FragmentDTOSearch;
import com.cobble.huasheng.dto.ItemDTO;
import com.cobble.huasheng.dto.VideoDTO;
import com.cobble.huasheng.dto.VideoSrcDTO;
import com.cobble.huasheng.service.HandleUrlService;


public class HandleUrlAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(HandleUrlAction.class);
	private HandleUrlService handleUrlService;
	private List<VideoDTO> videoDTOList = new ArrayList<VideoDTO>(0);
	private FragmentDTOSearch fragmentDTOSearch = new FragmentDTOSearch();
	private List<FragmentDTO> fragmentDTOList = new ArrayList<FragmentDTO>(0);
	private ItemDTO itemDTO = new ItemDTO();
	private VideoSrcDTO videoSrcDTO = new VideoSrcDTO();
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		videoDTOList = handleUrlService.getVideoByUrl(fragmentDTOSearch.getUrl());
		if (videoDTOList == null) {
			videoDTOList = new ArrayList<VideoDTO>(0);
		}
		this.setSuccess(true);
		return this.SUCCESS;
	}
	
	public String fragment() throws Exception {
		logger.debug("fragment() start...");
		fragmentDTOList = handleUrlService.getFragmentByUrl(fragmentDTOSearch.getUrl());
		if (fragmentDTOList == null) {
			fragmentDTOList = new ArrayList<FragmentDTO>(0);
		}
		this.setSuccess(true);
		return this.SUCCESS;
	}
	
	public String add() throws Exception {
		logger.debug("add() start...");
		fragmentDTOSearch.setItemDTO(itemDTO);
		fragmentDTOSearch.setVideoSrcDTO(videoSrcDTO);
		handleUrlService.addVideo(fragmentDTOSearch);
		this.setSuccess(true);
		return this.SUCCESS;
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

	public FragmentDTOSearch getFragmentDTOSearch() {
		return fragmentDTOSearch;
	}

	public void setFragmentDTOSearch(FragmentDTOSearch fragmentDTOSearch) {
		this.fragmentDTOSearch = fragmentDTOSearch;
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
