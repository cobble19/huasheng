package com.cobble.huasheng.dto;

import java.io.Serializable;

public class BaseDTOSearch implements Serializable {
	// paging
	private int start = 0;
	private int limit = 10;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
}
