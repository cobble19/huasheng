package com.cobble.huasheng.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.cobble.huasheng.dao.ItemBaseInfoDAO;
import com.cobble.huasheng.entity.ItemBaseInfoEntity;
import com.cobble.huasheng.entity.ItemBaseInfoEntitySearch;

public class ItemBaseInfoDAOImpl extends CommonDAOImpl implements ItemBaseInfoDAO {

	public void create(ItemBaseInfoEntity t) throws Exception {
		this.getCurrentSession().save(t);

	}

	public void update(ItemBaseInfoEntity t) throws Exception {
		this.getCurrentSession().update(t);

	}

	public List<ItemBaseInfoEntity> finds(ItemBaseInfoEntitySearch st) throws Exception {
		List<ItemBaseInfoEntity> ret = null;
		try {
			 Query query = this.getCurrentSession().createQuery("from ItemBaseInfoEntity");
			 ret = (List<ItemBaseInfoEntity>) query.list();
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public ItemBaseInfoEntity findById(Long id) throws Exception {
		ItemBaseInfoEntity ret = null;
		try {
			ret = (ItemBaseInfoEntity) this.getCurrentSession().get(ItemBaseInfoEntity.class, id);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public long getCount(ItemBaseInfoEntitySearch st) throws Exception {
		long ret = 0;
		try {
			Query query = this.getCurrentSession().createQuery("select count(1) from ItemBaseInfoEntity");
			Object object = query.uniqueResult();
			ret = Long.parseLong(object.toString());
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public void delete(ItemBaseInfoEntity tEntity) throws Exception {
		this.getCurrentSession().delete(tEntity);
	}

}
