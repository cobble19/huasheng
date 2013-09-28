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


public class ItemAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(ItemAction.class);
	private ItemService itemService;
	private ItemDTOSearch itemDTOSearch = new ItemDTOSearch();
	private ItemDTO itemDTO = new ItemDTO();
	private List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>(0);
	// 
	private Long topicId;
	private Long itemId;
	private TopicService topicService;
	private TopicDTO topicDTO;

	/*private Long topicId;
	private TopicService topicService;*/
	private TopicDTOSearch topicDTOSearch = new TopicDTOSearch();
	/*private TopicDTO topicDTO = new TopicDTO();*/
	private List<TopicDTO> topicDTOList = new ArrayList<TopicDTO>(0);
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		itemDTOList = itemService.finds(itemDTOSearch);
		return this.SUCCESS;
	}
	
	public String getItemById() throws Exception {
		// get Topic
		topicDTOList = topicService.finds(topicDTOSearch);
		if (topicId == null && ListUtil.isNotEmpty(topicDTOList)) {
			topicId = topicDTOList.get(0).getTopicId();
		}
		topicDTO = topicService.findById(topicId);
		// get Item
		itemDTO = itemService.findById(itemId);
		return this.SUCCESS;
	}

	public ItemDTOSearch getItemDTOSearch() {
		return itemDTOSearch;
	}

	public void setItemDTOSearch(ItemDTOSearch itemDTOSearch) {
		this.itemDTOSearch = itemDTOSearch;
	}

	public ItemDTO getItemDTO() {
		return itemDTO;
	}

	public void setItemDTO(ItemDTO itemDTO) {
		this.itemDTO = itemDTO;
	}

	public List<ItemDTO> getItemDTOList() {
		return itemDTOList;
	}

	public void setItemDTOList(List<ItemDTO> itemDTOList) {
		this.itemDTOList = itemDTOList;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public TopicDTO getTopicDTO() {
		return topicDTO;
	}

	public void setTopicDTO(TopicDTO topicDTO) {
		this.topicDTO = topicDTO;
	}

	public TopicDTOSearch getTopicDTOSearch() {
		return topicDTOSearch;
	}

	public void setTopicDTOSearch(TopicDTOSearch topicDTOSearch) {
		this.topicDTOSearch = topicDTOSearch;
	}

	public List<TopicDTO> getTopicDTOList() {
		return topicDTOList;
	}

	public void setTopicDTOList(List<TopicDTO> topicDTOList) {
		this.topicDTOList = topicDTOList;
	}

}
