package com.cobble.huasheng.manage.action;

import org.apache.log4j.Logger;

import com.cobble.huasheng.action.BaseAction;


public class IndexAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(IndexAction.class);
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		return this.SUCCESS;
	}

}
