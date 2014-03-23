package com.cobble.huasheng.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.cobble.huasheng.dao.CategoryDAO;
import com.cobble.huasheng.entity.CategoryEntity;
import com.cobble.huasheng.entity.CategoryEntitySearch;

public class CategoryDAOImpl extends CommonDAOImpl implements CategoryDAO {
	private static final Logger logger = Logger.getLogger(CategoryDAOImpl.class);

	public void create(CategoryEntity tEntity) throws Exception {
		try {
			this.getCurrentSession().save(tEntity);
		} catch (Exception e) {
			logger.fatal("Create CategoryEntity occur exception.", e);
			throw e;
		}
	}

	public void update(CategoryEntity tEntity) throws Exception {
		try {
			this.getCurrentSession().update(tEntity);
		} catch (Exception e) {
			logger.fatal("Update CategoryEntity occur exception.", e);
			throw e;
		}
	}

	public CategoryEntity findById(Long id) throws Exception {
		CategoryEntity ret = null;
		try {
			ret = (CategoryEntity) this.getCurrentSession().get(CategoryEntity.class, id);
		} catch (Exception e) {
			logger.fatal("Find CategoryEntity by id occur exception.", e);
			throw e;
		}
		return ret;
	}

	public long getCount(CategoryEntitySearch stEntity) throws Exception {
		long ret = 0;
		try {
			String hql = "select count(*) ";
			hql += this.getHql(stEntity);
			Query query = this.getCurrentSession().createQuery(hql);
			this.setQueryParams(stEntity, query);
			Object object = query.uniqueResult();
			ret = Long.parseLong(object.toString());
		} catch (Exception e) {
			logger.fatal("Get count of CategoryEntity occur exception.", e);
			throw e;
		}
		return ret;
	}

	public void delete(CategoryEntity tEntity) throws Exception {
		try {
			this.getCurrentSession().delete(tEntity);
		} catch (Exception e) {
			logger.fatal("Delete excepton.", e);
			throw e;
		}
	}
	private String getHql(CategoryEntitySearch st) {
		StringBuilder hql = new StringBuilder("from CategoryEntity where 1 > 0 ");
		if (st != null) {
			if (StringUtils.isNotBlank(st.getName())) {
				hql.append(" and name like " + ":name");
			}
		}
		hql.append(" order by orderNo asc");
		return hql.toString();
	}
	private void setQueryParams(CategoryEntitySearch st, Query query) {
		if (st != null) {
			if (StringUtils.isNotBlank(st.getName())) {
				query.setString("name", "%" + st.getName() + "%");
			}
		}
	}
	@Override
	public List<CategoryEntity> finds(CategoryEntitySearch st, Boolean all,
			int start, int limit) throws Exception {
		List<CategoryEntity> ret = null;
		try {
			String hql = this.getHql(st);
			Query query = this.getCurrentSession().createQuery(hql);
			this.setQueryParams(st, query);
			if (!all) {
				query.setFirstResult(start);
				query.setMaxResults(limit);
			}
			ret = (List<CategoryEntity>) query.list();
		} catch (Exception e) {
			logger.fatal("Find CategoryEntity occur exception.", e);
			throw e;
		}
		return ret;
	}

}
