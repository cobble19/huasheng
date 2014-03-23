package com.cobble.huasheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.dao.ItemDAO;
import com.cobble.huasheng.dao.VideoDAO;
import com.cobble.huasheng.dao.VideoSrcDAO;
import com.cobble.huasheng.dto.ItemDTO;
import com.cobble.huasheng.dto.VideoDTO;
import com.cobble.huasheng.dto.VideoDTOSearch;
import com.cobble.huasheng.dto.VideoSrcDTO;
import com.cobble.huasheng.entity.ItemEntity;
import com.cobble.huasheng.entity.VideoEntity;
import com.cobble.huasheng.entity.VideoEntitySearch;
import com.cobble.huasheng.entity.VideoSrcEntity;
import com.cobble.huasheng.factory.ConvertFactory;
import com.cobble.huasheng.service.VideoService;
import com.cobble.huasheng.util.BeanUtil;
import com.cobble.huasheng.util.ListUtil;

public class VideoServiceImpl implements VideoService {
	private static final Logger logger = Logger.getLogger(VideoServiceImpl.class);
	private VideoDAO videoDAO;
	private ItemDAO itemDAO;
	private VideoSrcDAO videoSrcDAO;

	public void create(VideoDTO tDTO) throws Exception {
		VideoEntity videoEntity = new VideoEntity();
		try {
			videoEntity = ConvertFactory.getVideoConvert().toEntity(tDTO);
			if (tDTO.getItemDTO() != null && tDTO.getItemDTO().getItemId() != null) {
				ItemEntity itemEntity = itemDAO.findById(tDTO.getItemDTO().getItemId());
				videoEntity.setItemEntity(itemEntity);
			}
			if (tDTO.getVideoSrcDTO() != null && tDTO.getVideoSrcDTO().getVideoSrcId() != null) {
				VideoSrcEntity videoSrcEntity = videoSrcDAO.findById(tDTO.getVideoSrcDTO().getVideoSrcId());
				videoEntity.setVideoSrcEntity(videoSrcEntity);
			}
			videoDAO.create(videoEntity);
			/*tDTO = ConvertFactory.getVideoConvert().toDTO(videoEntity);*/
			BeanUtil.copyProperties(tDTO, videoEntity);
			if (videoEntity.getItemEntity() != null) {
				ItemDTO itemDTO = new ItemDTO();
				BeanUtil.copyProperties(itemDTO, videoEntity.getItemEntity());
				tDTO.setItemDTO(itemDTO);
			}
			if (videoEntity.getVideoSrcEntity() != null) {
				VideoSrcDTO videoSrcDTO = new VideoSrcDTO();
				BeanUtil.copyProperties(videoSrcDTO, videoEntity.getVideoSrcEntity());
				tDTO.setVideoSrcDTO(videoSrcDTO);
			}
		} catch (Exception e) {
			logger.fatal("Create exception.", e);
			throw e;
		}
	}

	public void update(VideoDTO tDTO) throws Exception {
		try {
			VideoEntity videoEntity = videoDAO.findById(tDTO.getVideoId());
			BeanUtil.copyProperties(videoEntity, tDTO);
			if (tDTO.getItemDTO() != null && tDTO.getItemDTO().getItemId() != null) {
				ItemEntity itemEntity = itemDAO.findById(tDTO.getItemDTO().getItemId());
				videoEntity.setItemEntity(itemEntity);
			}
			if (tDTO.getVideoSrcDTO() != null && tDTO.getVideoSrcDTO().getVideoSrcId() != null) {
				VideoSrcEntity videoSrcEntity = videoSrcDAO.findById(tDTO.getVideoSrcDTO().getVideoSrcId());
				videoEntity.setVideoSrcEntity(videoSrcEntity);
			}
			videoDAO.update(videoEntity);
			/*tDTO = ConvertFactory.getVideoConvert().toDTO(videoEntity);*/
			BeanUtil.copyProperties(tDTO, videoEntity);
			if (videoEntity.getItemEntity() != null) {
				ItemDTO itemDTO = new ItemDTO();
				BeanUtil.copyProperties(itemDTO, videoEntity.getItemEntity());
				tDTO.setItemDTO(itemDTO);
			}
			if (videoEntity.getVideoSrcEntity() != null) {
				VideoSrcDTO videoSrcDTO = new VideoSrcDTO();
				BeanUtil.copyProperties(videoSrcDTO, videoEntity.getVideoSrcEntity());
				tDTO.setVideoSrcDTO(videoSrcDTO);
			}
			
		} catch (Exception e) {
			logger.fatal("Update exception.", e);
			throw e;
		}
	}


