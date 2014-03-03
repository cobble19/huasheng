package com.cobble.huasheng.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.dto.ItemDTO;
import com.cobble.huasheng.dto.ItemDTOSearch;
import com.cobble.huasheng.dto.TopicDTO;
import com.cobble.huasheng.dto.TopicDTOSearch;
import com.cobble.huasheng.service.ItemService;
import com.cobble.huasheng.service.TopicService;
import com.cobble.huasheng.util.ListUtil;


public class IndexAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(IndexAction.class);
	private TopicService topicService;
	private ItemService itemService;
	private List<ItemDTO> itemDTOList;
	private TopicDTOSearch topicDTOSearch = new TopicDTOSearch();
	private TopicDTO topicDTO = new TopicDTO();
	private List<TopicDTO> topicDTOList = new ArrayList<TopicDTO>(0);
	// topicId
	private Long topicId;
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		topicDTOList = topicService.finds(topicDTOSearch);
		if (topicId == null && ListUtil.isNotEmpty(topicDTOList)) {
			topicId = topicDTOList.get(0).getTopicId();
		}
		topicDTO = topicService.findById(topicId);
		itemDTOList = itemService.finds(null);
		return this.SUCCESS;
	}
	
	public String getTopicById() throws Exception {
		topicDTO = topicService.findById(topicId);
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

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public List<TopicDTO> getTopicDTOList() {
		return topicDTOList;
	}

	public void setTopicDTOList(List<TopicDTO> topicDTOList) {
		this.topicDTOList = topicDTOList;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public List<ItemDTO> getItemDTOList() {
		return itemDTOList;
	}

	public void setItemDTOList(List<ItemDTO> itemDTOList) {
		this.itemDTOList = itemDTOList;
	}

}
