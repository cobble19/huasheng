package com.cobble.huasheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cobble.huasheng.dao.TopicDAO;
import com.cobble.huasheng.dto.TopicDTO;
import com.cobble.huasheng.dto.TopicDTOSearch;
import com.cobble.huasheng.entity.TopicEntity;
import com.cobble.huasheng.entity.TopicEntitySearch;
import com.cobble.huasheng.service.TopicService;
import com.cobble.huasheng.util.BeanUtil;
import com.cobble.huasheng.util.ListUtil;

public class TopicServiceImpl implements TopicService {
	private TopicDAO topicDAO;

	public void create(TopicDTO tDTO) throws Exception {
		TopicEntity topicEntity = new TopicEntity();
		try {
			BeanUtil.copyProperties(topicEntity, tDTO);
			topicDAO.create(topicEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public void update(TopicDTO tDTO) throws Exception {
		try {
			TopicEntity topicEntity = topicDAO.findById(tDTO.getTopicId());
			BeanUtil.copyProperties(topicEntity, topicDAO);
			topicDAO.update(topicEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<TopicDTO> finds(TopicDTOSearch stDTO) throws Exception {
		List<TopicDTO> ret = new ArrayList<TopicDTO>(0);
		try {
			TopicEntitySearch topicEntitySearch = new TopicEntitySearch();
			if (stDTO != null) {
				BeanUtil.copyProperties(topicEntitySearch, stDTO);
			}
			List<TopicEntity> topicEntities = topicDAO.finds(topicEntitySearch);
			if (ListUtil.isNotEmpty(topicEntities)) {
				for (TopicEntity topicEntity : topicEntities) {
					TopicDTO topicDTO = new TopicDTO();
					BeanUtil.copyProperties(topicDTO, topicEntity);
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
			BeanUtil.copyProperties(ret, topicEntity);
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
