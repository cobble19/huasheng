package com.cobble.huasheng.convert.type;

import com.cobble.huasheng.dto.ItemTypeDTO;
import com.cobble.huasheng.dto.ItemTypeDTOSearch;
import com.cobble.huasheng.entity.ItemTypeEntity;
import com.cobble.huasheng.entity.ItemTypeEntitySearch;

public class ItemTypeConvert extends CommonConvert<ItemTypeDTO, ItemTypeEntity, 
							ItemTypeDTOSearch, ItemTypeEntitySearch> {

	public ItemTypeConvert(Class<ItemTypeDTO> dtoClass,
			Class<ItemTypeEntity> entityClass,
			Class<ItemTypeDTOSearch> dtoSearchClass,
			Class<ItemTypeEntitySearch> entitySearchClass) {
		super(dtoClass, entityClass, dtoSearchClass, entitySearchClass);
	}


}
