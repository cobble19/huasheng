package com.cobble.huasheng.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.cobble.huasheng.dto.CategoryDTO;
import com.cobble.huasheng.dto.CategoryDTOSearch;
import com.cobble.huasheng.dto.TopicDTO;
import com.cobble.huasheng.dto.TopicDTOSearch;
import com.cobble.huasheng.service.CategoryService;
import com.cobble.huasheng.service.TopicService;
import com.cobble.huasheng.util.ListUtil;

import freemarker.template.utility.StringUtil;


public class CategoryAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(CategoryAction.class);
	private CategoryService categoryService;
	private CategoryDTOSearch categoryDTOSearch = new CategoryDTOSearch();
	private CategoryDTO categoryDTO = new CategoryDTO();
	private List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>(0);
	// 
	private Long categoryId;
	private String name;
	// 
	private Long topicId;
	private TopicService topicService;
	private TopicDTOSearch topicDTOSearch = new TopicDTOSearch();
	private TopicDTO topicDTO = new TopicDTO();
	private List<TopicDTO> topicDTOList = new ArrayList<TopicDTO>(0);
	// for delete, id1,id2,id3. [,]分割
	private String ids;
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		categoryDTOList = categoryService.finds(categoryDTOSearch);
		this.setSuccess(true);
		return this.SUCCESS;
	}

	public String getCategoryById() throws Exception {
		topicDTOList = topicService.finds(topicDTOSearch);
		if (topicId == null && ListUtil.isNotEmpty(topicDTOList)) {
			topicId = topicDTOList.get(0).getTopicId();
		}
		topicDTO = topicService.findById(topicId);
		// 
		categoryDTO = categoryService.findById(categoryId);
		return this.SUCCESS;
	}
	
	public String add() throws Exception {
		categoryDTO = new CategoryDTO();
		categoryDTO.setName(name);
		topicDTO = new TopicDTO();
		topicDTO.setTopicId(topicId);
		categoryDTO.setTopicDTO(topicDTO);
		categoryService.create(categoryDTO);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryId(categoryId);
		categoryDTO.setName(name);
		topicDTO = new TopicDTO();
		topicDTO.setTopicId(topicId);
		categoryDTO.setTopicDTO(topicDTO);
		categoryService.update(categoryDTO);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if (StringUtils.isNotBlank(ids)) {
			String[] idsSplit = StringUtil.split(ids, ',');
			for (String id : idsSplit) {
				categoryDTO = new CategoryDTO();
				categoryDTO.setCategoryId(Long.parseLong(id));
				categoryService.delete(categoryDTO);
			}
		}
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public CategoryDTOSearch getCategoryDTOSearch() {
		return categoryDTOSearch;
	}

	public void setCategoryDTOSearch(CategoryDTOSearch categoryDTOSearch) {
		this.categoryDTOSearch = categoryDTOSearch;
	}

	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

	public List<CategoryDTO> getCategoryDTOList() {
		return categoryDTOList;
	}

	public void setCategoryDTOList(List<CategoryDTO> categoryDTOList) {
		this.categoryDTOList = categoryDTOList;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
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
