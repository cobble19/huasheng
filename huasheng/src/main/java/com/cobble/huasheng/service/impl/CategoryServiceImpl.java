package com.cobble.huasheng.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cobble.huasheng.dao.CategoryDAO;
import com.cobble.huasheng.dao.TopicDAO;
import com.cobble.huasheng.dto.CategoryDTO;
import com.cobble.huasheng.dto.CategoryDTOSearch;
import com.cobble.huasheng.dto.ItemDTO;
import com.cobble.huasheng.dto.TopicDTO;
import com.cobble.huasheng.entity.CategoryEntity;
import com.cobble.huasheng.entity.CategoryEntitySearch;
import com.cobble.huasheng.entity.ItemEntity;
import com.cobble.huasheng.entity.TopicEntity;
import com.cobble.huasheng.factory.ConvertFactory;
import com.cobble.huasheng.service.CategoryService;
import com.cobble.huasheng.util.BeanUtil;
import com.cobble.huasheng.util.ListUtil;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDAO categoryDAO;
	private TopicDAO topicDAO;

	public void create(CategoryDTO tDTO) throws Exception {
		CategoryEntity categoryEntity = new CategoryEntity();
		try {
			categoryEntity = ConvertFactory.getCategoryConvert().toEntity(tDTO);
			if (tDTO.getTopicDTO() != null && tDTO.getTopicDTO().getTopicId() != null) {
				TopicEntity topicEntity = topicDAO.findById(tDTO.getTopicDTO().getTopicId());
				if (topicEntity != null) {
					categoryEntity.setTopicEntity(topicEntity);
				}
			}
			categoryDAO.create(categoryEntity);
			BeanUtil.copyProperties(tDTO, categoryEntity);
			/*tDTO = ConvertFactory.getCategoryConvert().toDTO(categoryEntity);*/
		} catch (Exception e) {
			throw e;
		}
	}

	public void update(CategoryDTO tDTO) throws Exception {
		try {
			CategoryEntity categoryEntity = categoryDAO.findById(tDTO.getCategoryId());
			BeanUtil.copyProperties(categoryEntity, tDTO);
			if (tDTO.getTopicDTO() != null && tDTO.getTopicDTO().getTopicId() != null) {
				TopicEntity topicEntity = topicDAO.findById(tDTO.getTopicDTO().getTopicId());
				if (topicEntity != null) {
					categoryEntity.setTopicEntity(topicEntity);
				}
			}
			//categoryEntity = ConvertFactory.getCategoryConvert().toEntity(tDTO);
			
			categoryDAO.update(categoryEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<CategoryDTO> finds(CategoryDTOSearch stDTO) throws Exception {
		List<CategoryDTO> ret = new ArrayList<CategoryDTO>(0);
		try {
			CategoryEntitySearch categoryEntitySearch = new CategoryEntitySearch();
			categoryEntitySearch = ConvertFactory.getCategoryConvert().toEntitySearch(stDTO);
			List<CategoryEntity> categoryEntities = categoryDAO.finds(categoryEntitySearch);
			if (ListUtil.isNotEmpty(categoryEntities)) {
				for (CategoryEntity categoryEntity : categoryEntities) {
					CategoryDTO categoryDTO = ConvertFactory.getCategoryConvert().toDTO(categoryEntity);
					TopicEntity topicEntity = categoryEntity.getTopicEntity();
					TopicDTO topicDTO = ConvertFactory.getTopicConvert().toDTO(topicEntity);
					categoryDTO.setTopicDTO(topicDTO);
					ret.add(categoryDTO);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public CategoryDTO findById(Long id) throws Exception {
		CategoryDTO ret = new CategoryDTO();
		try {
			CategoryEntity categoryEntity = categoryDAO.findById(id);
			ret = ConvertFactory.getCategoryConvert().toDTO(categoryEntity);
			if (categoryEntity != null) {
				Set<ItemEntity> itemEntities = categoryEntity.getItemEntities();
				if (ListUtil.isNotEmpty(itemEntities)) {
					Set<ItemDTO> itemDTOs = new HashSet<ItemDTO>();
					for (ItemEntity itemEntity : itemEntities) {
						ItemDTO itemDTO = ConvertFactory.getItemConvert().toDTO(itemEntity);
						itemDTOs.add(itemDTO);
					}
					ret.setItemDTOs(itemDTOs);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public long getCount(CategoryDTOSearch stDTO) throws Exception {
		long ret = 0;
		try {
			CategoryEntitySearch categoryEntitySearch = new CategoryEntitySearch();
			BeanUtil.copyProperties(categoryEntitySearch, stDTO);
			ret = categoryDAO.getCount(categoryEntitySearch);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public void delete(CategoryDTO tDTO) throws Exception {
		CategoryEntity categoryEntity = categoryDAO.findById(tDTO.getCategoryId());
		categoryDAO.delete(categoryEntity);
	}

	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}

}
