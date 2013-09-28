package com.cobble.huasheng.convert.type;

import com.cobble.huasheng.dto.ActorDTO;
import com.cobble.huasheng.dto.ActorDTOSearch;
import com.cobble.huasheng.entity.ActorEntity;
import com.cobble.huasheng.entity.ActorEntitySearch;

public class ActorConvert extends CommonConvert<ActorDTO, ActorEntity,
						ActorDTOSearch, ActorEntitySearch> {

	public ActorConvert(Class<ActorDTO> dtoClass,
			Class<ActorEntity> entityClass,
			Class<ActorDTOSearch> dtoSearchClass,
			Class<ActorEntitySearch> entitySearchClass) {
		super(dtoClass, entityClass, dtoSearchClass, entitySearchClass);
	}


}
