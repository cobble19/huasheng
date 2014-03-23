package com.cobble.huasheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

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
	private static final Logger logger = Logger.getLogger(VideoSrcServiceImpl.class);
	private VideoSrcDAO videoSrcDAO;

	public void create(VideoSrcDTO tDTO) throws Exception {
		VideoSrcEntity videoSrcEntity = new VideoSrcEntity();
		try {
			videoSrcEntity = ConvertFactory.getVideoSrcConvert().toEntity(tDTO);
			videoSrcDAO.create(videoSrcEntity);
			BeanUtil.copyProperties(tDTO, videoSrcEntity);
			/*tDTO = ConvertFactory.getVideoSrcConvert().toDTO(videoSrcEntity);*/
		} catch (Exception e) {
			logger.fatal("Create exception.", e);
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
			logger.fatal("Update exception.", e);
			throw e;
		}
	}


	@Override
	public List<VideoSrcDTO> finds(VideoSrcDTOSearch stDTO)
			throws Exception {
		return this.finds(stDTO, true, -1, -1);
	}

	public List<VideoSrcDTO> finds(VideoSrcDTOSearch stDTO, int start, int limit)
			throws Exception {
		return this.finds(stDTO, false, start, limit);
	}
	public List<VideoSrcDTO> finds(VideoSrcDTOSearch stDTO, Boolean all, int start, int limit) throws Exception {
		List<VideoSrcDTO> ret = new ArrayList<VideoSrcDTO>(0);
		try {
			VideoSrcEntitySearch videoSrcEntitySearch = new VideoSrcEntitySearch();
			videoSrcEntitySearch = ConvertFactory.getVideoSrcConvert().toEntitySearch(stDTO);
			List<VideoSrcEntity> videoSrcEntities = videoSrcDAO.finds(videoSrcEntitySearch, all, start, limit);
			if (ListUtil.isNotEmpty(videoSrcEntities)) {
				for (VideoSrcEntity videoSrcEntity : videoSrcEntities) {
					VideoSrcDTO videoSrcDTO = ConvertFactory.getVideoSrcConvert().toDTO(videoSrcEntity);
					ret.add(videoSrcDTO);
				}
			}
		} catch (Exception e) {
			logger.fatal("Find exception.", e);
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
			logger.fatal("Find by id exception.", e);
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
			logger.fatal("Get count exception.", e);
			throw e;
		}
		return ret;
	}

	public void setVideoSrcDAO(VideoSrcDAO videoSrcDAO) {
		this.videoSrcDAO = videoSrcDAO;
	}

	public void delete(VideoSrcDTO tDTO) throws Exception {
		try {
			VideoSrcEntity videoSrcEntity = videoSrcDAO.findById(tDTO.getVideoSrcId());
			videoSrcDAO.delete(videoSrcEntity);
		} catch (Exception e) {
			logger.fatal("Delete exception.", e);
			throw e;
		}
	}

}
