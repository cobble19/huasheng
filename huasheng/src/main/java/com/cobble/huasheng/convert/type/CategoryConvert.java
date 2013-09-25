package com.cobble.huasheng.convert.type;

import com.cobble.huasheng.dto.CategoryDTO;
import com.cobble.huasheng.dto.CategoryDTOSearch;
import com.cobble.huasheng.entity.CategoryEntity;
import com.cobble.huasheng.entity.CategoryEntitySearch;

public class CategoryConvert extends CommonConvert<CategoryDTO, CategoryEntity,
									CategoryDTOSearch, CategoryEntitySearch> {

	public CategoryConvert(Class<CategoryDTO> dtoClass,
			Class<CategoryEntity> entityClass,
			Class<CategoryDTOSearch> dtoSearchClass,
			Class<CategoryEntitySearch> entitySearchClass) {
		super(dtoClass, entityClass, dtoSearchClass, entitySearchClass);
	}

}
