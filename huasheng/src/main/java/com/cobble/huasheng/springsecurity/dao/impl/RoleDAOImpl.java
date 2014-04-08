package com.cobble.huasheng.springsecurity.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.cobble.huasheng.dao.impl.CommonDAOImpl;
import com.cobble.huasheng.springsecurity.dao.RoleDAO;
import com.cobble.huasheng.springsecurity.entity.RoleEntity;
import com.cobble.huasheng.springsecurity.entity.RoleEntitySearch;
import com.cobble.huasheng.springsecurity.entity.UserEntity;
import com.cobble.huasheng.springsecurity.entity.UserEntitySearch;

public class RoleDAOImpl extends CommonDAOImpl implements RoleDAO {
	private static final Logger logger = Logger.getLogger(RoleDAOImpl.class);

	@Override
	public void create(RoleEntity tEntity) throws Exception {
		try {
			this.getCurrentSession().save(tEntity);
		} catch (Exception e) {
			logger.fatal("Create occur exception.", e);
			throw e;
		}
	}

	@Override
	public void update(RoleEntity tEntity) throws Exception {
		try {
			this.getCurrentSession().update(tEntity);
		} catch (Exception e) {
			logger.fatal("Update occur exception.", e);
			throw e;
		}
	}
	private String getHql(RoleEntitySearch st) {
		StringBuilder hql = new StringBuilder("from RoleEntity t where 1 > 0 ");
		if (st != null) {
			if (StringUtils.isNotBlank(st.getRoleName())) {
				hql.append(" and t.roleName like " + ":roleName");
			}
		}
		return hql.toString();
	}
	private void setQueryParams(RoleEntitySearch st, Query query) {
		if (st != null) {
			if (StringUtils.isNotBlank(st.getRoleName())) {
				query.setString("roleName", "%" + st.getRoleName() + "%");
			}
		}
	}
	@Override
	public List<RoleEntity> finds(RoleEntitySearch st, Boolean all, int start,
			int limit) throws Exception {
		List<RoleEntity> ret = null;
		try {
			String hql = this.getHql(st);
			Query query = this.getCurrentSession().createQuery(hql.toString());
			this.setQueryParams(st, query);
			if (!all) {
				query.setFirstResult(start);
				query.setMaxResults(limit);
			}
			ret = (List<RoleEntity>) query.list();
		} catch (Exception e) {
			logger.fatal("Find occur exception.", e);
			throw e;
		}
		return ret;
	}

	@Override
	public RoleEntity findById(Long id) throws Exception {
		RoleEntity ret = null;
		try {
			ret = (RoleEntity) this.getCurrentSession().get(RoleEntity.class, id);
		} catch (Exception e) {
			logger.fatal("Find occur exception.", e);
			throw e;
		}
		return ret;
	}

	@Override
	public long getCount(RoleEntitySearch stEntity) throws Exception {
		long ret = 0;
		try {
			String hql = "select count(*) ";
			hql += this.getHql(stEntity);
			Query query = this.getCurrentSession().createQuery(hql);
			this.setQueryParams(stEntity, query);
			Object object = query.uniqueResult();
			ret = Long.parseLong(object.toString());
		} catch (Exception e) {
			logger.fatal("Get count occur exception.", e);
			throw e;
		}
		return ret;
	}

	@Override
	public void delete(RoleEntity tEntity) throws Exception {
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
