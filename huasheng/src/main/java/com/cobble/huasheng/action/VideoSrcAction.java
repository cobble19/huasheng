package com.cobble.huasheng.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.cobble.huasheng.dto.CategoryDTO;
import com.cobble.huasheng.dto.TopicDTO;
import com.cobble.huasheng.dto.VideoSrcDTO;
import com.cobble.huasheng.dto.VideoSrcDTOSearch;
import com.cobble.huasheng.service.VideoSrcService;

import freemarker.template.utility.StringUtil;


public class VideoSrcAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(VideoSrcAction.class);
	private VideoSrcService videoSrcService;
	private VideoSrcDTOSearch videoSrcDTOSearch = new VideoSrcDTOSearch();
	private VideoSrcDTO videoSrcDTO = new VideoSrcDTO();
	private List<VideoSrcDTO> videoSrcDTOList = new ArrayList<VideoSrcDTO>(0);
	private Long videoSrcId;
	private String name;
	// for delete, id1,id2,id3. [,]分割
	private String ids;
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		// For comboBox
		if (videoSrcDTOSearch != null && this.getQuery() != null) {
			videoSrcDTOSearch.setName(this.getQuery());
		}
		videoSrcDTOList = videoSrcService.finds(videoSrcDTOSearch, this.getStart(), this.getLimit());
		long total = videoSrcService.getCount(videoSrcDTOSearch);
		this.setTotal((int) total);
		return this.SUCCESS;
	}
	
	public String add() throws Exception {
		videoSrcDTO = new VideoSrcDTO();
		videoSrcDTO.setName(name);
		
		videoSrcService.create(videoSrcDTO);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		videoSrcDTO = new VideoSrcDTO();
		videoSrcDTO.setVideoSrcId(videoSrcId);
		videoSrcDTO.setName(name);
		
		videoSrcService.update(videoSrcDTO);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if (StringUtils.isNotBlank(ids)) {
			String[] idsSplit = StringUtil.split(ids, ',');
			for (String id : idsSplit) {
				videoSrcDTO = new VideoSrcDTO();
				videoSrcDTO.setVideoSrcId(Long.parseLong(id));
				videoSrcService.delete(videoSrcDTO);
			}
		}
		this.setSuccess(true);
		return SUCCESS;
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

	public Long getVideoSrcId() {
		return videoSrcId;
	}

	public void setVideoSrcId(Long videoSrcId) {
		this.videoSrcId = videoSrcId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

}
