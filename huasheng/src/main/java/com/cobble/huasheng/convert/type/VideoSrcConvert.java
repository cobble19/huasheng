package com.cobble.huasheng.convert.type;

import com.cobble.huasheng.dto.VideoSrcDTO;
import com.cobble.huasheng.dto.VideoSrcDTOSearch;
import com.cobble.huasheng.entity.VideoSrcEntity;
import com.cobble.huasheng.entity.VideoSrcEntitySearch;

public class VideoSrcConvert extends CommonConvert<VideoSrcDTO, VideoSrcEntity,
								VideoSrcDTOSearch, VideoSrcEntitySearch> {

	public VideoSrcConvert(Class<VideoSrcDTO> dtoClass,
			Class<VideoSrcEntity> entityClass,
			Class<VideoSrcDTOSearch> dtoSearchClass,
			Class<VideoSrcEntitySearch> entitySearchClass) {
		super(dtoClass, entityClass, dtoSearchClass, entitySearchClass);
	}


}
