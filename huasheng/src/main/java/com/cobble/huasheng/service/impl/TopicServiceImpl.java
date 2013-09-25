package com.cobble.huasheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cobble.huasheng.dao.TopicDAO;
import com.cobble.huasheng.dto.TopicDTO;
import com.cobble.huasheng.dto.TopicDTOSearch;
import com.cobble.huasheng.entity.TopicEntity;
import com.cobble.huasheng.entity.TopicEntitySearch;
import com.cobble.huasheng.factory.ConvertFactory;
import com.cobble.huasheng.service.TopicService;
import com.cobble.huasheng.util.BeanUtil;
import com.cobble.huasheng.util.ListUtil;

public class TopicServiceImpl implements TopicService {
	private TopicDAO topicDAO;

	public void create(TopicDTO tDTO) throws Exception {
		TopicEntity topicEntity = new TopicEntity();
		try {
			topicEntity = ConvertFactory.getTopicConvert().toEntity(tDTO);
			topicDAO.create(topicEntity);
			tDTO = ConvertFactory.getTopicConvert().toDTO(topicEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public void update(TopicDTO tDTO) throws Exception {
		try {
			TopicEntity topicEntity = topicDAO.findById(tDTO.getTopicId());
			topicEntity = ConvertFactory.getTopicConvert().toEntity(tDTO);
			topicDAO.update(topicEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<TopicDTO> finds(TopicDTOSearch stDTO) throws Exception {
		List<TopicDTO> ret = new ArrayList<TopicDTO>(0);
		try {
			TopicEntitySearch topicEntitySearch = new TopicEntitySearch();
			topicEntitySearch = ConvertFactory.getTopicConvert().toEntitySearch(stDTO);
			List<TopicEntity> topicEntities = topicDAO.finds(topicEntitySearch);
			if (ListUtil.isNotEmpty(topicEntities)) {
				for (TopicEntity topicEntity : topicEntities) {
					TopicDTO topicDTO = ConvertFactory.getTopicConvert().toDTO(topicEntity);
					ret.add(topicDTO);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public TopicDTO findById(Long id) throws Exception {
		TopicDTO ret = new TopicDTO();
		try {
			TopicEntity topicEntity = topicDAO.findById(id);
			ret = ConvertFactory.getTopicConvert().toDTO(topicEntity);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public long getCount(TopicDTOSearch stDTO) throws Exception {
		long ret = 0;
		try {
			TopicEntitySearch topicEntitySearch = new TopicEntitySearch();
			BeanUtil.copyProperties(topicEntitySearch, stDTO);
			ret = topicDAO.getCount(topicEntitySearch);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}

}
