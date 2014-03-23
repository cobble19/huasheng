package com.cobble.huasheng.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.cobble.huasheng.dao.VideoSrcDAO;
import com.cobble.huasheng.entity.TopicEntity;
import com.cobble.huasheng.entity.TopicEntitySearch;
import com.cobble.huasheng.entity.VideoSrcEntity;
import com.cobble.huasheng.entity.VideoSrcEntitySearch;

public class VideoSrcDAOImpl extends CommonDAOImpl implements VideoSrcDAO {
	private static final Logger logger = Logger.getLogger(VideoSrcDAOImpl.class);

	public void create(VideoSrcEntity t) throws Exception {
		try {
			this.getCurrentSession().save(t);
		} catch (Exception e) {
			logger.fatal("Create occur exception.", e);
			throw e;
		}

	}

	public void update(VideoSrcEntity t) throws Exception {
		try {
			this.getCurrentSession().update(t);
		} catch (Exception e) {
			logger.fatal("Update occur exception.", e);
			throw e;
		}
	}

	public VideoSrcEntity findById(Long id) throws Exception {
		VideoSrcEntity ret = null;
		try {
			ret = (VideoSrcEntity) this.getCurrentSession().get(VideoSrcEntity.class, id);
		} catch (Exception e) {
			logger.fatal("Find by id occur exception.", e);
			throw e;
		}
		return ret;
	}

	public void delete(VideoSrcEntity tEntity) throws Exception {
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

	private String getHql(VideoSrcEntitySearch st) {
		StringBuilder hql = new StringBuilder("from VideoSrcEntity where 1 > 0 ");
		if (st != null) {
			if (StringUtils.isNotBlank(st.getName())) {
				hql.append(" and name like " + ":name");
			}
		}
		return hql.toString();
	}
	private void setQueryParams(VideoSrcEntitySearch st, Query query) {
		if (st != null) {
			if (StringUtils.isNotBlank(st.getName())) {
				query.setString("name", "%" + st.getName() + "%");
			}
		}
	}
	@Override
	public List<VideoSrcEntity> finds(VideoSrcEntitySearch st, Boolean all,
			int start, int limit) throws Exception {
		List<VideoSrcEntity> ret = null;
		try {
			String hql = this.getHql(st);
			Query query = this.getCurrentSession().createQuery(hql.toString());
			this.setQueryParams(st, query);
			if (!all) {
				query.setFirstResult(start);
				query.setMaxResults(limit);
			}
			ret = (List<VideoSrcEntity>) query.list();
		} catch (Exception e) {
			logger.fatal("Find occur exception.", e);
			throw e;
		}
		return ret;
	}

	public long getCount(VideoSrcEntitySearch st) throws Exception {
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

}
