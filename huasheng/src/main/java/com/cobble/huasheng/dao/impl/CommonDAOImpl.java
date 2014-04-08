package com.cobble.huasheng.dao.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CommonDAOImpl implements Serializable {
	private static final Logger logger = Logger.getLogger(CommonDAOImpl.class);
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession() {
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();
		} catch (Exception e) {
			logger.fatal("Get hibernate session exception.", e);
		}
		if (session == null) {
			try {
				session = this.getSessionFactory().openSession();
			} catch (Exception e) {
				logger.fatal("Get hibernate session exception.", e);
			}
		}
		return session;
	}
}
