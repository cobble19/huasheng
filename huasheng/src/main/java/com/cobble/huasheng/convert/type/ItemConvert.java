package com.cobble.huasheng.convert.type;

import com.cobble.huasheng.dto.ItemDTO;
import com.cobble.huasheng.dto.ItemDTOSearch;
import com.cobble.huasheng.entity.ItemEntity;
import com.cobble.huasheng.entity.ItemEntitySearch;

public class ItemConvert extends CommonConvert<ItemDTO, ItemEntity,
								ItemDTOSearch, ItemEntitySearch> {

	public ItemConvert(Class<ItemDTO> dtoClass, Class<ItemEntity> entityClass,
			Class<ItemDTOSearch> dtoSearchClass,
			Class<ItemEntitySearch> entitySearchClass) {
		super(dtoClass, entityClass, dtoSearchClass, entitySearchClass);
	}


}
