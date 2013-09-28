package com.cobble.huasheng.factory;

import com.cobble.huasheng.convert.type.ActorConvert;
import com.cobble.huasheng.convert.type.CategoryConvert;
import com.cobble.huasheng.convert.type.ItemBaseInfoConvert;
import com.cobble.huasheng.convert.type.ItemConvert;
import com.cobble.huasheng.convert.type.ItemTypeConvert;
import com.cobble.huasheng.convert.type.TopicConvert;
import com.cobble.huasheng.convert.type.VideoConvert;
import com.cobble.huasheng.convert.type.VideoSrcConvert;
import com.cobble.huasheng.dto.ActorDTO;
import com.cobble.huasheng.dto.ActorDTOSearch;
import com.cobble.huasheng.dto.CategoryDTO;
import com.cobble.huasheng.dto.CategoryDTOSearch;
import com.cobble.huasheng.dto.ItemBaseInfoDTO;
import com.cobble.huasheng.dto.ItemBaseInfoDTOSearch;
import com.cobble.huasheng.dto.ItemDTO;
import com.cobble.huasheng.dto.ItemDTOSearch;
import com.cobble.huasheng.dto.ItemTypeDTO;
import com.cobble.huasheng.dto.ItemTypeDTOSearch;
import com.cobble.huasheng.dto.TopicDTO;
import com.cobble.huasheng.dto.TopicDTOSearch;
import com.cobble.huasheng.dto.VideoDTO;
import com.cobble.huasheng.dto.VideoDTOSearch;
import com.cobble.huasheng.dto.VideoSrcDTO;
import com.cobble.huasheng.dto.VideoSrcDTOSearch;
import com.cobble.huasheng.entity.ActorEntity;
import com.cobble.huasheng.entity.ActorEntitySearch;
import com.cobble.huasheng.entity.CategoryEntity;
import com.cobble.huasheng.entity.CategoryEntitySearch;
import com.cobble.huasheng.entity.ItemBaseInfoEntity;
import com.cobble.huasheng.entity.ItemBaseInfoEntitySearch;
import com.cobble.huasheng.entity.ItemEntity;
import com.cobble.huasheng.entity.ItemEntitySearch;
import com.cobble.huasheng.entity.ItemTypeEntity;
import com.cobble.huasheng.entity.ItemTypeEntitySearch;
import com.cobble.huasheng.entity.TopicEntity;
import com.cobble.huasheng.entity.TopicEntitySearch;
import com.cobble.huasheng.entity.VideoEntity;
import com.cobble.huasheng.entity.VideoEntitySearch;
import com.cobble.huasheng.entity.VideoSrcEntity;
import com.cobble.huasheng.entity.VideoSrcEntitySearch;

public class ConvertFactory {

	private ConvertFactory() {
	}
	
	public static TopicConvert getTopicConvert() {
		return new TopicConvert(TopicDTO.class, TopicEntity.class, 
				TopicDTOSearch.class, TopicEntitySearch.class);
	}
	
	public static CategoryConvert getCategoryConvert() {
		return new CategoryConvert(CategoryDTO.class, CategoryEntity.class,
				CategoryDTOSearch.class, CategoryEntitySearch.class);
	}

	public static ItemConvert getItemConvert() {
		return new ItemConvert(ItemDTO.class, ItemEntity.class,
				ItemDTOSearch.class, ItemEntitySearch.class);
	}
	
	public static ItemBaseInfoConvert getItemBaseInfoConvert() {
		return new ItemBaseInfoConvert(ItemBaseInfoDTO.class, ItemBaseInfoEntity.class,
				ItemBaseInfoDTOSearch.class, ItemBaseInfoEntitySearch.class);
	}
	
	public static ItemTypeConvert getItemTypeConvert() {
		return new ItemTypeConvert(ItemTypeDTO.class, ItemTypeEntity.class,
				ItemTypeDTOSearch.class, ItemTypeEntitySearch.class);
	}
	
	public static VideoConvert getVideoConvert() {
		return new VideoConvert(VideoDTO.class, VideoEntity.class,
				VideoDTOSearch.class, VideoEntitySearch.class);
	}
	
	public static VideoSrcConvert getVideoSrcConvert() {
		return new VideoSrcConvert(VideoSrcDTO.class, VideoSrcEntity.class,
				VideoSrcDTOSearch.class, VideoSrcEntitySearch.class);
	}
	
	public static ActorConvert getActorConvert() {
		return new ActorConvert(ActorDTO.class, ActorEntity.class,
				ActorDTOSearch.class, ActorEntitySearch.class);
	}
}
