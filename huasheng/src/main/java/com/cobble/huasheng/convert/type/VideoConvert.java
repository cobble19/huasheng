package com.cobble.huasheng.convert.type;

import com.cobble.huasheng.dto.VideoDTO;
import com.cobble.huasheng.dto.VideoDTOSearch;
import com.cobble.huasheng.entity.VideoEntity;
import com.cobble.huasheng.entity.VideoEntitySearch;

public class VideoConvert extends CommonConvert<VideoDTO, VideoEntity,
							VideoDTOSearch, VideoEntitySearch> {

	public VideoConvert(Class<VideoDTO> dtoClass,
			Class<VideoEntity> entityClass,
			Class<VideoDTOSearch> dtoSearchClass,
			Class<VideoEntitySearch> entitySearchClass) {
		super(dtoClass, entityClass, dtoSearchClass, entitySearchClass);
	}


}
