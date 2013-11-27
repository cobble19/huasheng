package com.cobble.huasheng.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.cobble.huasheng.dto.CategoryDTO;
import com.cobble.huasheng.dto.ItemDTO;
import com.cobble.huasheng.dto.ItemDTOSearch;
import com.cobble.huasheng.dto.TopicDTO;
import com.cobble.huasheng.dto.TopicDTOSearch;
import com.cobble.huasheng.service.ItemService;
import com.cobble.huasheng.service.TopicService;
import com.cobble.huasheng.util.ListUtil;

import freemarker.template.utility.StringUtil;


public class ItemAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(ItemAction.class);
	private ItemService itemService;
	private ItemDTOSearch itemDTOSearch = new ItemDTOSearch();
	private ItemDTO itemDTO = new ItemDTO();
	private List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>(0);
	// 
	private Long topicId;
	private Long itemId;
	private String name;
	private Long hits;
	
	// 区域名称
	private String areaName;
	// 上映日期
	private Date showDate;
	// 总评分
	private Double score;
	// 描述
	private String description;
	// 参与的演员，[,]分割
	private String actorName;
	// 个体种类, 如剧情，动作，[,]分割
	private String itemType;
	
	private Set<CategoryDTO> categoryDTOs = new HashSet<CategoryDTO>(); 
	private CategoryDTO categoryDTO = new CategoryDTO();
	
	private TopicService topicService;
	private TopicDTO topicDTO;

	/*private Long topicId;
	private TopicService topicService;*/
	private TopicDTOSearch topicDTOSearch = new TopicDTOSearch();
	/*private TopicDTO topicDTO = new TopicDTO();*/
	private List<TopicDTO> topicDTOList = new ArrayList<TopicDTO>(0);
	
	// for delete, id1,id2,id3. [,]分割
	private String ids;

	
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
	
	public String add() throws Exception {
		itemDTO = new ItemDTO();
		itemDTO.setName(name);
		itemDTO.setHits(hits);
		itemDTO.setAreaName(areaName);
		itemDTO.setActorName(actorName);
		itemDTO.setScore(score);
		itemDTO.setShowDate(showDate);
		itemDTO.setDescription(description);
		itemDTO.setItemType(itemType);
		itemDTO.setCategoryDTO(categoryDTO);
		itemService.create(itemDTO);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		itemDTO = new ItemDTO();
		itemDTO.setItemId(itemId);
		itemDTO.setName(name);
		itemDTO.setHits(hits);
		itemDTO.setAreaName(areaName);
		itemDTO.setActorName(actorName);
		itemDTO.setScore(score);
		itemDTO.setShowDate(showDate);
		itemDTO.setDescription(description);
		itemDTO.setItemType(itemType);
		itemDTO.setCategoryDTO(categoryDTO);
		itemService.update(itemDTO);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if (StringUtils.isNotBlank(ids)) {
			String[] idsSplit = StringUtil.split(ids, ',');
			for (String id : idsSplit) {
				itemDTO = new ItemDTO();
				itemDTO.setItemId(Long.parseLong(id));
				itemService.delete(itemDTO);
			}
		}
		this.setSuccess(true);
		return SUCCESS;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getHits() {
		return hits;
	}

	public void setHits(Long hits) {
		this.hits = hits;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Set<CategoryDTO> getCategoryDTOs() {
		return categoryDTOs;
	}

	public void setCategoryDTOs(Set<CategoryDTO> categoryDTOs) {
		this.categoryDTOs = categoryDTOs;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

}
