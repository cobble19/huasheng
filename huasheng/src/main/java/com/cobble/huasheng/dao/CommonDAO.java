package com.cobble.huasheng.dao;

import java.util.List;

public interface CommonDAO<TEntity, STEntity> {
	public void create(TEntity tEntity) throws Exception;
	public void update(TEntity tEntity) throws Exception;
	public List<TEntity> finds(STEntity stEntity) throws Exception;
	public TEntity findById(Long id) throws Exception;
	public long getCount(STEntity stEntity) throws Exception;
	public void delete(TEntity tEntity) throws Exception;
}
