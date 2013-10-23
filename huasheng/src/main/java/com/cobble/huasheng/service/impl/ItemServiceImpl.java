package com.cobble.huasheng.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cobble.huasheng.dao.ItemDAO;
import com.cobble.huasheng.dao.VideoDAO;
import com.cobble.huasheng.dto.ActorDTO;
import com.cobble.huasheng.dto.ItemBaseInfoDTO;
import com.cobble.huasheng.dto.ItemDTO;
import com.cobble.huasheng.dto.ItemDTOSearch;
import com.cobble.huasheng.dto.ItemTypeDTO;
import com.cobble.huasheng.dto.VideoDTO;
import com.cobble.huasheng.dto.VideoSrcDTO;
import com.cobble.huasheng.entity.ActorEntity;
import com.cobble.huasheng.entity.ItemBaseInfoEntity;
import com.cobble.huasheng.entity.ItemEntity;
import com.cobble.huasheng.entity.ItemEntitySearch;
import com.cobble.huasheng.entity.ItemTypeEntity;
import com.cobble.huasheng.entity.VideoEntity;
import com.cobble.huasheng.entity.VideoSrcEntity;
import com.cobble.huasheng.factory.ConvertFactory;
import com.cobble.huasheng.service.ItemService;
import com.cobble.huasheng.util.BeanUtil;
import com.cobble.huasheng.util.ListUtil;

public class ItemServiceImpl implements ItemService {
	private ItemDAO itemDAO;
	private VideoDAO videoDAO;

	public void create(ItemDTO tDTO) throws Exception {
		ItemEntity itemEntity = new ItemEntity();
		try {
			itemEntity = ConvertFactory.getItemConvert().toEntity(tDTO);
			itemDAO.create(itemEntity);
			tDTO = ConvertFactory.getItemConvert().toDTO(itemEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public void update(ItemDTO tDTO) throws Exception {
		try {
			ItemEntity itemEntity = itemDAO.findById(tDTO.getItemId());
			itemEntity = ConvertFactory.getItemConvert().toEntity(tDTO);
			itemDAO.update(itemEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<ItemDTO> finds(ItemDTOSearch stDTO) throws Exception {
		List<ItemDTO> ret = new ArrayList<ItemDTO>(0);
		try {
			ItemEntitySearch itemEntitySearch = new ItemEntitySearch();
			itemEntitySearch = ConvertFactory.getItemConvert().toEntitySearch(stDTO);
			List<ItemEntity> itemEntities = itemDAO.finds(itemEntitySearch);
			if (ListUtil.isNotEmpty(itemEntities)) {
				for (ItemEntity itemEntity : itemEntities) {
					ItemDTO itemDTO = ConvertFactory.getItemConvert().toDTO(itemEntity);
					ret.add(itemDTO);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public ItemDTO findById(Long id) throws Exception {
		ItemDTO ret = new ItemDTO();
		try {
			ItemEntity itemEntity = itemDAO.findById(id);
			ret = ConvertFactory.getItemConvert().toDTO(itemEntity);
			if (itemEntity != null) {
				/*ItemBaseInfoEntity itemBaseInfoEntity = itemEntity.getItemBaseInfoEntity();
				ItemBaseInfoDTO itemBaseInfoDTO = ConvertFactory.getItemBaseInfoConvert().toDTO(itemBaseInfoEntity);
				ret.setItemBaseInfoDTO(itemBaseInfoDTO);
				if (itemBaseInfoEntity != null) {
					Set<ActorEntity> actorEntities = itemBaseInfoEntity.getActorEntities();
					Set<ActorDTO> actorDTOs = new HashSet<ActorDTO>();
					if (ListUtil.isNotEmpty(actorEntities)) {
						for (ActorEntity actorEntity : actorEntities) {
							ActorDTO actorDTO = ConvertFactory.getActorConvert().toDTO(actorEntity);
							actorDTOs.add(actorDTO);
						}
					}
					itemBaseInfoDTO.setActorDTOs(actorDTOs);
					
					Set<ItemTypeEntity> itemTypeEntities = itemBaseInfoEntity.getItemTypeEntities();
					Set<ItemTypeDTO> itemTypeDTOs = new HashSet<ItemTypeDTO>();
					if (ListUtil.isNotEmpty(itemTypeEntities)) {
						for (ItemTypeEntity itemTypeEntity : itemTypeEntities) {
							ItemTypeDTO itemTypeDTO = ConvertFactory.getItemTypeConvert().toDTO(itemTypeEntity);
							itemTypeDTOs.add(itemTypeDTO);
						}
						itemBaseInfoDTO.setItemTypeDTOs(itemTypeDTOs);
					}
				}*/
				
				Set<VideoSrcEntity> videoSrcEntities = itemEntity.getVideoSrcEntities();
				if (ListUtil.isNotEmpty(videoSrcEntities)) {
					Set<VideoSrcDTO> videoSrcDTOs = new HashSet<VideoSrcDTO>();
					for (VideoSrcEntity videoSrcEntity : videoSrcEntities) {
						VideoSrcDTO videoSrcDTO = ConvertFactory.getVideoSrcConvert().toDTO(videoSrcEntity);
						videoSrcDTOs.add(videoSrcDTO);
						
						Set<VideoEntity> videoEntities = videoSrcEntity.getVideoEntities();
						if (ListUtil.isNotEmpty(videoEntities)) {
							Set<VideoDTO> videoDTOs = new HashSet<VideoDTO>();
							for (VideoEntity videoEntity : videoEntities) {
								VideoDTO videoDTO = ConvertFactory.getVideoConvert().toDTO(videoEntity);
								videoDTOs.add(videoDTO);
							}
							videoSrcDTO.setVideoDTOs(videoDTOs);
						}
					}
					ret.setVideoSrcDTOs(videoSrcDTOs);
				}
				/*if (ListUtil.isNotEmpty(videoEntities)) {
					Set<VideoDTO> videoDTOs = new HashSet<VideoDTO>();
					Set<VideoSrcDTO> videoSrcDTOs = new HashSet<VideoSrcDTO>();
					for (VideoEntity videoEntity : videoEntities) {
						VideoDTO videoDTO = ConvertFactory.getVideoConvert().toDTO(videoEntity);
						videoDTOs.add(videoDTO);
						if (videoEntity != null) {
							videoEntity = videoDAO.findById(videoEntity.getVideoId());
							VideoSrcEntity videoSrcEntity = videoEntity.getVideoSrcEntity();
							VideoSrcDTO videoSrcDTO = ConvertFactory.getVideoSrcConvert().toDTO(videoSrcEntity);
							videoSrcDTO.setVideoDTOs(videoDTOs);
							videoSrcDTOs.add(videoSrcDTO);
							
						}
					}
					ret.setVideoDTOs(videoDTOs);
					ret.setVideoSrcDTOs(videoSrcDTOs);
				}*/
				
			}
		} catch (Exception e) {
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
		ItemEntity itemEntity = itemDAO.findById(tDTO.getItemId());
		itemDAO.delete(itemEntity);
	}

}
