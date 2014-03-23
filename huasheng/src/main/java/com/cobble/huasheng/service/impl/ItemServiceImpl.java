package com.cobble.huasheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.dao.CategoryDAO;
import com.cobble.huasheng.dao.ItemDAO;
import com.cobble.huasheng.dao.VideoDAO;
import com.cobble.huasheng.dto.CategoryDTO;
import com.cobble.huasheng.dto.ItemDTO;
import com.cobble.huasheng.dto.ItemDTOSearch;
import com.cobble.huasheng.dto.TopicDTO;
import com.cobble.huasheng.dto.VideoDTO;
import com.cobble.huasheng.dto.VideoSrcDTO;
import com.cobble.huasheng.entity.CategoryEntity;
import com.cobble.huasheng.entity.ItemEntity;
import com.cobble.huasheng.entity.ItemEntitySearch;
import com.cobble.huasheng.entity.TopicEntity;
import com.cobble.huasheng.entity.VideoEntity;
import com.cobble.huasheng.entity.VideoSrcEntity;
import com.cobble.huasheng.factory.ConvertFactory;
import com.cobble.huasheng.service.ItemService;
import com.cobble.huasheng.util.BeanUtil;
import com.cobble.huasheng.util.ListUtil;

public class ItemServiceImpl implements ItemService {
	private static final Logger logger = Logger.getLogger(ItemServiceImpl.class);
	private ItemDAO itemDAO;
	private VideoDAO videoDAO;
	private CategoryDAO categoryDAO;

	public void create(ItemDTO tDTO) throws Exception {
		ItemEntity itemEntity = new ItemEntity();
		try {
			itemEntity = ConvertFactory.getItemConvert().toEntity(tDTO);
			if (tDTO.getCategoryDTO() != null && tDTO.getCategoryDTO().getCategoryId() != null) {
				CategoryEntity categoryEntity = categoryDAO.findById(tDTO.getCategoryDTO().getCategoryId());
				if (categoryEntity != null && itemEntity != null) {
					itemEntity.setCategoryEntity(categoryEntity);
				}
			}
			itemDAO.create(itemEntity);
			BeanUtil.copyProperties(tDTO, itemEntity);
			if (itemEntity != null && tDTO != null && itemEntity.getCategoryEntity() != null) {
				CategoryDTO categoryDTO = ConvertFactory.getCategoryConvert().toDTO(itemEntity.getCategoryEntity());
				tDTO.setCategoryDTO(categoryDTO);
			}
//			tDTO = ConvertFactory.getItemConvert().toDTO(itemEntity);
		} catch (Exception e) {
			logger.fatal("Create exception.", e);
			throw e;
		}
	}

	public void update(ItemDTO tDTO) throws Exception {
		try {
			ItemEntity itemEntity = itemDAO.findById(tDTO.getItemId());
			BeanUtil.copyProperties(itemEntity, tDTO);
			if (tDTO.getCategoryDTO() != null && tDTO.getCategoryDTO().getCategoryId() != null) {
				CategoryEntity categoryEntity = categoryDAO.findById(tDTO.getCategoryDTO().getCategoryId());
				if (categoryEntity != null && itemEntity != null) {
					itemEntity.setCategoryEntity(categoryEntity);
				}
			}
			itemDAO.update(itemEntity);
		} catch (Exception e) {
			logger.fatal("Update exception.", e);
			throw e;
		}
	}

