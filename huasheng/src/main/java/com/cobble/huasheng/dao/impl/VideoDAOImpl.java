package com.cobble.huasheng.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.cobble.huasheng.dao.VideoDAO;
import com.cobble.huasheng.entity.TopicEntity;
import com.cobble.huasheng.entity.TopicEntitySearch;
import com.cobble.huasheng.entity.VideoEntity;
import com.cobble.huasheng.entity.VideoEntitySearch;

public class VideoDAOImpl extends CommonDAOImpl implements VideoDAO {
	private static final Logger logger = Logger.getLogger(VideoDAOImpl.class);

	public void create(VideoEntity t) throws Exception {
		try {
			this.getCurrentSession().save(t);
		} catch (Exception e) {
			logger.fatal("Create occur exception.", e);
			throw e;
		}

	}

	public void update(VideoEntity t) throws Exception {
		try {
			this.getCurrentSession().update(t);
		} catch (Exception e) {
			logger.fatal("Update occur exception.", e);
			throw e;
		}
	}

	public List<VideoEntity> finds(VideoEntitySearch st) throws Exception {
		List<VideoEntity> ret = null;
		try {
			 Query query = this.getCurrentSession().createQuery("from VideoEntity");
			 ret = (List<VideoEntity>) query.list();
		} catch (Exception e) {
			logger.fatal("Find occur exception.", e);
			throw e;
		}
		return ret;
	}

	public VideoEntity findById(Long id) throws Exception {
		VideoEntity ret = null;
		try {
			ret = (VideoEntity) this.getCurrentSession().get(VideoEntity.class, id);
		} catch (Exception e) {
			logger.fatal("Find by id occur exception.", e);
			throw e;
		}
		return ret;
	}

	public long getCount(VideoEntitySearch st) throws Exception {
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

	public void delete(VideoEntity tEntity) throws Exception {
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

	private String getHql(VideoEntitySearch st) {
		StringBuilder hql = new StringBuilder("from VideoEntity where 1 > 0 ");
		if (st != null) {
			if (StringUtils.isNotBlank(st.getName())) {
				hql.append(" and name like " + ":name");
			}
		}
		return hql.toString();
	}
	private void setQueryParams(VideoEntitySearch st, Query query) {
		if (st != null) {
			if (StringUtils.isNotBlank(st.getName())) {
				query.setString("name", "%" + st.getName() + "%");
			}
		}
	}
	@Override
	public List<VideoEntity> finds(VideoEntitySearch st, Boolean all,
			int start, int limit) throws Exception {
		List<VideoEntity> ret = null;
		try {
			String hql = this.getHql(st);
			Query query = this.getCurrentSession().createQuery(hql.toString());
			this.setQueryParams(st, query);
			if (!all) {
				query.setFirstResult(start);
				query.setMaxResults(limit);
			}
			ret = (List<VideoEntity>) query.list();
		} catch (Exception e) {
			logger.fatal("Find TopicEntity occur exception.", e);
			throw e;
		}
		return ret;
	}

}
