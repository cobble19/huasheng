package com.cobble.huasheng.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.cobble.huasheng.dao.VideoDAO;
import com.cobble.huasheng.entity.VideoEntity;
import com.cobble.huasheng.entity.VideoEntitySearch;

public class VideoDAOImpl extends CommonDAOImpl implements VideoDAO {

	public void create(VideoEntity t) throws Exception {
		this.getCurrentSession().save(t);

	}

	public void update(VideoEntity t) throws Exception {
		this.getCurrentSession().update(t);

	}

	public List<VideoEntity> finds(VideoEntitySearch st) throws Exception {
		List<VideoEntity> ret = null;
		try {
			 Query query = this.getCurrentSession().createQuery("from VideoEntity");
			 ret = (List<VideoEntity>) query.list();
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public VideoEntity findById(Long id) throws Exception {
		VideoEntity ret = null;
		try {
			ret = (VideoEntity) this.getCurrentSession().get(VideoEntity.class, id);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public long getCount(VideoEntitySearch st) throws Exception {
		long ret = 0;
		try {
			Query query = this.getCurrentSession().createQuery("select count(1) from VideoEntity");
			Object object = query.uniqueResult();
			ret = Long.parseLong(object.toString());
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

}
