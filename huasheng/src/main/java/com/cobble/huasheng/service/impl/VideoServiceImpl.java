package com.cobble.huasheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cobble.huasheng.dao.VideoDAO;
import com.cobble.huasheng.dto.VideoDTO;
import com.cobble.huasheng.dto.VideoDTOSearch;
import com.cobble.huasheng.entity.VideoEntity;
import com.cobble.huasheng.entity.VideoEntitySearch;
import com.cobble.huasheng.factory.ConvertFactory;
import com.cobble.huasheng.service.VideoService;
import com.cobble.huasheng.util.BeanUtil;
import com.cobble.huasheng.util.ListUtil;

public class VideoServiceImpl implements VideoService {
	private VideoDAO videoDAO;

	public void create(VideoDTO tDTO) throws Exception {
		VideoEntity videoEntity = new VideoEntity();
		try {
			videoEntity = ConvertFactory.getVideoConvert().toEntity(tDTO);
			videoDAO.create(videoEntity);
			tDTO = ConvertFactory.getVideoConvert().toDTO(videoEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public void update(VideoDTO tDTO) throws Exception {
		try {
			VideoEntity videoEntity = videoDAO.findById(tDTO.getVideoId());
			videoEntity = ConvertFactory.getVideoConvert().toEntity(tDTO);
			videoDAO.update(videoEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<VideoDTO> finds(VideoDTOSearch stDTO) throws Exception {
		List<VideoDTO> ret = new ArrayList<VideoDTO>(0);
		try {
			VideoEntitySearch videoEntitySearch = new VideoEntitySearch();
			videoEntitySearch = ConvertFactory.getVideoConvert().toEntitySearch(stDTO);
			List<VideoEntity> videoEntities = videoDAO.finds(videoEntitySearch);
			if (ListUtil.isNotEmpty(videoEntities)) {
				for (VideoEntity videoEntity : videoEntities) {
					VideoDTO videoDTO = ConvertFactory.getVideoConvert().toDTO(videoEntity);
					ret.add(videoDTO);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public VideoDTO findById(Long id) throws Exception {
		VideoDTO ret = new VideoDTO();
		try {
			VideoEntity videoEntity = videoDAO.findById(id);
			ret = ConvertFactory.getVideoConvert().toDTO(videoEntity);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public long getCount(VideoDTOSearch stDTO) throws Exception {
		long ret = 0;
		try {
			VideoEntitySearch videoEntitySearch = new VideoEntitySearch();
			BeanUtil.copyProperties(videoEntitySearch, stDTO);
			ret = videoDAO.getCount(videoEntitySearch);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public void setVideoDAO(VideoDAO videoDAO) {
		this.videoDAO = videoDAO;
	}

}
