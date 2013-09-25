package com.cobble.huasheng.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.cobble.huasheng.dao.ItemDAO;
import com.cobble.huasheng.entity.ItemEntity;
import com.cobble.huasheng.entity.ItemEntitySearch;

public class ItemDAOImpl extends CommonDAOImpl implements ItemDAO {

	public void create(ItemEntity tEntity) throws Exception {
		this.getCurrentSession().save(tEntity);
	}

	public void update(ItemEntity tEntity) throws Exception {
		this.getCurrentSession().update(tEntity);
	}

	public List<ItemEntity> finds(ItemEntitySearch st) throws Exception {
		List<ItemEntity> ret = null;
		try {
			 Query query = this.getCurrentSession().createQuery("from ItemEntity");
			 ret = (List<ItemEntity>) query.list();
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public ItemEntity findById(Long id) throws Exception {
		ItemEntity ret = null;
		try {
			ret = (ItemEntity) this.getCurrentSession().get(ItemEntity.class, id);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public long getCount(ItemEntitySearch st) throws Exception {
		long ret = 0;
		try {
			Query query = this.getCurrentSession().createQuery("select count(1) from ItemEntity");
			Object object = query.uniqueResult();
			ret = Long.parseLong(object.toString());
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}


}
