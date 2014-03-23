package com.cobble.huasheng.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.cobble.huasheng.dao.ItemDAO;
import com.cobble.huasheng.entity.ItemEntity;
import com.cobble.huasheng.entity.ItemEntitySearch;

public class ItemDAOImpl extends CommonDAOImpl implements ItemDAO {
	private static final Logger logger = Logger.getLogger(ItemDAOImpl.class);

	public void create(ItemEntity tEntity) throws Exception {
		try {
			this.getCurrentSession().save(tEntity);
		} catch (Exception e) {
			logger.fatal("Create CategoryEntity occur exception.", e);
			throw e;
		}
	}

	public void update(ItemEntity tEntity) throws Exception {
		try {
			this.getCurrentSession().update(tEntity);
		} catch (Exception e) {
			logger.fatal("Update CategoryEntity occur exception.", e);
			throw e;
		}
	}

	public ItemEntity findById(Long id) throws Exception {
		ItemEntity ret = null;
		try {
			ret = (ItemEntity) this.getCurrentSession().get(ItemEntity.class, id);
		} catch (Exception e) {
			logger.fatal("Find by id occur exception.", e);
			throw e;
		}
		return ret;
	}

	public long getCount(ItemEntitySearch st) throws Exception {
		long ret = 0;
		try {
			String hql = "select count(*) ";
			hql += this.getHql(st);
			Query query = this.getCurrentSession().createQuery(hql);
			this.setQueryParams(st, query);
			Object object = query.uniqueResult();
			ret = Long.parseLong(object.toString());
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public void delete(ItemEntity tEntity) throws Exception {
		if (tEntity == null) {
			return;
		}
		try {
			this.getCurrentSession().delete(tEntity);
		} catch (Exception e) {
			logger.fatal("Delete occur exception.", e);
			throw e;
		}
	}
	
	private String getHql(ItemEntitySearch st) {
		StringBuilder hql = new StringBuilder("from ItemEntity where 1 > 0 ");
		if (st != null) {
			if (StringUtils.isNotBlank(st.getName())) {
				hql.append(" and name like " + ":name");
			}
		}
		return hql.toString();
	}
	private void setQueryParams(ItemEntitySearch st, Query query) {
		if (st != null) {
			if (StringUtils.isNotBlank(st.getName())) {
				query.setString("name", "%" + st.getName() + "%");
			}
		}
	}
	@Override
	public List<ItemEntity> finds(ItemEntitySearch st, Boolean all, int start,
			int limit) throws Exception {
		List<ItemEntity> ret = null;
		try {
			String hql = this.getHql(st);
			Query query = this.getCurrentSession().createQuery(hql.toString());
			this.setQueryParams(st, query);
			if (!all) {
				query.setFirstResult(start);
				query.setMaxResults(limit);
			}
			ret = (List<ItemEntity>) query.list();
		} catch (Exception e) {
			logger.fatal("Find occur exception.", e);
			throw e;
		}
		return ret;
	}


}
