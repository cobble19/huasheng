package com.cobble.huasheng.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cobble.huasheng.dto.ItemBaseInfoDTO;
import com.cobble.huasheng.dto.ItemBaseInfoDTOSearch;
import com.cobble.huasheng.service.ItemBaseInfoService;


public class ItemBaseInfoAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(ItemBaseInfoAction.class);
	private ItemBaseInfoService itemBaseInfoService;
	private ItemBaseInfoDTOSearch itemBaseInfoDTOSearch = new ItemBaseInfoDTOSearch();
	private ItemBaseInfoDTO itemBaseInfoDTO = new ItemBaseInfoDTO();
	private List<ItemBaseInfoDTO> itemBaseInfoDTOList = new ArrayList<ItemBaseInfoDTO>(0);
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		itemBaseInfoDTOList = itemBaseInfoService.finds(itemBaseInfoDTOSearch);
		return this.SUCCESS;
	}

	public ItemBaseInfoDTOSearch getItemBaseInfoDTOSearch() {
		return itemBaseInfoDTOSearch;
	}

	public void setItemBaseInfoDTOSearch(ItemBaseInfoDTOSearch itemBaseInfoDTOSearch) {
		this.itemBaseInfoDTOSearch = itemBaseInfoDTOSearch;
	}

	public ItemBaseInfoDTO getItemBaseInfoDTO() {
		return itemBaseInfoDTO;
	}

	public void setItemBaseInfoDTO(ItemBaseInfoDTO itemBaseInfoDTO) {
		this.itemBaseInfoDTO = itemBaseInfoDTO;
	}

	public List<ItemBaseInfoDTO> getItemBaseInfoDTOList() {
		return itemBaseInfoDTOList;
	}

	public void setItemBaseInfoDTOList(List<ItemBaseInfoDTO> itemBaseInfoDTOList) {
		this.itemBaseInfoDTOList = itemBaseInfoDTOList;
	}

	public void setItemBaseInfoService(ItemBaseInfoService itemBaseInfoService) {
		this.itemBaseInfoService = itemBaseInfoService;
	}

}
