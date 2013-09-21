package com.cobble.huasheng.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.cobble.huasheng.dao.UserDAO;
import com.cobble.huasheng.entity.UserEntity;
import com.cobble.huasheng.entity.UserEntitySearch;

public class UserDAOImpl extends CommonDAOImpl implements UserDAO {
	private static final long serialVersionUID = -6148872554709996703L;
	private final static Logger logger = Logger.getLogger(UserDAOImpl.class);

	public void create(UserEntity userEntity) throws Exception {
		try {
			this.getCurrentSession().save(userEntity);
		} catch (Exception e) {
			logger.fatal("添加用户 occurs Exception", e);
			throw e;
		}
	}

	public void update(UserEntity userEntity) throws Exception {
		try {
			this.getCurrentSession().update(userEntity);
		} catch (Exception e) {
			logger.fatal("更新用户 occurs Exception", e);
			throw e;
		}
	}

	public List<UserEntity> finds(UserEntitySearch userEntitySearch)
			throws Exception {
		List<UserEntity> ret = null;
		try {
			 Query query = this.getCurrentSession().createQuery("from UserEntity");
			 ret = (List<UserEntity>) query.list();
		} catch (Exception e) {
			logger.fatal("查询用户 occurs Exception", e);
			throw e;
		}
		return ret;
	}

	public UserEntity findById(Long userId) throws Exception {
		UserEntity ret = null;
		try {
			ret = (UserEntity) this.getCurrentSession().get(UserEntity.class, userId);
		} catch (Exception e) {
			logger.fatal("查询用户byId occurs Exception", e);
			throw e;
		}
		return ret;
	}

	public long getCount(UserEntitySearch userEntitySearch) throws Exception {
		long ret = 0;
		try {
			Query query = this.getCurrentSession().createQuery("select count(1) from UserEntity");
			Object object = query.uniqueResult();
			ret = Long.parseLong(object.toString());
		} catch (Exception e) {
			logger.fatal("得到用户个数 occurs Exception", e);
			throw e;
		}
		return ret;
	}

}
