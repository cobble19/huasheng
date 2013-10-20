package com.cobble.huasheng.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.cobble.huasheng.dto.TopicDTO;
import com.cobble.huasheng.dto.TopicDTOSearch;
import com.cobble.huasheng.service.TopicService;
import com.cobble.huasheng.util.ListUtil;

import freemarker.template.utility.StringUtil;


@SuppressWarnings("serial")
public class TopicAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(TopicAction.class);
	private TopicService topicService;
	private TopicDTOSearch topicDTOSearch = new TopicDTOSearch();
	private TopicDTO topicDTO = new TopicDTO();
	private List<TopicDTO> topicDTOList = new ArrayList<TopicDTO>(0);
	// topicId
	private Long topicId = -10000L;
	// name
	private String name;
	// 更新数据的时候，用JSON
	private String updatedStr;
	// for delete
	private String ids;
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		topicDTOList = topicService.finds(topicDTOSearch);
		topicId = ListUtil.isNotEmpty(topicDTOList) ? topicDTOList.get(0).getTopicId() : (-10000L);
		topicDTO = topicService.findById(topicId);
		this.setSuccess(true);
		return this.SUCCESS;
	}
	
	public String add() throws Exception {
		/*ObjectMapper objectMapper = new ObjectMapper();
		TopicDTO topicDTO = objectMapper.readValue(updatedStr, TopicDTO.class);
		topicService.update(topicDTO);
		topicDTOList = new ArrayList<TopicDTO>(0);
		topicDTOList.add(topicDTO);*/
		TopicDTO topicDTO = new TopicDTO();
		topicDTO.setTopicId(topicId);
		topicDTO.setName(name);
		topicService.create(topicDTO);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		/*ObjectMapper objectMapper = new ObjectMapper();
		TopicDTO topicDTO = objectMapper.readValue(updatedStr, TopicDTO.class);*/
		TopicDTO topicDTO = new TopicDTO();
		topicDTO.setTopicId(topicId);
		topicDTO.setName(name);
		topicService.update(topicDTO);
		topicDTOList = new ArrayList<TopicDTO>(0);
		topicDTOList.add(topicDTO);
		this.setSuccess(true);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		/*ObjectMapper objectMapper = new ObjectMapper();
		TopicDTO topicDTO = objectMapper.readValue(updatedStr, TopicDTO.class);*/
		if (StringUtils.isNotBlank(ids)) {
			String[] idsSplit = StringUtil.split(ids, ',');
			for (String id : idsSplit) {
				TopicDTO topicDTO = new TopicDTO();
				topicDTO.setTopicId(Long.parseLong(id));
				topicService.delete(topicDTO);
			}
		}
		/*topicDTOList = new ArrayList<TopicDTO>(0);
		topicDTOList.add(topicDTO);*/
		this.setSuccess(true);
		return SUCCESS;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getUpdatedStr() {
		return updatedStr;
	}

	public void setUpdatedStr(String updatedStr) {
		this.updatedStr = updatedStr;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

}
