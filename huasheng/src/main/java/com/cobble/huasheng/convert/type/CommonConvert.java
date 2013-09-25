package com.cobble.huasheng.convert.type;

import com.cobble.huasheng.util.BeanUtil;

public abstract class CommonConvert<TDTO, TEntity, TDTOSearch, TEntitySearch> {
	private Class<TDTO> dtoClass;
	private Class<TEntity> entityClass;
	private Class<TDTOSearch> dtoSearchClass;
	private Class<TEntitySearch> entitySearchClass;
	public CommonConvert(Class<TDTO> dtoClass, Class<TEntity> entityClass, 
			Class<TDTOSearch> dtoSearchClass, Class<TEntitySearch> entitySearchClass) {
		this.dtoClass = dtoClass;
		this.entityClass = entityClass;
		this.dtoSearchClass = dtoSearchClass;
		this.entitySearchClass = entitySearchClass;
	}
	/**
	 * TDTO copy value to TEntity
	 * @param entity
	 * @param dtoClass
	 * @return
	 * @throws Exception
	 */
	private TDTO toDTO(TEntity entity, Class<TDTO> dtoClass) throws Exception {
		if (entity == null) {
			return null;
		}
		TDTO ret = dtoClass.newInstance();
		if (entity != null) {
			BeanUtil.copyProperties(ret, entity);
		}
		return ret;
	}
	public TDTO toDTO(TEntity entity) throws Exception {
		return toDTO(entity, dtoClass);
	}
	
	public TEntity toEntity(TDTO dto) throws Exception {
		return toEntity(dto, entityClass);
	}
	private TEntity toEntity(TDTO dto, Class<TEntity> entityClass) throws Exception {
		if (dto == null) {
			return null;
		}
		TEntity ret = entityClass.newInstance();
		if (dto != null) {
			BeanUtil.copyProperties(ret, dto);
		}
		return ret;
	}
	
	// Search
	private TDTOSearch toDTOSearch(TEntitySearch entitySearch, Class<TDTOSearch> dtoSearchClass) throws Exception {
		if (entitySearch == null) {
			return null;
		}
		TDTOSearch ret = dtoSearchClass.newInstance();
		if (entitySearch != null) {
			BeanUtil.copyProperties(ret, entitySearch);
		}
		return ret;
	}
	public TDTOSearch toDTOSearch(TEntitySearch entitySearch) throws Exception {
		return toDTOSearch(entitySearch, dtoSearchClass);
	}
	
	public TEntitySearch toEntitySearch(TDTOSearch dtoSearch) throws Exception {
		return toEntitySearch(dtoSearch, entitySearchClass);
	}
	private TEntitySearch toEntitySearch(TDTOSearch dtoSearch, Class<TEntitySearch> entitySearchClass) throws Exception {
		if (dtoSearch == null) {
			return null;
		}
		TEntitySearch ret = entitySearchClass.newInstance();
		if (dtoSearch != null) {
			BeanUtil.copyProperties(ret, dtoSearch);
		}
		return ret;
	}
}
