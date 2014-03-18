package com.cobble.huasheng.service;

import java.util.List;

import com.cobble.huasheng.dto.VideoDTO;


public interface HandleUrlService {
	List<VideoDTO> getVideoByUrl(String url);
}
