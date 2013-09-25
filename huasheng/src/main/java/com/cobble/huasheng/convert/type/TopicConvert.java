package com.cobble.huasheng.convert.type;

import com.cobble.huasheng.dto.TopicDTO;
import com.cobble.huasheng.dto.TopicDTOSearch;
import com.cobble.huasheng.entity.TopicEntity;
import com.cobble.huasheng.entity.TopicEntitySearch;

public class TopicConvert extends CommonConvert<TopicDTO, TopicEntity,
						TopicDTOSearch, TopicEntitySearch> {

	public TopicConvert(Class<TopicDTO> dtoClass,
			Class<TopicEntity> entityClass,
			Class<TopicDTOSearch> dtoSearchClass,
			Class<TopicEntitySearch> entitySearchClass) {
		super(dtoClass, entityClass, dtoSearchClass, entitySearchClass);
	}


}
