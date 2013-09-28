package com.cobble.huasheng.action;

import org.apache.log4j.Logger;


public class VideoplayAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(VideoplayAction.class);
	private String url;
	
	@Override
	public String execute() throws Exception {
		logger.debug("execute() start...");
		return this.SUCCESS;
	}
	
	public String play() throws Exception {
		return this.SUCCESS;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


}
