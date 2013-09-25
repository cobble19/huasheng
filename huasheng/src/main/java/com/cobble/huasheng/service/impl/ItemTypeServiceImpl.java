package com.cobble.huasheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cobble.huasheng.dao.ItemTypeDAO;
import com.cobble.huasheng.dto.ItemTypeDTO;
import com.cobble.huasheng.dto.ItemTypeDTOSearch;
import com.cobble.huasheng.entity.ItemTypeEntity;
import com.cobble.huasheng.entity.ItemTypeEntitySearch;
import com.cobble.huasheng.factory.ConvertFactory;
import com.cobble.huasheng.service.ItemTypeService;
import com.cobble.huasheng.util.BeanUtil;
import com.cobble.huasheng.util.ListUtil;

public class ItemTypeServiceImpl implements ItemTypeService {
	private ItemTypeDAO itemTypeDAO;

	public void create(ItemTypeDTO tDTO) throws Exception {
		ItemTypeEntity itemTypeEntity = new ItemTypeEntity();
		try {
			itemTypeEntity = ConvertFactory.getItemTypeConvert().toEntity(tDTO);
			itemTypeDAO.create(itemTypeEntity);
			tDTO = ConvertFactory.getItemTypeConvert().toDTO(itemTypeEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public void update(ItemTypeDTO tDTO) throws Exception {
		try {
			ItemTypeEntity itemTypeEntity = itemTypeDAO.findById(tDTO.getItemTypeId());
			itemTypeEntity = ConvertFactory.getItemTypeConvert().toEntity(tDTO);
			itemTypeDAO.update(itemTypeEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<ItemTypeDTO> finds(ItemTypeDTOSearch stDTO) throws Exception {
		List<ItemTypeDTO> ret = new ArrayList<ItemTypeDTO>(0);
		try {
			ItemTypeEntitySearch itemTypeEntitySearch = new ItemTypeEntitySearch();
			itemTypeEntitySearch = ConvertFactory.getItemTypeConvert().toEntitySearch(stDTO);
			List<ItemTypeEntity> itemTypeEntities = itemTypeDAO.finds(itemTypeEntitySearch);
			if (ListUtil.isNotEmpty(itemTypeEntities)) {
				for (ItemTypeEntity itemTypeEntity : itemTypeEntities) {
					ItemTypeDTO itemTypeDTO = ConvertFactory.getItemTypeConvert().toDTO(itemTypeEntity);
					ret.add(itemTypeDTO);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public ItemTypeDTO findById(Long id) throws Exception {
		ItemTypeDTO ret = new ItemTypeDTO();
		try {
			ItemTypeEntity itemTypeEntity = itemTypeDAO.findById(id);
			ret = ConvertFactory.getItemTypeConvert().toDTO(itemTypeEntity);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public long getCount(ItemTypeDTOSearch stDTO) throws Exception {
		long ret = 0;
		try {
			ItemTypeEntitySearch itemTypeEntitySearch = new ItemTypeEntitySearch();
			BeanUtil.copyProperties(itemTypeEntitySearch, stDTO);
			ret = itemTypeDAO.getCount(itemTypeEntitySearch);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public void setItemTypeDAO(ItemTypeDAO itemTypeDAO) {
		this.itemTypeDAO = itemTypeDAO;
	}

}