	public List<ItemDTO> finds(ItemDTOSearch stDTO, Boolean all, int start, int limit)
			throws Exception {
		List<ItemDTO> ret = new ArrayList<ItemDTO>(0);
		try {
			ItemEntitySearch itemEntitySearch = new ItemEntitySearch();
			itemEntitySearch = ConvertFactory.getItemConvert().toEntitySearch(stDTO);
			List<ItemEntity> itemEntities = itemDAO.finds(itemEntitySearch, all, start, limit);
			if (ListUtil.isNotEmpty(itemEntities)) {
				for (ItemEntity itemEntity : itemEntities) {
					ItemDTO itemDTO = ConvertFactory.getItemConvert().toDTO(itemEntity);
					CategoryEntity categoryEntity = itemEntity.getCategoryEntity();
					CategoryDTO categoryDTO = ConvertFactory.getCategoryConvert().toDTO(categoryEntity);
					TopicEntity topicEntity = categoryEntity.getTopicEntity();
					TopicDTO topicDTO = ConvertFactory.getTopicConvert().toDTO(topicEntity);
					categoryDTO.setTopicDTO(topicDTO);
					itemDTO.setCategoryDTO(categoryDTO);
					ret.add(itemDTO);
				}
			}
		} catch (Exception e) {
			logger.fatal("Find exception.", e);
			throw e;
		}
		return ret;
	}
	
	public List<ItemDTO> finds(ItemDTOSearch stDTO) throws Exception {
		return this.finds(stDTO, true, -1, -1);
	}
	public List<ItemDTO> finds(ItemDTOSearch stDTO, int start, int limit) throws Exception {
		return this.finds(stDTO, false, start, limit);
	}
	public ItemDTO findById(Long id) throws Exception {
		ItemDTO ret = new ItemDTO();
		try {
			ItemEntity itemEntity = itemDAO.findById(id);
			ret = ConvertFactory.getItemConvert().toDTO(itemEntity);
			List<VideoSrcDTO> videoSrcDTOs = new ArrayList<VideoSrcDTO>();
			ret.setVideoSrcDTOs(videoSrcDTOs);
			if (itemEntity != null) {
				List<VideoEntity> videoEntities = itemEntity.getVideoEntities();
				if (ListUtil.isEmpty(videoEntities)) {
					return ret;
				}
				for (VideoEntity videoEntity : videoEntities) {
					VideoSrcEntity videoSrcEntity = videoEntity.getVideoSrcEntity();
					VideoSrcDTO videoSrcDTO = new VideoSrcDTO();
					BeanUtil.copyProperties(videoSrcDTO, videoSrcEntity);

					if (!videoSrcDTOs.contains(videoSrcDTO)) {
						videoSrcDTOs.add(videoSrcDTO);
					}

					VideoDTO videoDTO = new VideoDTO();
					BeanUtil.copyProperties(videoDTO, videoEntity);
					if (ListUtil.isNotEmpty(videoSrcDTOs)) {
						for (int i = 0; i < videoSrcDTOs.size(); i++) {
							VideoSrcDTO temp = videoSrcDTOs.get(i);
							if (temp.getVideoSrcId().longValue() != videoSrcDTO.getVideoSrcId().longValue()) {
								continue;
							}
							if (ListUtil.isEmpty(temp.getVideoDTOs())) {
								temp.setVideoDTOs(new ArrayList<VideoDTO>());
							}
							if (!temp.getVideoDTOs().contains(videoDTO)) {
								temp.getVideoDTOs().add(videoDTO);
							}
						}
					}
				}
				ret.setVideoSrcDTOs(videoSrcDTOs);
			}
		} catch (Exception e) {
			logger.fatal("Find by id exception.", e);
			throw e;
		}
		return ret;
	}

	public long getCount(ItemDTOSearch stDTO) throws Exception {
		long ret = 0;
		try {
			ItemEntitySearch itemEntitySearch = new ItemEntitySearch();
			BeanUtil.copyProperties(itemEntitySearch, stDTO);
			ret = itemDAO.getCount(itemEntitySearch);
		} catch (Exception e) {
			logger.fatal("Get count exception.", e);
			throw e;
		}
		return ret;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public void setVideoDAO(VideoDAO videoDAO) {
		this.videoDAO = videoDAO;
	}

	public void delete(ItemDTO tDTO) throws Exception {
		try {
			ItemEntity itemEntity = itemDAO.findById(tDTO.getItemId());
			itemDAO.delete(itemEntity);
		} catch (Exception e) {
			logger.fatal("Delete exception.", e);
			throw e;
		}
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

}
