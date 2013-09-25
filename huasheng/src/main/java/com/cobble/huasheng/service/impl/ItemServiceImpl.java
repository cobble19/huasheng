package com.cobble.huasheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cobble.huasheng.dao.ItemDAO;
import com.cobble.huasheng.dto.ItemDTO;
import com.cobble.huasheng.dto.ItemDTOSearch;
import com.cobble.huasheng.entity.ItemEntity;
import com.cobble.huasheng.entity.ItemEntitySearch;
import com.cobble.huasheng.factory.ConvertFactory;
import com.cobble.huasheng.service.ItemService;
import com.cobble.huasheng.util.BeanUtil;
import com.cobble.huasheng.util.ListUtil;

public class ItemServiceImpl implements ItemService {
	private ItemDAO itemDAO;

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

}
