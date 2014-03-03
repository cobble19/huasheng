package com.cobble.huasheng.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.cobble.huasheng.dao.ItemDAO;
import com.cobble.huasheng.entity.ItemEntity;
import com.cobble.huasheng.entity.ItemEntitySearch;
import com.cobble.huasheng.entity.VideoEntity;
import com.cobble.huasheng.entity.VideoSrcEntity;
import com.cobble.huasheng.util.ListUtil;

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
			 Query query = this.getCurrentSession().createQuery("from ItemEntity order by hits desc ");
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
			/*Query query = this.getCurrentSession().createQuery("from VideoEntity ve where ve.itemEntity = :itemEntity");
			query = query.setParameter("itemEntity", ret);
			List<VideoEntity> videoEntities = (List<VideoEntity>) query.list();
			List<VideoSrcEntity> videoSrcEntities = new ArrayList<VideoSrcEntity>();
			if (ListUtil.isNotEmpty(videoEntities)) {
				for (int i = 0; i < videoEntities.size(); i++) {
					VideoEntity videoEntity = videoEntities.get(i);
					VideoSrcEntity videoSrcEntity = videoEntity.getVideoSrcEntity();
					videoSrcEntity.getVideoEntities().add(videoEntity);
					if (!videoSrcEntities.contains(videoSrcEntity)) {
						videoSrcEntities.add(videoSrcEntity);
					}
				}
			}
			ret.setVideoSrcEntities(videoSrcEntities);*/
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

	public void delete(ItemEntity tEntity) throws Exception {
		this.getCurrentSession().delete(tEntity);
	}


}
