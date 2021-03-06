package com.cobble.huasheng.service;

import java.util.List;

import com.cobble.huasheng.dto.FragmentDTO;
import com.cobble.huasheng.dto.FragmentDTOSearch;
import com.cobble.huasheng.dto.VideoDTO;


public interface HandleUrlService {
	List<VideoDTO> getVideoByUrl(String url);
	List<FragmentDTO> getFragmentByUrl(String url);
	void addVideo(FragmentDTOSearch fragmentDTOSearch);
	List<VideoDTO> findVideos(FragmentDTOSearch fragmentDTOSearch);
}
