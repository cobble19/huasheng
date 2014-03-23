package com.cobble.huasheng.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.cobble.huasheng.dao.TopicDAO;
import com.cobble.huasheng.entity.TopicEntity;
import com.cobble.huasheng.entity.TopicEntitySearch;

public class TopicDAOImpl extends CommonDAOImpl implements TopicDAO {
	private static final Logger logger = Logger.getLogger(TopicDAOImpl.class);

	public void create(TopicEntity t) throws Exception {
		try {
			this.getCurrentSession().save(t);
		} catch (Exception e) {
			logger.fatal("Create TopicEntity occur exception.", e);
			throw e;
		}
	}

	public void update(TopicEntity t) throws Exception {
		try {
			this.getCurrentSession().update(t);
		} catch (Exception e) {
			logger.fatal("Update TopicEntity occur exception.", e);
			throw e;
		}
	}
	private String getHql(TopicEntitySearch st) {
		StringBuilder hql = new StringBuilder("from TopicEntity t where 1 > 0 ");
		if (st != null) {
			if (StringUtils.isNotBlank(st.getName())) {
				hql.append(" and t.name like " + ":name");
			}
		}
		return hql.toString();
	}
	private void setQueryParams(TopicEntitySearch st, Query query) {
		if (st != null) {
			if (StringUtils.isNotBlank(st.getName())) {
				query.setString("name", "%" + st.getName() + "%");
			}
		}
	}
	public List<TopicEntity> finds(TopicEntitySearch st, Boolean all, int start, int limit) throws Exception {
		List<TopicEntity> ret = null;
		try {
			String hql = this.getHql(st);
			Query query = this.getCurrentSession().createQuery(hql.toString());
			this.setQueryParams(st, query);
			if (!all) {
				query.setFirstResult(start);
				query.setMaxResults(limit);
			}
			ret = (List<TopicEntity>) query.list();
		} catch (Exception e) {
			logger.fatal("Find TopicEntity occur exception.", e);
			throw e;
		}
		return ret;
	}
	
	public TopicEntity findById(Long id) throws Exception {
		TopicEntity ret = null;
		try {
			ret = (TopicEntity) this.getCurrentSession().get(TopicEntity.class, id);
		} catch (Exception e) {
			logger.fatal("Find occur exception.", e);
			throw e;
		}
		return ret;
	}

	public long getCount(TopicEntitySearch st) throws Exception {
		long ret = 0;
		try {
			String hql = "select count(*) ";
			hql += this.getHql(st);
			Query query = this.getCurrentSession().createQuery(hql);
			this.setQueryParams(st, query);
			Object object = query.uniqueResult();
			ret = Long.parseLong(object.toString());
		} catch (Exception e) {
			logger.fatal("Get count occur exception.", e);
			throw e;
		}
		return ret;
	}

	public void delete(TopicEntity tEntity) throws Exception {
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

}
