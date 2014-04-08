package com.cobble.huasheng.springsecurity.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.cobble.huasheng.dao.impl.CommonDAOImpl;
import com.cobble.huasheng.springsecurity.dao.PrivilegeDAO;
import com.cobble.huasheng.springsecurity.entity.PrivilegeEntity;
import com.cobble.huasheng.springsecurity.entity.PrivilegeEntitySearch;
import com.cobble.huasheng.springsecurity.entity.RoleEntity;
import com.cobble.huasheng.springsecurity.entity.RoleEntitySearch;

public class PrivilegeDAOImpl extends CommonDAOImpl implements PrivilegeDAO {
	private static final Logger logger = Logger.getLogger(PrivilegeDAOImpl.class);
	
	@Override
	public void create(PrivilegeEntity tEntity) throws Exception {
		try {
			this.getCurrentSession().save(tEntity);
		} catch (Exception e) {
			logger.fatal("Create occur exception.", e);
			throw e;
		}
	}

	@Override
	public void update(PrivilegeEntity tEntity) throws Exception {
		try {
			this.getCurrentSession().update(tEntity);
		} catch (Exception e) {
			logger.fatal("Update occur exception.", e);
			throw e;
		}
	}

	private String getHql(PrivilegeEntitySearch st) {
		StringBuilder hql = new StringBuilder("from PrivilegeEntity t where 1 > 0 ");
		if (st != null) {
			if (StringUtils.isNotBlank(st.getResource())) {
				hql.append(" and t.resource like " + ":resource");
			}
		}
		return hql.toString();
	}
	private void setQueryParams(PrivilegeEntitySearch st, Query query) {
		if (st != null) {
			if (StringUtils.isNotBlank(st.getResource())) {
				query.setString("resource", "%" + st.getResource() + "%");
			}
		}
	}
	@Override
	public List<PrivilegeEntity> finds(PrivilegeEntitySearch st, Boolean all,
			int start, int limit) throws Exception {
		List<PrivilegeEntity> ret = null;
		try {
			String hql = this.getHql(st);
			Query query = this.getCurrentSession().createQuery(hql.toString());
			this.setQueryParams(st, query);
			if (!all) {
				query.setFirstResult(start);
				query.setMaxResults(limit);
			}
			ret = (List<PrivilegeEntity>) query.list();
		} catch (Exception e) {
			logger.fatal("Find occur exception.", e);
			throw e;
		}
		return ret;
	}

	@Override
	public PrivilegeEntity findById(Long id) throws Exception {
		PrivilegeEntity ret = null;
		try {
			ret = (PrivilegeEntity) this.getCurrentSession().get(PrivilegeEntity.class, id);
		} catch (Exception e) {
			logger.fatal("Find occur exception.", e);
			throw e;
		}
		return ret;
	}

	@Override
	public long getCount(PrivilegeEntitySearch stEntity) throws Exception {
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
	public void delete(PrivilegeEntity tEntity) throws Exception {
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

	@Override
	public List<String> getResourcesByRoleName(String roleName) throws Exception {
		List<String> ret = null;
		try {
			StringBuilder sb = new StringBuilder("select p.resource from PrivilegeEntity p");
			sb.append(" join p.roleEntities r ");
			sb.append(" where 1 > 0 ");
			sb.append(" and r.roleName = :roleName");
			Query query = this.getCurrentSession().createQuery(sb.toString());
			query.setString("roleName", roleName);
			ret = (List<String>) query.list();
		} catch (Exception e) {
			logger.fatal("Find privilege occur exception.", e);
			throw e;
		}
		return ret;
	}

}
