package com.cobble.huasheng.action;

import org.apache.commons.lang3.StringUtils;
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
		String queryString = request.getQueryString();
		String prefix = "url=";
		if (StringUtils.isNotEmpty(queryString) && url.length() > prefix.length()) {
			url = queryString.substring(prefix.length());
		}
		return this.SUCCESS;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


}
