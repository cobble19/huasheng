package com.cobble.huasheng.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.dto.TopicDTO;
import com.cobble.huasheng.dto.TopicDTOSearch;
import com.cobble.huasheng.service.TopicService;


public class TopicAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(TopicAction.class);
	private TopicService topicService;
	private TopicDTOSearch topicDTOSearch = new TopicDTOSearch();
	private TopicDTO topicDTO = new TopicDTO();
	private List<TopicDTO> topicDTOList = new ArrayList<TopicDTO>(0);
	
	@Override
	public String execute() throws Exception {
		topicDTOList = topicService.finds(topicDTOSearch);
		return this.SUCCESS;
	}

	public TopicDTOSearch getTopicDTOSearch() {
		return topicDTOSearch;
	}

	public void setTopicDTOSearch(TopicDTOSearch topicDTOSearch) {
		this.topicDTOSearch = topicDTOSearch;
	}

	public TopicDTO getTopicDTO() {
		return topicDTO;
	}

	public void setTopicDTO(TopicDTO topicDTO) {
		this.topicDTO = topicDTO;
	}

	public List<TopicDTO> getTopicDTOList() {
		return topicDTOList;
	}

	public void setTopicDTOList(List<TopicDTO> topicDTOList) {
		this.topicDTOList = topicDTOList;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

}
