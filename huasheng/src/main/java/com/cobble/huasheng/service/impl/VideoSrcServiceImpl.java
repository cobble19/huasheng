package com.cobble.huasheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cobble.huasheng.dao.VideoSrcDAO;
import com.cobble.huasheng.dto.VideoSrcDTO;
import com.cobble.huasheng.dto.VideoSrcDTOSearch;
import com.cobble.huasheng.entity.VideoSrcEntity;
import com.cobble.huasheng.entity.VideoSrcEntitySearch;
import com.cobble.huasheng.factory.ConvertFactory;
import com.cobble.huasheng.service.VideoSrcService;
import com.cobble.huasheng.util.BeanUtil;
import com.cobble.huasheng.util.ListUtil;

public class VideoSrcServiceImpl implements VideoSrcService {
	private VideoSrcDAO videoSrcDAO;

	public void create(VideoSrcDTO tDTO) throws Exception {
		VideoSrcEntity videoSrcEntity = new VideoSrcEntity();
		try {
			videoSrcEntity = ConvertFactory.getVideoSrcConvert().toEntity(tDTO);
			videoSrcDAO.create(videoSrcEntity);
			BeanUtil.copyProperties(tDTO, videoSrcEntity);
			/*tDTO = ConvertFactory.getVideoSrcConvert().toDTO(videoSrcEntity);*/
		} catch (Exception e) {
			throw e;
		}
	}

	public void update(VideoSrcDTO tDTO) throws Exception {
		try {
			VideoSrcEntity videoSrcEntity = videoSrcDAO.findById(tDTO.getVideoSrcId());
			/*videoSrcEntity = ConvertFactory.getVideoSrcConvert().toEntity(tDTO);*/
			BeanUtil.copyProperties(videoSrcEntity, tDTO);
			videoSrcDAO.update(videoSrcEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<VideoSrcDTO> finds(VideoSrcDTOSearch stDTO) throws Exception {
		List<VideoSrcDTO> ret = new ArrayList<VideoSrcDTO>(0);
		try {
			VideoSrcEntitySearch videoSrcEntitySearch = new VideoSrcEntitySearch();
			videoSrcEntitySearch = ConvertFactory.getVideoSrcConvert().toEntitySearch(stDTO);
			List<VideoSrcEntity> videoSrcEntities = videoSrcDAO.finds(videoSrcEntitySearch);
			if (ListUtil.isNotEmpty(videoSrcEntities)) {
				for (VideoSrcEntity videoSrcEntity : videoSrcEntities) {
					VideoSrcDTO videoSrcDTO = ConvertFactory.getVideoSrcConvert().toDTO(videoSrcEntity);
					ret.add(videoSrcDTO);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public VideoSrcDTO findById(Long id) throws Exception {
		VideoSrcDTO ret = new VideoSrcDTO();
		try {
			VideoSrcEntity videoSrcEntity = videoSrcDAO.findById(id);
			ret = ConvertFactory.getVideoSrcConvert().toDTO(videoSrcEntity);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public long getCount(VideoSrcDTOSearch stDTO) throws Exception {
		long ret = 0;
		try {
			VideoSrcEntitySearch videoSrcEntitySearch = new VideoSrcEntitySearch();
			BeanUtil.copyProperties(videoSrcEntitySearch, stDTO);
			ret = videoSrcDAO.getCount(videoSrcEntitySearch);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public void setVideoSrcDAO(VideoSrcDAO videoSrcDAO) {
		this.videoSrcDAO = videoSrcDAO;
	}

	public void delete(VideoSrcDTO tDTO) throws Exception {
		VideoSrcEntity videoSrcEntity = videoSrcDAO.findById(tDTO.getVideoSrcId());
		videoSrcDAO.delete(videoSrcEntity);
	}

	@Override
	public List<VideoSrcDTO> finds(VideoSrcDTOSearch stDTO, int start, int limit)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
