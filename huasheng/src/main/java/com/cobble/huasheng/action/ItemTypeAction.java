package com.cobble.huasheng.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.dto.ItemTypeDTO;
import com.cobble.huasheng.dto.ItemTypeDTOSearch;
import com.cobble.huasheng.service.ItemTypeService;


public class ItemTypeAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(ItemTypeAction.class);
	private ItemTypeService itemTypeService;
	private ItemTypeDTOSearch itemTypeDTOSearch = new ItemTypeDTOSearch();
	private ItemTypeDTO itemTypeDTO = new ItemTypeDTO();
	private List<ItemTypeDTO> itemTypeDTOList = new ArrayList<ItemTypeDTO>(0);
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		itemTypeDTOList = itemTypeService.finds(itemTypeDTOSearch);
		return this.SUCCESS;
	}

	public ItemTypeDTOSearch getItemTypeDTOSearch() {
		return itemTypeDTOSearch;
	}

	public void setItemTypeDTOSearch(ItemTypeDTOSearch itemTypeDTOSearch) {
		this.itemTypeDTOSearch = itemTypeDTOSearch;
	}

	public ItemTypeDTO getItemTypeDTO() {
		return itemTypeDTO;
	}

	public void setItemTypeDTO(ItemTypeDTO itemTypeDTO) {
		this.itemTypeDTO = itemTypeDTO;
	}

	public List<ItemTypeDTO> getItemTypeDTOList() {
		return itemTypeDTOList;
	}

	public void setItemTypeDTOList(List<ItemTypeDTO> itemTypeDTOList) {
		this.itemTypeDTOList = itemTypeDTOList;
	}

	public void setItemTypeService(ItemTypeService itemTypeService) {
		this.itemTypeService = itemTypeService;
	}

}