	@Override
	public List<VideoDTO> finds(VideoDTOSearch stDTO, int start, int limit)
			throws Exception {
		return this.finds(stDTO, false, start, limit);
	}
	public List<VideoDTO> finds(VideoDTOSearch stDTO)
			throws Exception {
		return this.finds(stDTO, true, -1, -1);
	}
	public List<VideoDTO> finds(VideoDTOSearch stDTO, Boolean all, int start, int limit) throws Exception {
		List<VideoDTO> ret = new ArrayList<VideoDTO>(0);
		try {
			VideoEntitySearch videoEntitySearch = new VideoEntitySearch();
			videoEntitySearch = ConvertFactory.getVideoConvert().toEntitySearch(stDTO);
			List<VideoEntity> videoEntities = videoDAO.finds(videoEntitySearch, all, start, limit);
			if (ListUtil.isNotEmpty(videoEntities)) {
				for (VideoEntity videoEntity : videoEntities) {
					VideoDTO videoDTO = ConvertFactory.getVideoConvert().toDTO(videoEntity);
					if (videoEntity.getItemEntity() != null) {
						ItemDTO itemDTO = new ItemDTO();
						BeanUtil.copyProperties(itemDTO, videoEntity.getItemEntity());
						videoDTO.setItemDTO(itemDTO);
					}
					if (videoEntity.getVideoSrcEntity() != null) {
						VideoSrcDTO videoSrcDTO = new VideoSrcDTO();
						BeanUtil.copyProperties(videoSrcDTO, videoEntity.getVideoSrcEntity());
						videoDTO.setVideoSrcDTO(videoSrcDTO);
					}
					ret.add(videoDTO);
				}
			}
		} catch (Exception e) {
			logger.fatal("Find exception.", e);
			throw e;
		}
		return ret;
	}

	public VideoDTO findById(Long id) throws Exception {
		VideoDTO ret = new VideoDTO();
		try {
			VideoEntity videoEntity = videoDAO.findById(id);
			ret = ConvertFactory.getVideoConvert().toDTO(videoEntity);
			if (videoEntity.getItemEntity() != null) {
				ItemDTO itemDTO = new ItemDTO();
				BeanUtil.copyProperties(itemDTO, videoEntity.getItemEntity());
				ret.setItemDTO(itemDTO);
			}
			if (videoEntity.getVideoSrcEntity() != null) {
				VideoSrcDTO videoSrcDTO = new VideoSrcDTO();
				BeanUtil.copyProperties(videoSrcDTO, videoEntity.getVideoSrcEntity());
				ret.setVideoSrcDTO(videoSrcDTO);
			}
		} catch (Exception e) {
			logger.fatal("Find by id exception.", e);
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
			logger.fatal("Get count exception.", e);
			throw e;
		}
		return ret;
	}

	public void setVideoDAO(VideoDAO videoDAO) {
		this.videoDAO = videoDAO;
	}

	public void delete(VideoDTO tDTO) throws Exception {
		try {
			VideoEntity videoEntity = videoDAO.findById(tDTO.getVideoId());
			videoDAO.delete(videoEntity);
		} catch (Exception e) {
			logger.fatal("Delete exception.", e);
			throw e;
		}
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public void setVideoSrcDAO(VideoSrcDAO videoSrcDAO) {
		this.videoSrcDAO = videoSrcDAO;
	}

}
