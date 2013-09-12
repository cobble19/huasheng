package com.cobble.huasheng.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.cobble.huasheng.dao.UserDAO;
import com.cobble.huasheng.entity.UserEntity;
import com.cobble.huasheng.entity.UserEntitySearch;

public class UserDAOImpl implements UserDAO {
	private final static Logger logger = Logger.getLogger(UserDAOImpl.class);
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(UserEntity userEntity) throws Exception {
		try {
			this.getSessionFactory().openSession().save(userEntity);
		} catch (Exception e) {
			logger.fatal("添加用户 occurs Exception", e);
			throw e;
		}
	}

	public void update(UserEntity userEntity) throws Exception {
		try {
			this.getSessionFactory().openSession().update(userEntity);
		} catch (Exception e) {
			logger.fatal("更新用户 occurs Exception", e);
			throw e;
		}
	}

	public List<UserEntity> finds(UserEntitySearch userEntitySearch)
			throws Exception {
		List<UserEntity> ret = null;
		try {
			 Query query = this.getSessionFactory().openSession().createQuery("from UserEntity");
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
			ret = (UserEntity) this.getSessionFactory().openSession().get(UserEntity.class, userId);
		} catch (Exception e) {
			logger.fatal("查询用户byId occurs Exception", e);
			throw e;
		}
		return ret;
	}

	public long getCount(UserEntitySearch userEntitySearch) throws Exception {
		long ret = 0;
		try {
			Query query = this.getSessionFactory().openSession().createQuery("select count(1) from UserEntity");
			Object object = query.uniqueResult();
			ret = Long.parseLong(object.toString());
		} catch (Exception e) {
			logger.fatal("得到用户个数 occurs Exception", e);
			throw e;
		}
		return 0;
	}

}
