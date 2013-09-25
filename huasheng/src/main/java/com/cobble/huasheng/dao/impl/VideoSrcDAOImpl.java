package com.cobble.huasheng.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.cobble.huasheng.dao.VideoSrcDAO;
import com.cobble.huasheng.entity.VideoSrcEntity;
import com.cobble.huasheng.entity.VideoSrcEntitySearch;

public class VideoSrcDAOImpl extends CommonDAOImpl implements VideoSrcDAO {

	public void create(VideoSrcEntity t) throws Exception {
		this.getCurrentSession().save(t);

	}

	public void update(VideoSrcEntity t) throws Exception {
		this.getCurrentSession().update(t);

	}

	public List<VideoSrcEntity> finds(VideoSrcEntitySearch st) throws Exception {
		List<VideoSrcEntity> ret = null;
		try {
			 Query query = this.getCurrentSession().createQuery("from VideoSrcEntity");
			 ret = (List<VideoSrcEntity>) query.list();
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public VideoSrcEntity findById(Long id) throws Exception {
		VideoSrcEntity ret = null;
		try {
			ret = (VideoSrcEntity) this.getCurrentSession().get(VideoSrcEntity.class, id);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public long getCount(VideoSrcEntitySearch st) throws Exception {
		long ret = 0;
		try {
			Query query = this.getCurrentSession().createQuery("select count(1) from VideoSrcEntity");
			Object object = query.uniqueResult();
			ret = Long.parseLong(object.toString());
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

}
