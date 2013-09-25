package com.cobble.huasheng.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.dto.ItemDTO;
import com.cobble.huasheng.dto.ItemDTOSearch;
import com.cobble.huasheng.service.ItemService;


public class ItemAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(ItemAction.class);
	private ItemService itemService;
	private ItemDTOSearch itemDTOSearch = new ItemDTOSearch();
	private ItemDTO itemDTO = new ItemDTO();
	private List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>(0);
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		itemDTOList = itemService.finds(itemDTOSearch);
		return this.SUCCESS;
	}

	public ItemDTOSearch getItemDTOSearch() {
		return itemDTOSearch;
	}

	public void setItemDTOSearch(ItemDTOSearch itemDTOSearch) {
		this.itemDTOSearch = itemDTOSearch;
	}

	public ItemDTO getItemDTO() {
		return itemDTO;
	}

	public void setItemDTO(ItemDTO itemDTO) {
		this.itemDTO = itemDTO;
	}

	public List<ItemDTO> getItemDTOList() {
		return itemDTOList;
	}

	public void setItemDTOList(List<ItemDTO> itemDTOList) {
		this.itemDTOList = itemDTOList;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

}
