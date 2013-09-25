package com.cobble.huasheng.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.dto.CategoryDTO;
import com.cobble.huasheng.dto.CategoryDTOSearch;
import com.cobble.huasheng.service.CategoryService;


public class CategoryAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(CategoryAction.class);
	private CategoryService categoryService;
	private CategoryDTOSearch categoryDTOSearch = new CategoryDTOSearch();
	private CategoryDTO categoryDTO = new CategoryDTO();
	private List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>(0);
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		categoryDTOList = categoryService.finds(categoryDTOSearch);
		return this.SUCCESS;
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

}
