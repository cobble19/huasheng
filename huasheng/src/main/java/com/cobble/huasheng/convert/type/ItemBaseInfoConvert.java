package com.cobble.huasheng.convert.type;

import com.cobble.huasheng.dto.ItemBaseInfoDTO;
import com.cobble.huasheng.dto.ItemBaseInfoDTOSearch;
import com.cobble.huasheng.entity.ItemBaseInfoEntity;
import com.cobble.huasheng.entity.ItemBaseInfoEntitySearch;

public class ItemBaseInfoConvert extends CommonConvert<ItemBaseInfoDTO, ItemBaseInfoEntity,
									ItemBaseInfoDTOSearch, ItemBaseInfoEntitySearch> {

	public ItemBaseInfoConvert(Class<ItemBaseInfoDTO> dtoClass,
			Class<ItemBaseInfoEntity> entityClass,
			Class<ItemBaseInfoDTOSearch> dtoSearchClass,
			Class<ItemBaseInfoEntitySearch> entitySearchClass) {
		super(dtoClass, entityClass, dtoSearchClass, entitySearchClass);
	}


}
