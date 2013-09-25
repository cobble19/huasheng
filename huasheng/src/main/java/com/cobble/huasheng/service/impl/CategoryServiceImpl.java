package com.cobble.huasheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cobble.huasheng.dao.CategoryDAO;
import com.cobble.huasheng.dto.CategoryDTO;
import com.cobble.huasheng.dto.CategoryDTOSearch;
import com.cobble.huasheng.entity.CategoryEntity;
import com.cobble.huasheng.entity.CategoryEntitySearch;
import com.cobble.huasheng.factory.ConvertFactory;
import com.cobble.huasheng.service.CategoryService;
import com.cobble.huasheng.util.BeanUtil;
import com.cobble.huasheng.util.ListUtil;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDAO categoryDAO;

	public void create(CategoryDTO tDTO) throws Exception {
		CategoryEntity categoryEntity = new CategoryEntity();
		try {
			categoryEntity = ConvertFactory.getCategoryConvert().toEntity(tDTO);
			categoryDAO.create(categoryEntity);
			tDTO = ConvertFactory.getCategoryConvert().toDTO(categoryEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public void update(CategoryDTO tDTO) throws Exception {
		try {
			CategoryEntity categoryEntity = categoryDAO.findById(tDTO.getCategoryId());
			categoryEntity = ConvertFactory.getCategoryConvert().toEntity(tDTO);
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

}