package com.cobble.huasheng.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.cobble.huasheng.dao.TopicDAO;
import com.cobble.huasheng.entity.TopicEntity;
import com.cobble.huasheng.entity.TopicEntitySearch;
import com.cobble.huasheng.entity.UserEntity;

public class TopicDAOImpl extends CommonDAOImpl implements TopicDAO {

	public void create(TopicEntity t) throws Exception {
		this.getCurrentSession().save(t);

	}

	public void update(TopicEntity t) throws Exception {
		this.getCurrentSession().update(t);

	}

	public List<TopicEntity> finds(TopicEntitySearch st) throws Exception {
		List<TopicEntity> ret = null;
		try {
			 Query query = this.getCurrentSession().createQuery("from TopicEntity");
			 ret = (List<TopicEntity>) query.list();
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public TopicEntity findById(Long id) throws Exception {
		TopicEntity ret = null;
		try {
			ret = (TopicEntity) this.getCurrentSession().get(TopicEntity.class, id);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public long getCount(TopicEntitySearch st) throws Exception {
		long ret = 0;
		try {
			Query query = this.getCurrentSession().createQuery("select count(1) from TopicEntity");
			Object object = query.uniqueResult();
			ret = Long.parseLong(object.toString());
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

}