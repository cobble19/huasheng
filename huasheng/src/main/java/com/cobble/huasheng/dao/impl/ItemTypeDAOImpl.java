package com.cobble.huasheng.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.cobble.huasheng.dao.ItemTypeDAO;
import com.cobble.huasheng.entity.ItemTypeEntity;
import com.cobble.huasheng.entity.ItemTypeEntitySearch;

public class ItemTypeDAOImpl extends CommonDAOImpl implements ItemTypeDAO {

	public void create(ItemTypeEntity t) throws Exception {
		this.getCurrentSession().save(t);

	}

	public void update(ItemTypeEntity t) throws Exception {
		this.getCurrentSession().update(t);

	}

	public List<ItemTypeEntity> finds(ItemTypeEntitySearch st) throws Exception {
		List<ItemTypeEntity> ret = null;
		try {
			 Query query = this.getCurrentSession().createQuery("from ItemTypeEntity");
			 ret = (List<ItemTypeEntity>) query.list();
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public ItemTypeEntity findById(Long id) throws Exception {
		ItemTypeEntity ret = null;
		try {
			ret = (ItemTypeEntity) this.getCurrentSession().get(ItemTypeEntity.class, id);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public long getCount(ItemTypeEntitySearch st) throws Exception {
		long ret = 0;
		try {
			Query query = this.getCurrentSession().createQuery("select count(1) from ItemTypeEntity");
			Object object = query.uniqueResult();
			ret = Long.parseLong(object.toString());
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public void delete(ItemTypeEntity tEntity) throws Exception {
		this.getCurrentSession().delete(tEntity);
	}

}
