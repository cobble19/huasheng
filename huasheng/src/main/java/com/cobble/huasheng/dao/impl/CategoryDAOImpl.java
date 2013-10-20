package com.cobble.huasheng.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.cobble.huasheng.dao.CategoryDAO;
import com.cobble.huasheng.entity.CategoryEntity;
import com.cobble.huasheng.entity.CategoryEntitySearch;

public class CategoryDAOImpl extends CommonDAOImpl implements CategoryDAO {

	public void create(CategoryEntity tEntity) throws Exception {
		this.getCurrentSession().save(tEntity);
	}

	public void update(CategoryEntity tEntity) throws Exception {
		this.getCurrentSession().update(tEntity);
	}

	public List<CategoryEntity> finds(CategoryEntitySearch stEntity) throws Exception {
		List<CategoryEntity> ret = null;
		try {
			 Query query = this.getCurrentSession().createQuery("from CategoryEntity");
			 ret = (List<CategoryEntity>) query.list();
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public CategoryEntity findById(Long id) throws Exception {
		CategoryEntity ret = null;
		try {
			ret = (CategoryEntity) this.getCurrentSession().get(CategoryEntity.class, id);
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public long getCount(CategoryEntitySearch stEntity) throws Exception {
		long ret = 0;
		try {
			Query query = this.getCurrentSession().createQuery("select count(1) from CategoryEntity");
			Object object = query.uniqueResult();
			ret = Long.parseLong(object.toString());
		} catch (Exception e) {
			throw e;
		}
		return ret;
	}

	public void delete(CategoryEntity tEntity) throws Exception {
		this.getCurrentSession().delete(tEntity);
	}

}
