package com.cobble.huasheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cobble.huasheng.dao.TopicDAO;
import com.cobble.huasheng.dto.CategoryDTO;
import com.cobble.huasheng.dto.ItemDTO;
import com.cobble.huasheng.dto.TopicDTO;
import com.cobble.huasheng.dto.TopicDTOSearch;
import com.cobble.huasheng.entity.CategoryEntity;
import com.cobble.huasheng.entity.ItemEntity;
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
			BeanUtil.copyProperties(tDTO, topicEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public void update(TopicDTO tDTO) throws Exception {
		try {
			TopicEntity topicEntity = topicDAO.findById(tDTO.getTopicId());
			//topicEntity = ConvertFactory.getTopicConvert().toEntity(tDTO);
			if (topicEntity != null) {
				BeanUtil.copyProperties(topicEntity, tDTO);
				topicDAO.update(topicEntity);
			}
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
					if (topicEntity == null) {
						continue;
					}
					TopicDTO topicDTO = ConvertFactory.getTopicConvert().toDTO(topicEntity);
					// get all category->item
					List<CategoryEntity> categoryEntities = topicEntity.getCategoryEntities();
					if (topicEntity != null && ListUtil.isNotEmpty(categoryEntities)) {
						List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
						for (CategoryEntity categoryEntity : categoryEntities) {
							if (categoryEntity == null) {
								continue;
							}
							CategoryDTO categoryDTO = ConvertFactory.getCategoryConvert().toDTO(categoryEntity);
							categoryDTOs.add(categoryDTO);
							List<ItemEntity> itemEntities = categoryEntity.getItemEntities();
							if (ListUtil.isNotEmpty(itemEntities)) {
								List<ItemDTO> itemDTOs = new ArrayList<ItemDTO>();
								for (ItemEntity itemEntity : itemEntities) {
									if (itemEntity == null) {
										continue;
									}
									ItemDTO itemDTO = ConvertFactory.getItemConvert().toDTO(itemEntity);
									itemDTOs.add(itemDTO);
									/*ItemBaseInfoEntity itemBaseInfoEntity = itemEntity.getItemBaseInfoEntity();
									if (itemBaseInfoEntity != null) {
										ItemBaseInfoDTO itemBaseInfoDTO = ConvertFactory.getItemBaseInfoConvert().toDTO(itemBaseInfoEntity);
										itemDTO.setItemBaseInfoDTO(itemBaseInfoDTO);
									}*/
								}
								categoryDTO.setItemDTOs(itemDTOs);
							}
						}
						topicDTO.setCategoryDTOs(categoryDTOs);
					}
					
					ret.add(topicDTO);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public TopicDTO findById(Long id) throws Exception {
		if (id == null) {
			return null;
		}
		TopicDTO ret = new TopicDTO();
		try {
			TopicEntity topicEntity = topicDAO.findById(id);
			ret = ConvertFactory.getTopicConvert().toDTO(topicEntity);
			if (topicEntity == null) {
				return ret;
			}
			List<CategoryEntity> categoryEntities = topicEntity.getCategoryEntities();
			if (topicEntity != null && ListUtil.isNotEmpty(categoryEntities)) {
				List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
				for (CategoryEntity categoryEntity : categoryEntities) {
					if (categoryEntity == null) {
						continue;
					}
					CategoryDTO categoryDTO = ConvertFactory.getCategoryConvert().toDTO(categoryEntity);
					categoryDTOs.add(categoryDTO);
					List<ItemEntity> itemEntities = categoryEntity.getItemEntities();
					if (ListUtil.isNotEmpty(itemEntities)) {
						List<ItemDTO> itemDTOs = new ArrayList<ItemDTO>();
						for (ItemEntity itemEntity : itemEntities) {
							if (itemEntity == null) {
								continue;
							}
							ItemDTO itemDTO = ConvertFactory.getItemConvert().toDTO(itemEntity);
							itemDTOs.add(itemDTO);
							/*ItemBaseInfoEntity itemBaseInfoEntity = itemEntity.getItemBaseInfoEntity();
							if (itemBaseInfoEntity != null) {
								ItemBaseInfoDTO itemBaseInfoDTO = ConvertFactory.getItemBaseInfoConvert().toDTO(itemBaseInfoEntity);
								itemDTO.setItemBaseInfoDTO(itemBaseInfoDTO);
							}*/
						}
						categoryDTO.setItemDTOs(itemDTOs);
					}
				}
				ret.setCategoryDTOs(categoryDTOs);
			}
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

	public void delete(TopicDTO tDTO) throws Exception {
		if (tDTO == null || tDTO.getTopicId() == null) {
			return;
		}
		TopicEntity topicEntity = topicDAO.findById(tDTO.getTopicId());
		topicDAO.delete(topicEntity);
	}

}
