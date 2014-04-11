package com.cobble.huasheng.springsecurity.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.cobble.huasheng.dao.impl.CommonDAOImpl;
import com.cobble.huasheng.entity.TopicEntity;
import com.cobble.huasheng.entity.TopicEntitySearch;
import com.cobble.huasheng.springsecurity.dao.UserDAO;
import com.cobble.huasheng.springsecurity.entity.RoleEntity;
import com.cobble.huasheng.springsecurity.entity.UserEntity;
import com.cobble.huasheng.springsecurity.entity.UserEntitySearch;
import com.cobble.huasheng.util.ListUtil;

public class UserDAOImpl extends CommonDAOImpl implements UserDAO {
	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Override
	public void create(UserEntity tEntity) throws Exception {
		try {
			this.getCurrentSession().save(tEntity);
		} catch (Exception e) {
			logger.fatal("Create occur exception.", e);
			throw e;
		}
	}

	@Override
	public void update(UserEntity tEntity) throws Exception {
		try {
			this.getCurrentSession().update(tEntity);
		} catch (Exception e) {
			logger.fatal("Update occur exception.", e);
			throw e;
		}
	}

	private String getHql(UserEntitySearch st) {
		StringBuilder hql = new StringBuilder("from UserEntity t where 1 > 0 ");
		if (st != null) {
			if (StringUtils.isNotBlank(st.getUserName())) {
				hql.append(" and t.userName like " + ":userName");
			}
		}
		return hql.toString();
	}
	private void setQueryParams(UserEntitySearch st, Query query) {
		if (st != null) {
			if (StringUtils.isNotBlank(st.getUserName())) {
				query.setString("userName", "%" + st.getUserName() + "%");
			}
		}
	}
	@Override
	public List<UserEntity> finds(UserEntitySearch st, Boolean all, int start,
			int limit) throws Exception {
		List<UserEntity> ret = null;
		try {
			String hql = this.getHql(st);
			Query query = this.getCurrentSession().createQuery(hql.toString());
			this.setQueryParams(st, query);
			if (!all) {
				query.setFirstResult(start);
				query.setMaxResults(limit);
			}
			ret = (List<UserEntity>) query.list();
		} catch (Exception e) {
			logger.fatal("Find occur exception.", e);
			throw e;
		}
		return ret;
	}

	@Override
	public UserEntity findById(Long id) throws Exception {
		UserEntity ret = null;
		try {
			ret = (UserEntity) this.getCurrentSession().get(UserEntity.class, id);
		} catch (Exception e) {
			logger.fatal("Find occur exception.", e);
			throw e;
		}
		return ret;
	}

	@Override
	public long getCount(UserEntitySearch stEntity) throws Exception {
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
	public void delete(UserEntity tEntity) throws Exception {
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
	public List<RoleEntity> findRolesByUserName(String userName)
			throws Exception {
		List<RoleEntity> ret = null;
		try {
			StringBuilder sb = new StringBuilder("select role from RoleEntity role");
			sb.append(" join role.userEntities user ");
			sb.append(" where 1 > 0 ");
			sb.append(" and user.userName = :userName");
			Query query = this.getCurrentSession().createQuery(sb.toString());
			query.setString("userName", userName);
			ret = (List<RoleEntity>) query.list();
		} catch (Exception e) {
			logger.fatal("Find Role by userName occur exception.", e);
			throw e;
		}
		return ret;
	}

	@Override
	public UserEntity findByUserName(String userName) throws Exception {
		UserEntity ret = null;
		try {
			StringBuilder sb = new StringBuilder("from UserEntity user ");
			sb.append(" where 1 > 0 ");
			sb.append(" and user.userName = :userName");
			Query query = this.getCurrentSession().createQuery(sb.toString());
			query.setString("userName", userName);
			List<UserEntity> userEntities = (List<UserEntity>) query.list();
			if (ListUtil.isNotEmpty(userEntities)) {
				ret = userEntities.get(0);
			}
		} catch (Exception e) {
			logger.fatal("Find user by userName occur exception.", e);
			throw e;
		}
		return ret;
	}

	@Override
	public void changePwd(UserEntity userEntity) throws Exception {
		try {
			StringBuilder sb = new StringBuilder("update UserEntity user ");
			sb.append(" set user.password = :password ");
			sb.append(" where user.userId = :userId");
			Query query = this.getCurrentSession().createQuery(sb.toString());
			query.setString("password", userEntity.getPassword());
			query.setLong("userId", userEntity.getUserId());
			int count = query.executeUpdate();
		} catch (Exception e) {
			logger.fatal("Find user by userName occur exception.", e);
			throw e;
		}
		return ;
	}

}
