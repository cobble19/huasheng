package com.cobble.huasheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cobble.huasheng.dao.ItemBaseInfoDAO;
import com.cobble.huasheng.dto.ItemBaseInfoDTO;
import com.cobble.huasheng.dto.ItemBaseInfoDTOSearch;
import com.cobble.huasheng.entity.ItemBaseInfoEntity;
import com.cobble.huasheng.entity.ItemBaseInfoEntitySearch;
import com.cobble.huasheng.factory.ConvertFactory;
import com.cobble.huasheng.service.ItemBaseInfoService;
import com.cobble.huasheng.util.BeanUtil;
import com.cobble.huasheng.util.ListUtil;

public class ItemBaseInfoServiceImpl implements ItemBaseInfoService {
	private ItemBaseInfoDAO itemBaseInfoDAO;

	public void create(ItemBaseInfoDTO tDTO) throws Exception {
		ItemBaseInfoEntity itemBaseInfoEntity = new ItemBaseInfoEntity();
		try {
			itemBaseInfoEntity = ConvertFactory.getItemBaseInfoConvert().toEntity(tDTO);
			itemBaseInfoDAO.create(itemBaseInfoEntity);
			tDTO = ConvertFactory.getItemBaseInfoConvert().toDTO(itemBaseInfoEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public void update(ItemBaseInfoDTO tDTO) throws Exception {
		try {
			ItemBaseInfoEntity itemBaseInfoEntity = itemBaseInfoDAO.findById(tDTO.getItemBaseInfoId());
			itemBaseInfoEntity = ConvertFactory.getItemBaseInfoConvert().toEntity(tDTO);
			itemBaseInfoDAO.update(itemBaseInfoEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<ItemBaseInfoDTO> finds(ItemBaseInfoDTOSearch stDTO) throws Exception {
		List<ItemBaseInfoDTO> ret = new ArrayList<ItemBaseInfoDTO>(0);
		try {
			ItemBaseInfoEntitySearch itemBaseInfoEntitySearch = new ItemBaseInfoEntitySearch();
			itemBaseInfoEntitySearch = ConvertFactory.getItemBaseInfoConvert().toEntitySearch(stDTO);
			List<ItemBaseInfoEntity> itemBaseInfoEntities = itemBaseInfoDAO.finds(itemBaseInfoEntitySearch);
			if (ListUtil.isNotEmpty(itemBaseInfoEntities)) {
				for (ItemBaseInfoEntity itemBaseInfoEntity : itemBaseInfoEntities) {
					ItemBaseInfoDTO itemBaseInfoDTO = ConvertFactory.getItemBaseInfoConvert().toDTO(itemBaseInfoEntity);
					ret.add(itemBaseInfoDTO);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public ItemBaseInfoDTO findById(Long id) throws Exception {
		ItemBaseInfoDTO ret = new ItemBaseInfoDTO();
		try {
			ItemBaseInfoEntity itemBaseInfoEntity = itemBaseInfoDAO.findById(id);
			ret = ConvertFactory.getItemBaseInfoConvert().toDTO(itemBaseInfoEntity);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public long getCount(ItemBaseInfoDTOSearch stDTO) throws Exception {
		long ret = 0;
		try {
			ItemBaseInfoEntitySearch itemBaseInfoEntitySearch = new ItemBaseInfoEntitySearch();
			BeanUtil.copyProperties(itemBaseInfoEntitySearch, stDTO);
			ret = itemBaseInfoDAO.getCount(itemBaseInfoEntitySearch);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public void setItemBaseInfoDAO(ItemBaseInfoDAO itemBaseInfoDAO) {
		this.itemBaseInfoDAO = itemBaseInfoDAO;
	}

	public void delete(ItemBaseInfoDTO tDTO) throws Exception {
		ItemBaseInfoEntity itemBaseInfoEntity = itemBaseInfoDAO.findById(tDTO.getItemBaseInfoId());
		itemBaseInfoDAO.delete(itemBaseInfoEntity);
	}

}
